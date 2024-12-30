package sping.api.spingboot.api.User.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sping.api.spingboot.api.User.entity.User;
import sping.api.spingboot.api.User.service.UserService;
import sping.api.spingboot.utils.UrlPath;

import java.util.List;

@RestController
@RequestMapping(UrlPath.Url_API_USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/manager/dashboard")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    public String getManagerDashboard() {
//        return "Welcome Manager!";
//    }
//
//
//    @GetMapping("/employee/tasks")
//    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
//    public String getEmployeeTasks() {
//        return "Employee tasks list";
//    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getByid(id);
    }

    @PostMapping("/users/add")
    public int addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("/users/update/{id}")
    public int updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("/users/delete/{id}")
    public List<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return userService.getAll();
    }
}