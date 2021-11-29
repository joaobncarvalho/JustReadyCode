package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.TicketType;


public interface TicketTypeRepository extends CrudRepository<TicketType, Integer> {

    String QueryPriceTickets = "select * from ticket_type where tt_price <= 159.99";

    @Query(value = QueryPriceTickets, nativeQuery = true )
    Iterable<TicketType> viewTTprice();


}