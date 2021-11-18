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

import pt.iade.JustReady.models.Ponto_de_interesse;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.Ponto_de_interesseRepository;


@RestController
@RequestMapping(path = "/api/Ponto_de_interesse")
public class Ponto_de_interesseController {
    private Logger logger = LoggerFactory.getLogger(Ponto_de_interesseController.class);
    @Autowired
    private Ponto_de_interesseRepository Ponto_de_interesseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ponto_de_interesse> getPonto_de_interesse() {
        logger.info("Sending all Ponto_de_interesse ");
        return Ponto_de_interesseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ponto_de_interesse getPonto_de_interesse(@PathVariable int id) {
        logger.info("Sending ponto_de_interesse with id " + id);
        Optional<Ponto_de_interesse> _Ponto_de_interesse = Ponto_de_interesseRepository.findById(id);
        if (!_Ponto_de_interesse.isPresent())
            throw new NotFoundException("" + id, "Ponto_de_interesse", "id");
        else
            return _Ponto_de_interesse.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ponto_de_interesse savePonto_de_interesse(@RequestBody Ponto_de_interesse ponto_de_interesse) {
        Ponto_de_interesse savedPonto_de_interesse = Ponto_de_interesseRepository.save(ponto_de_interesse);
        logger.info("Saving ponto_de_interesse with id " + savedPonto_de_interesse.getPi_id());
        return savedPonto_de_interesse;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePonto_de_interesse(@PathVariable int id) {
        logger.info("Deleting Ponto_de_interesse with id " + id);
        // No verification to see if it exists
        Ponto_de_interesseRepository.deleteById(id);
        return new Response("Deleted Ponto_de_interesse with id " + id, null);
    }
    
}
