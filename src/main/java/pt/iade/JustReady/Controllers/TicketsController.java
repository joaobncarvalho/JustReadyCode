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

import pt.iade.JustReady.models.Tickets;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.TicketsRepository;

@RestController
@RequestMapping(path = "/api/tickets")
public class TicketsController {

    private Logger logger = LoggerFactory.getLogger(TicketsController.class);
    @Autowired
    private TicketsRepository ticketsRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tickets> getTickets() {
        logger.info("Sending all tickets");
        return ticketsRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tickets getTickets(@PathVariable int id) {
        logger.info("Sending tickets with id " + id);
        Optional<Tickets> _tickets = ticketsRepository.findById(id);
        if (!_tickets.isPresent())
            throw new NotFoundException("" + id, "tickets", "id");
        else
            return _tickets.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tickets saveTickets(@RequestBody Tickets tickets) {
        Tickets savedTickets = ticketsRepository.save(tickets);
        logger.info("Saving tickets with id " + savedTickets.getTickets_id());
        return savedTickets;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTickets(@PathVariable int id) {
        logger.info("Deleting tickets with id " + id);
        // No verification to see if it exists
        ticketsRepository.deleteById(id);
        return new Response("Deleted tickets with id " + id, null);
    }
    
}
