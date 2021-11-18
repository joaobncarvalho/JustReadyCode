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

import pt.iade.JustReady.models.PontoDeInteresse;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.PontoDeInteresseRepository;



@RestController
@RequestMapping(path = "/api/PontoDeInteresse")
public class PontoDeInteresseController {
    private Logger logger = LoggerFactory.getLogger(PontoDeInteresseController.class);
    @Autowired
    private PontoDeInteresseRepository PontoDeInteresseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PontoDeInteresse> getPontoDeInteresse() {
        logger.info("Sending all PontoDeInteresse ");
        return PontoDeInteresseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PontoDeInteresse getPontoDeInteresse(@PathVariable int id) {
        logger.info("Sending PontoDeInteresse with id " + id);
        Optional<PontoDeInteresse> _PontoDeInteresse = PontoDeInteresseRepository.findById(id);
        if (!_PontoDeInteresse.isPresent())
            throw new NotFoundException("" + id, "PontoDeInteresse", "id");
        else
            return _PontoDeInteresse.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public PontoDeInteresse savePontoDeInteresse(@RequestBody PontoDeInteresse PontoDeInteresse) {
        PontoDeInteresse savedPontoDeInteresse = PontoDeInteresseRepository.save(PontoDeInteresse);
        logger.info("Saving PontoDeInteresse with id " + savedPontoDeInteresse.getPi_id());
        return savedPontoDeInteresse;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePontoDeInteresse(@PathVariable int id) {
        logger.info("Deleting PontoDeInteresse with id " + id);
        // No verification to see if it exists
        PontoDeInteresseRepository.deleteById(id);
        return new Response("Deleted PontoDeInteresse with id " + id, null);
    }
    
}
