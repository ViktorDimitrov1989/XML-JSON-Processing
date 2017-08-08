package app.repositories;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u WHERE u.soldProducts.size > 0" +
            " ORDER BY u.soldProducts.size DESC, u.lastName ASC")
    List<User> findAllSuccessSellers();

    @Query("SELECT u FROM User AS u WHERE u.soldProducts.size > 0" +
            " ORDER BY u.lastName ASC, u.firstName ASC")
    List<User> findAllUserWithAtleastOneSoldProduct();

}
