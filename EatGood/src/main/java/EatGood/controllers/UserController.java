package EatGood.controllers;

import EatGood.model.Status;
import EatGood.model.User;
import EatGood.repo.UserRepo;
import EatGood.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Method to login user
    @PostMapping(path = "/login")
    public String loginUser(@RequestParam String username, @RequestParam String password){
        String result = userService.LoginUser(username,password);
        log.info(result);
        return result;
    }

    //Method to register user
    @PostMapping(path = "/register")
    public String registerUser(@RequestBody User userCreate){
        String result = userService.CreateUser(userCreate);
        log.info(result);
        return result;
    }

//    //Method for getting logged-in user's information form database
    @PostMapping(path = "/loggedInUser")
    public ResponseEntity<User> getLoggedInUser(@RequestParam String username, @RequestParam String password){
        User LoggedInUser = userService.getUserInfo(username, password);
        HttpStatus status = HttpStatus.OK;
        log.info("+++++>" + LoggedInUser);
        return ResponseEntity.status(status).body(LoggedInUser);
    }

    //Method to update a users profile
    @PostMapping(path = "/updateUser")
    public String updateUser(@RequestParam long id, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String username, @RequestParam String password){
        String result = userService.updateUserInfo(id, name, surname, email, username, password);
        log.info(result);
        return result;
    }
}
