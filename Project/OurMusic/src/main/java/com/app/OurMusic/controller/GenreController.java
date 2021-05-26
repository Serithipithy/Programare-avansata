package com.app.OurMusic.controller;

import com.app.OurMusic.model.GenreEntity;
import com.app.OurMusic.model.SongsEntity;
import com.app.OurMusic.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreRepository genreRepository;

    GenreController() {
        genreRepository = new GenreRepository();
    }

    @ResponseBody
    @PostMapping("/insert")
    public ResponseEntity<String> addGenreAndSong(@RequestBody int songId, String genre) {
        int result = genreRepository.addSongInGenre(songId, genre);
        if (result == 0) {
            return new ResponseEntity<>("Add was successful", HttpStatus.OK);
        } else if (result == -1) {
            return new ResponseEntity<>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Entry already exists", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @GetMapping("/top/{genre}")
    public List<SongsEntity> getTopSongs(String genre) {
        return genreRepository.getTopSongsGenre(genre);
    }
}
