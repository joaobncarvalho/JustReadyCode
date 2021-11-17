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

import pt.iade.JustReady.models.RelationShip_type;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.RelationShip_typeRepository;

@RestController
@RequestMapping(path = "/api/rt")
public class RelationShip_TypeController {
    private Logger logger = LoggerFactory.getLogger(RelationShip_TypeController.class);
    @Autowired
    private RelationShip_typeRepository rtRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RelationShip_type> getRelationShip_Type() {
        logger.info("Sending all rt");
        return rtRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RelationShip_type getRelationShip_type(@PathVariable int id) {
        logger.info("Sending rt with id " + id);
        Optional<RelationShip_type> _rt = rtRepository.findById(id);
        if (_rt.isEmpty())
            throw new NotFoundException("" + id, "rt", "id");
        else
            return _rt.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public RelationShip_type saveRelationShip_type(@RequestBody RelationShip_type relationShip_type) {
        RelationShip_type savedRelationShip_type = rtRepository.save(relationShip_type);
        logger.info("Saving rt with id " + savedRelationShip_type.getRel_id());
        return savedRelationShip_type;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRelation_Estado(@PathVariable int id) {
        logger.info("Deleting rt with id " + id);
        // No verification to see if it exists
        rtRepository.deleteById(id);
        return new Response("Deleted rt with id " + id, null);
    }
    
}
