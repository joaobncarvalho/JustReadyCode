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

import pt.iade.JustReady.models.EdicaoFestival;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.EdicaoFestivalRepository;



@RestController
@RequestMapping(path = "/api/edicaofestival")
public class EdicaoFestivalController {
    private Logger logger = LoggerFactory.getLogger(EdicaoFestivalController.class);
    @Autowired
    private EdicaoFestivalRepository edicaofestivalRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EdicaoFestival> getEdicaoFestival() {
        logger.info("Sending all edicaofestival");
        return edicaofestivalRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EdicaoFestival getEdicaoFestival(@PathVariable int id) {
        logger.info("Sending edicaofestival with id " + id);
        Optional<EdicaoFestival> _edicaofestival = edicaofestivalRepository.findById(id);
        if (_edicaofestival.isEmpty())
            throw new NotFoundException("" + id, "EdicaoFestival", "id");
        else
            return _edicaofestival.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public EdicaoFestival saveEdicaoFestival(@RequestBody EdicaoFestival edicaoFestival) {
        EdicaoFestival savedEdicaoFestival = edicaofestivalRepository.save(edicaoFestival);
        logger.info("Saving edicaofestival with id " + savedEdicaoFestival.getEdi_id());
        return savedEdicaoFestival;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEdicaoFestival(@PathVariable int id) {
        logger.info("Deleting edicaofestival with id " + id);
        // No verification to see if it exists
        edicaofestivalRepository.deleteById(id);
        return new Response("Deleted edicaofestival with id " + id, null);
    }

    
}
