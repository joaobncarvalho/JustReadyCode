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

import pt.iade.JustReady.models.Pontos_de_interesse;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.Pontos_de_interesseRepository;


@RestController
@RequestMapping(path = "/api/pontos_de_interesse")
public class Pontos_de_interesseController {
    private Logger logger = LoggerFactory.getLogger(Pontos_de_interesseController.class);
    @Autowired
    private Pontos_de_interesseRepository pontosdeinteresseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pontos_de_interesse> getPontos_de_interesse() {
        logger.info("Sending all PI ");
        return pontosdeinteresseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pontos_de_interesse getPontos_de_interesse(@PathVariable int id) {
        logger.info("Sending  with id " + id);
        Optional<Pontos_de_interesse> _pontosdeinteresse = pontosdeinteresseRepository.findById(id);
        if (!_pontosdeinteresse.isPresent())
            throw new NotFoundException("" + id, "Pontos_de_interesse", "id");
        else
            return _pontosdeinteresse.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pontos_de_interesse savePontos_de_interesse(@RequestBody Pontos_de_interesse pontos_de_interesse) {
        Pontos_de_interesse savedPontos_de_interesse = pontosdeinteresseRepository.save(pontos_de_interesse);
        logger.info("Saving pontosdeinteresse with id " + savedPontos_de_interesse.getPi_id());
        return savedPontos_de_interesse;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePontos_de_interesse(@PathVariable int id) {
        logger.info("Deleting pontos_de_interesses with id " + id);
        // No verification to see if it exists
        pontosdeinteresseRepository.deleteById(id);
        return new Response("Deleted pontosdeinteresse with id " + id, null);
    }
    
}
