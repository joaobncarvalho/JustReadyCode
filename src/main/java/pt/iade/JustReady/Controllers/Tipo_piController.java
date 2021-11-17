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

import pt.iade.JustReady.models.Tipo_pi;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.Tipo_piRepository;

@RestController
@RequestMapping(path = "/api/tpi")
public class Tipo_piController {

    private Logger logger = LoggerFactory.getLogger(Tipo_piController.class);
    @Autowired
    private Tipo_piRepository tpiRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tipo_pi> getTipo_pi() {
        logger.info("Sending all tipo_pi");
        return tpiRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tipo_pi getTipo_pi(@PathVariable int id) {
        logger.info("Sending tipos_pi with id " + id);
        Optional<Tipo_pi> _tpi = tpiRepository.findById(id);
        if (_tpi.isEmpty())
            throw new NotFoundException("" + id, "tpi", "id");
        else
            return _tpi.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tipo_pi saveTipo_pi(@RequestBody Tipo_pi tipo_pi) {
        Tipo_pi savedTipos_Pi = tpiRepository.save(tipo_pi);
        logger.info("Saving tipos_pi with id " + savedTipos_Pi.getTpi_id());
        return savedTipos_Pi;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTipo_pi(@PathVariable int id) {
        logger.info("Deleting tipos_pi with id " + id);
        // No verification to see if it exists
        tpiRepository.deleteById(id);
        return new Response("Deleted tipos_pi with id " + id, null);
    }

    
}
