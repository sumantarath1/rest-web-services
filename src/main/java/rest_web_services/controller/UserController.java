package rest_web_services.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest_web_services.entity.User;
import rest_web_services.exception.UserNotFoundException;
import rest_web_services.service.UserDaoService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> getAllUser() {

        return  userDaoService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public Optional<User> getAllUser(@PathVariable String id) throws UserNotFoundException {
        return userDaoService.findUserById(id);

    }

    @PostMapping(path = "/users")
    public String addUser(@Valid @RequestBody User user) {
        userDaoService.addUser(user);
        return "success";
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) throws UserNotFoundException {
        Optional<User> userOptional=userDaoService.findUserById(id);
        if (userOptional.isPresent()) {
            userDaoService.deleteUser(id);
            return ResponseEntity.ok().body("User with ID " + id + " deleted successfully.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User with ID " + id + " not found.");
    }

}
