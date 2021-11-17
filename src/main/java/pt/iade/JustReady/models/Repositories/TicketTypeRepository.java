package pt.iade.JustReady.models.Repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.TicketType;


public interface TicketTypeRepository extends CrudRepository<TicketType, Integer> { }