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

import pt.iade.JustReady.models.TablePalco;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.TablePalcoRepository;


@RestController
@RequestMapping(path = "/api/tp")
public class TablePalcoController {

    private Logger logger = LoggerFactory.getLogger(TablePalcoController.class);
    @Autowired
    private TablePalcoRepository tpRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TablePalco> getTablePalco() {
        logger.info("Sending all tp");
        return tpRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TablePalco getTablePalco(@PathVariable int id) {
        logger.info("Sending tp with id " + id);
        Optional<TablePalco> _tp = tpRepository.findById(id);
        if (!_tp.isPresent())
            throw new NotFoundException("" + id, "tp", "id");
        else
            return _tp.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public TablePalco saveTablePalco(@RequestBody TablePalco tablePalco) {
        TablePalco savedTablePalco = tpRepository.save(tablePalco);
        logger.info("Saving tp with id " + savedTablePalco.getPal_id());
        return savedTablePalco;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTablePalco(@PathVariable int id) {
        logger.info("Deleting tp with id " + id);
        // No verification to see if it exists
        tpRepository.deleteById(id);
        return new Response("Deleted tp with id " + id, null);
    }
    
}
