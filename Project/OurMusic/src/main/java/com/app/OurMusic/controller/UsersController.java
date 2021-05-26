package com.app.OurMusic.controller;

import com.app.OurMusic.model.UsersEntity;
import com.app.OurMusic.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController() {
        usersRepository = new UsersRepository();
    }

    @ResponseBody
    @PostMapping("/insert")
    public ResponseEntity<String> addUser(@RequestBody UsersEntity usersEntity) {
        //check if username's length is longer than 30
        if (usersEntity.getUsername().length() > 30 || usersEntity.getUsername().length() < 4) {
            return new ResponseEntity<>("Username must have under 30 letters and more than 4 letters", HttpStatus.BAD_REQUEST);
        }

        //check if password has more that 7 letters
        if (usersEntity.getPassword().length() < 8 && usersEntity.getPassword() != null) {
            return new ResponseEntity<>("Password must have at least 8 letters and numbers", HttpStatus.BAD_REQUEST);
        }

        int result = usersRepository.addUser((usersEntity));
        if (result == 0) {
            return new ResponseEntity<>("Add was successful", HttpStatus.OK);
        } else if (result == -1) {
            return new ResponseEntity<>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Entry already exists", HttpStatus.BAD_REQUEST);
    }


    @ResponseBody
    @GetMapping("/find/{username}/{password}")
    public int findByNameAndPass(@PathVariable("username") String name, @PathVariable("password") String password) {
        return usersRepository.findByNameAndPass(name, password);
    }

    @ResponseBody
    @GetMapping("/find/{username}")
    public UsersEntity findByName(@PathVariable("username") String name) {
        return usersRepository.findByName(name);
    }

    @ResponseBody
    @GetMapping("/find")
    public List<UsersEntity> getAllUsers() {
        return usersRepository.getAllUsers();
    }
}
