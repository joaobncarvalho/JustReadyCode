package pt.iade.JustReady.models.Repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer> { }
