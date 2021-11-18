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
@RequestMapping(path = "/api/pontos_de_interesse")
public class Ponto_de_interesseController {
    private Logger logger = LoggerFactory.getLogger(Ponto_de_interesseController.class);
    @Autowired
    private Ponto_de_interesseRepository pontodeinteresseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ponto_de_interesse> getPontos_de_interesse() {
        logger.info("Sending all PI ");
        return pontodeinteresseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ponto_de_interesse getPontos_de_interesse(@PathVariable int id) {
        logger.info("Sending  with id " + id);
        Optional<Ponto_de_interesse> _pontosdeinteresse = pontodeinteresseRepository.findById(id);
        if (!_pontosdeinteresse.isPresent())
            throw new NotFoundException("" + id, "Pontos_de_interesse", "id");
        else
            return _pontosdeinteresse.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ponto_de_interesse savePontos_de_interesse(@RequestBody Ponto_de_interesse pontos_de_interesse) {
        Ponto_de_interesse savedPontos_de_interesse = pontodeinteresseRepository.save(pontos_de_interesse);
        logger.info("Saving pontosdeinteresse with id " + savedPontos_de_interesse.getPi_id());
        return savedPontos_de_interesse;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePontos_de_interesse(@PathVariable int id) {
        logger.info("Deleting pontos_de_interesses with id " + id);
        // No verification to see if it exists
        pontodeinteresseRepository.deleteById(id);
        return new Response("Deleted pontosdeinteresse with id " + id, null);
    }
    
}
