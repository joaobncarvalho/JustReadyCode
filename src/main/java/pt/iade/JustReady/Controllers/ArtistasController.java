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

import pt.iade.JustReady.models.Artistas;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.ArtistasRepository;



@RestController
@RequestMapping(path = "/api/art")
public class ArtistasController {
    private Logger logger = LoggerFactory.getLogger(ArtistasController.class);
    @Autowired
    private ArtistasRepository artistasRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artistas> getArtistas() {
        logger.info("Sending all artistas");
        return artistasRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artistas getArtistas(@PathVariable int id) {
        logger.info("Sending artistas with id " + id);
        Optional<Artistas> _art = artistasRepository.findById(id);
        if (!_art.isPresent())
            throw new NotFoundException("" + id, "art", "id");
        else
            return _art.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artistas saverArtistas(@RequestBody Artistas artistas) {
        Artistas savedArtistas = artistasRepository.save(artistas);
        logger.info("Saving  with id " + savedArtistas.getArt_id());
        return savedArtistas;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteArtistas(@PathVariable int id) {
        logger.info("Deleting artistas with id " + id);
        // No verification to see if it exists
        artistasRepository.deleteById(id);
        return new Response("Deleted artistas with id " + id, null);
    }


    
}
