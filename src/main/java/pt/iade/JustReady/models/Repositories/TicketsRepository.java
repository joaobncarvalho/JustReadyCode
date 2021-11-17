package pt.iade.JustReady.models.Repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.Tickets;


public interface TicketsRepository extends CrudRepository<Tickets, Integer> { }
