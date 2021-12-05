package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.RelationShiplist;
import pt.iade.JustReady.models.TicketType;


public interface RelationShiplistRepository extends CrudRepository<RelationShiplist, Integer> {

    String QueryVerifyFriendsOne = "select u1.users_name as username, u2.users_name as username2, rel_name as relname\n" +
            "from relationshiplist\n" +
            "inner join users u1 on rl_users_idmain=u1.users_id\n" +
            "inner join users u2 on rl_users_idfriend=u2.users_id\n" +
            "inner join relationship_type on rl_rel_nameid=rel_id\n" +
            "where u1.users_id=1 and rel_id=1";

    @Query(value = QueryVerifyFriendsOne, nativeQuery = true )
    Iterable<RelationShiplist> verifyFriendsOne();
}
