package info.hayslip.AlertHoarder.controllers;

import info.hayslip.AlertHoarder.models.User;
import info.hayslip.AlertHoarder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public Iterable getAllAlerts() {
        if (StreamSupport.stream(userRepository.findAll().spliterator(), false).count() > 0) {
           return userRepository.findAll();
        } else {
            throw new ValidationException("No records found.");
        }
    }

}
