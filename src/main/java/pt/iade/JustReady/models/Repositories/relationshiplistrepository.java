package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pt.iade.JustReady.models.TicketType;
import pt.iade.JustReady.models.relationshiplist;
import javax.transaction.Transactional;


public interface relationshiplistrepository extends CrudRepository<relationshiplist, Integer> {

    String QueryFriendsList = "select *\n" +
            "from relationshiplist\n" +
            "where rl_users_idmain = 1;";

    @Query(value = QueryFriendsList, nativeQuery = true )
    Iterable<TicketType> viewFriends();



}
