package rest_web_services.controller;

import org.springframework.web.bind.annotation.*;
import rest_web_services.entity.Post;
import rest_web_services.entity.User;

@RestController("/mbt/post/")
public class PostController {
    @GetMapping(path = "/users/{id}/posts")
    private Object getUserPost() {
        return null;
    }


    @PostMapping(path = "/add/user/{id}/post")
    private String addUserPost(@PathVariable String id,@RequestParam Post post) {
        return null;
    }

    @DeleteMapping(path = "/delete/user/{id}/post/{postId}")
    private String deleteUser(@PathVariable String id,@PathVariable String postId) {
        return null;
    }

}
