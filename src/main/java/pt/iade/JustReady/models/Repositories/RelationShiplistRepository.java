package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.RelationShiplist;
import pt.iade.JustReady.models.TicketType;


public interface RelationShiplistRepository extends CrudRepository<RelationShiplist, Integer> {

    String QueryVerifyFriendsOne = "select * from relationshiplist ";

    @Query(value = QueryVerifyFriendsOne, nativeQuery = true )
    Iterable<TicketType> verifyFriendsOne();
}
