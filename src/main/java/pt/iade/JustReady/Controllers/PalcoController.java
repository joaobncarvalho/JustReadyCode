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

import pt.iade.JustReady.models.Palco;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.PalcoRepository;


@RestController
@RequestMapping(path = "/api/pal")
public class PalcoController {

    private Logger logger = LoggerFactory.getLogger(PalcoController.class);
    @Autowired
    private PalcoRepository palRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Palco> getPalco() {
        logger.info("Sending all tp");
        return palRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Palco getPalco(@PathVariable int id) {
        logger.info("Sending tp with id " + id);
        Optional<Palco> _pal = palRepository.findById(id);
        if (!_pal.isPresent())
            throw new NotFoundException("" + id, "pal", "id");
        else
            return _pal.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Palco savePalco(@RequestBody Palco palco) {
        Palco savedPalco = palRepository.save(palco);
        logger.info("Saving tp with id " + savedPalco.getPal_id());
        return savedPalco;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePalco(@PathVariable int id) {
        logger.info("Deleting tp with id " + id);
        // No verification to see if it exists
        palRepository.deleteById(id);
        return new Response("Deleted tp with id " + id, null);
    }
    
}
