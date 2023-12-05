package br.com.unifalmg.blog.controller;

import br.com.unifalmg.blog.controller.request.UserRequest;
import br.com.unifalmg.blog.entity.User;
import br.com.unifalmg.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;
    // localhost:8080/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        //User user = service.findById(id);

        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        // List<User> users = service.getAllUsers();
        return ResponseEntity.ok(service.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        service.deleteUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.add(request));
    }
}
