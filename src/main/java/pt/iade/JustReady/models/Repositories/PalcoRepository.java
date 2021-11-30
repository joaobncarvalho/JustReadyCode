package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.Palco;

import java.util.Optional;


public interface PalcoRepository extends CrudRepository<Palco, Integer> {

    String QueryPalco = "select * from palco where pal_name = 'Palco Principal'";

    @Query(value = QueryPalco, nativeQuery = true )
    Optional<Palco> viewPalcoByName();

}
