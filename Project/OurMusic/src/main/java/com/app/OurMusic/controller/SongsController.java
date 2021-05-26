package com.app.OurMusic.controller;

import com.app.OurMusic.model.SongsEntity;
import com.app.OurMusic.model.UsersEntity;
import com.app.OurMusic.repository.PersistanceManager;
import com.app.OurMusic.repository.SongsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private final SongsRepository songsRepository;

    SongsController() {
        songsRepository = new SongsRepository();
    }

    @ResponseBody
    @PostMapping("/insert")
    public ResponseEntity<String> addSong(@RequestBody SongsEntity songsEntity) {
        // check if any field is null
        if (songsEntity.getSinger() == null || songsEntity.getTitle() == null || songsEntity.getLink() == null) {
            return new ResponseEntity<>("Empty field(s)", HttpStatus.BAD_REQUEST);
        }
        // check if link is valid
        try {
            URL url = new URL(songsEntity.getLink());
            URLConnection conn = url.openConnection();
            conn.connect();
        } catch (MalformedURLException e) {
            // the URL is not in a valid form
            return new ResponseEntity<>("The URL is not in a valid form", HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            // the connection couldn't be established
            return new ResponseEntity<>("Can't establish connection", HttpStatus.BAD_REQUEST);
        }

        int result = songsRepository.addSong(songsEntity);
        if (result == 0) {
            return new ResponseEntity<>("Add was successful", HttpStatus.OK);
        } else if (result == -1) {
            return new ResponseEntity<>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Entry already exists", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @GetMapping("/top")
    public List<SongsEntity> getTopSongs() {
        return songsRepository.getTopSongs();
    }

    @ResponseBody
    @GetMapping("/vote/{id}")
    public ResponseEntity<String> voteSong(@PathVariable("id") int id) {
        int result = songsRepository.updateSongVotes(id);
        if (result == 0) {
            return new ResponseEntity<>("Update successful", HttpStatus.OK);
        } else if (result == -1) {
            return new ResponseEntity<>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Entry updated", HttpStatus.OK);
    }
}
