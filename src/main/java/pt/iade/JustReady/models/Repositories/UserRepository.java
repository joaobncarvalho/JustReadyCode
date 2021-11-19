package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.JustReady.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {

    String resQuery1 = "SELECT t.*\n" +
            "FROM public.users t\n" +
            "ORDER BY users_bdate DESC";

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getUserOrgId1();


}
