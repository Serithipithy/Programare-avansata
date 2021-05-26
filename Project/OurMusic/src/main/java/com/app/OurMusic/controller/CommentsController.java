package com.app.OurMusic.controller;

import com.app.OurMusic.model.CommentEntity;
import com.app.OurMusic.repository.CommentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsRepository commentsRepository;

    CommentsController() {
        commentsRepository = new CommentsRepository();
    }

    @ResponseBody
    @PostMapping("/insert")
    public ResponseEntity<String> addComment(@RequestBody CommentEntity commentEntity) {
        int result = commentsRepository.addComment(commentEntity);
        if (result == 0) {
            return new ResponseEntity<>("Add was successful", HttpStatus.OK);
        } else if (result == -1) {
            return new ResponseEntity<>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Entry already exists", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @GetMapping("/find/{songId}")
    public List<CommentEntity> getComments(int songId) {
        return commentsRepository.getCommentForSong(songId);
    }
}
