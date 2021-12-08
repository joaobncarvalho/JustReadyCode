package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pt.iade.JustReady.models.RelationShiplist;
import javax.transaction.Transactional;


public interface RelationShiplistRepository extends CrudRepository<RelationShiplist, Integer> {
    @Modifying @Transactional
    @Query(value="insert into relationshiplist ( rl_id,rl_rel_nameid, rl_users_ticket,"+
            "rl_users_idmain, rl_users_idfriend)"+
            "values(:#{#relationshiplist.id}, :#{#relationshiplist.nameid}, :#{#relationshiplist.ticket},"+
            ":#{#relationshiplist.idmain}, :#{#relationshiplist.idfriend}", nativeQuery=true)

    Integer registerFriend(@Param("relationshiplist") RelationShiplist relationShiplist);



}
