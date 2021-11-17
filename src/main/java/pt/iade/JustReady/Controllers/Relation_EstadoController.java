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

import pt.iade.JustReady.models.Relation_Estado;
import pt.iade.JustReady.models.Exceptions.NotFoundException;
import pt.iade.JustReady.models.Exceptions.Response;
import pt.iade.JustReady.models.Repositories.Relation_EstadoRepository;



@RestController
@RequestMapping(path = "/api/relation_estado")
public class Relation_EstadoController {

        private Logger logger = LoggerFactory.getLogger(Relation_EstadoController.class);
        @Autowired
        private Relation_EstadoRepository reRepository;
    
        @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public Iterable<Relation_Estado> getRelation_Estado() {
            logger.info("Sending all re");
            return reRepository.findAll();
        }
    
        @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Relation_Estado getRelation_Estado(@PathVariable int id) {
            logger.info("Sending re with id " + id);
            Optional<Relation_Estado> _re = reRepository.findById(id);
            if (!_re.isPresent())
                throw new NotFoundException("" + id, "re", "id");
            else
                return _re.get();
        }
    
        @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public Relation_Estado saveRelation_Estado(@RequestBody Relation_Estado relation_Estado) {
            Relation_Estado savedRelation_Estado = reRepository.save(relation_Estado);
            logger.info("Saving re with id " + savedRelation_Estado.getSt_id());
            return savedRelation_Estado;
        }
    
        @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Response deleteRelationEstado(@PathVariable int id) {
            logger.info("Deleting Relation_Estado with id " + id);
            // No verification to see if it exists
            reRepository.deleteById(id);
            return new Response("Deleted re with id " + id, null);
        }
    
    

}
