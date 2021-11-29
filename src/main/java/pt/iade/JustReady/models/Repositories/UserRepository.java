package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import pt.iade.JustReady.models.Users;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<Users, Integer> {

}

