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

import pt.iade.JustReady.models.TicketType;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.TicketTypeRepository;

@RestController
@RequestMapping(path = "/api/tkt")
public class TicketTypeController {

    private Logger logger = LoggerFactory.getLogger(TicketTypeController.class);
    @Autowired
    private TicketTypeRepository tktRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TicketType> get() {
        logger.info("Sending all ticket type");
        return tktRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketType getTicketType(@PathVariable int id) {
        logger.info("Sending ticket type with id " + id);
        Optional<TicketType> _tkt = tktRepository.findById(id);
        if (!_tkt.isPresent())
            throw new NotFoundException("" + id, "ticket type", "id");
        else
            return _tkt.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketType saveTicketType(@RequestBody TicketType ticketType) {
        TicketType savedTicketType = tktRepository.save(ticketType);
        logger.info("Saving ticket type with id " + savedTicketType.getTt_id());
        return savedTicketType;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTicketType(@PathVariable int id) {
        logger.info("Deleting ticket type with id " + id);
        // No verification to see if it exists
        tktRepository.deleteById(id);
        return new Response("Deleted ticket type with id " + id, null);
    }
    
}
