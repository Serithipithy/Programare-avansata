package com.app.OurMusic.web.controller;

import com.app.OurMusic.controller.client.RequestClient;
import com.app.OurMusic.model.SongsEntity;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("ourmusic")
public class ViewController {

    @RequestMapping(value = "") //start page will always be the one that displays the top
    public String index(Model model) throws IOException, InterruptedException {
        List<SongsEntity> topSongs = null;
        RequestClient topGenerator = new RequestClient();

        topSongs = topGenerator.getTopSongs(); // gets the songs in desc order
        model.addAttribute("songs", topSongs);
        return "ourmusic/index"; //returns the index.html page
    }

    @RequestMapping(value = "addSong", method = RequestMethod.GET) //sends to the addSong.html page
    public String displayAddSongForm(Model model) {
        return "ourmusic/addSong";
    }

    @RequestMapping(value = "addSong", method = RequestMethod.POST) //makes a POST request when a song is added
    public String processAddSongForm(HttpServletRequest request) throws IOException, InterruptedException {
        String songSinger = request.getParameter("songSinger");
        String songTitle = request.getParameter("songTitle");
        String songLink = request.getParameter("songLink");

        RequestClient addSongRequest = new RequestClient();

        addSongRequest.postSongs(songSinger, songTitle, songLink);

        //redirect
        return "redirect:"; // redirects to the previous page, index.html
    }

    @RequestMapping(value = "", method = RequestMethod.POST) //makes a POST request when a song is voted
    public RedirectView processVoteSongForm(HttpServletRequest request) throws IOException, InterruptedException {
        String songId = request.getParameter("songId");

        RequestClient voteRequest = new RequestClient();

        voteRequest.voteSong(Integer.parseInt(songId));
        return new RedirectView("ourmusic");
    }
}
