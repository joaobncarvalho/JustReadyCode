package pt.iade.JustReady.Controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.JustReady.models.Users;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.UserRepository;

import javax.xml.stream.Location;

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

    @GetMapping(path = "/friends", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getFriends() {
        logger.info("Sending all friends");
        return usRepository.viewFriendsusers();
    }

    @GetMapping(path = "/friends1", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getFriends1() {
        logger.info("Sending all friends1");
        return usRepository.viewFriendsusers1();
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

    @GetMapping(path = "/exite/{ticket}/{pass}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("ticket") int ticket, @PathVariable("pass") String pass) {
        logger.info("Sending bio from route ticket: ,pass:" + ticket + pass);
        return usRepository.Users_verification(ticket, pass);
    }

    @GetMapping(path = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getUsers_location() {
        logger.info("Sending all user location");
        return usRepository.viewLocation();
    }

    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users updateUsers(@RequestBody Users users) {
        Users updateUsers = usRepository.save(users);
        logger.info("Saving users with id " + updateUsers.getUsers_id());
        return updateUsers;
    }

}