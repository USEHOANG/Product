package sping.api.spingboot.api.User.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sping.api.spingboot.api.User.entity.User;
import sping.api.spingboot.api.User.service.UserService;
import sping.api.spingboot.utils.UrlPath;

import java.util.List;

@RestController
@RequestMapping(UrlPath.Url_API_USERS)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getByid(id);
    }

    @PostMapping("/add")
    public int addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("update/{id}")
    public int updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @PostMapping("delete/{id}")
    public List<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return userService.getAll();
    }

}
