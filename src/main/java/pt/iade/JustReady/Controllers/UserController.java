package pt.iade.JustReady.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.JustReady.models.Users;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository usRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getUser() {
        logger.info("Sending all user");
        return usRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users getUsers(@PathVariable int id) {
        logger.info("Sending user with id " + id);
        Optional<Users> _us = usRepository.findById(id);
        if (!_us.isPresent())
            throw new NotFoundException("" + id, "User", "id");
        else
            return _us.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users saveUsers(@RequestBody Users users) {
        Users savedUsers = usRepository.save(users);
        logger.info("Saving users with id " + savedUsers.getUsers_id());
        return savedUsers;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUsers(@PathVariable int id) {
        logger.info("Deleting users with id " + id);
        // No verification to see if it exists
        usRepository.deleteById(id);
        return new Response("Deleted users with id " + id, null);
    }
    @GetMapping(path = "/not/1", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getUserOrgId1() {
        return usRepository.getUserOrgId1();
    }
    
}
