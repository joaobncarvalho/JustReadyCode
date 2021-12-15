package pt.iade.JustReady.models.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import pt.iade.JustReady.models.TicketType;
import pt.iade.JustReady.models.relationshiplist;
import pt.iade.JustReady.models.Users;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    String QueryFriends = "\n" +
            "select *\n" +
            "from users\n" +
            "where users_id=2;";

    @Query(value = QueryFriends, nativeQuery = true )
    Iterable<Users> viewFriendsusers();

    String QueryFriends1 = "\n" +
            "select *\n" +
            "from users\n" +
            "where users_id=3;";

    @Query(value = QueryFriends1, nativeQuery = true )
    Iterable<Users> viewFriendsusers1();

    String QueryLogin = "\n" +
            "select *\n" +
            "from users\n" +
            "where users_id=3;";

    @Query(value = QueryLogin, nativeQuery = true )
    Iterable<Users> viewLogin();

    @Query(value = "'select users_verification(:ticket,:pass)'", nativeQuery = true)
    Iterable<String> Users_verification(int ticket, String pass);

    String QueryLocation = "\n" +
            "select *\n" +
            "from users\n" +
            "where users_id=2;";

    @Query(value = QueryLocation, nativeQuery = true )
    Iterable<Users> viewLocation();

    @Modifying @Transactional
    @Query(value="'Update users set '"+
            "'users_locationlong = :long,'" +
            "'users_locationlat = :lat,'"+
            "'where users_id = :id'", nativeQuery=true)
    Integer locationData(@Param("id") int regId,
                         @Param("location") double location);

    Integer updateLocation(int regId, float users_locationlong, float users_locationlat);

    /*@Modifying @Transactional
    @Query(value="'Update users set '"+
            "'users_locationlat = :lat,'"+
            "'where users_id = :id'", nativeQuery=true)
    Integer locationData1(@Param("id") int regId,
                         @Param("location") double location);*/


    Integer updateLocation1(int regId, float users_locationlat);


}

