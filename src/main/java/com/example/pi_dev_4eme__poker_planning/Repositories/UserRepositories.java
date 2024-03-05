package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
import java.util.List;

public interface UserRepositories extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.Nom_user = :userName")
    User findUsersByNomUser(String userName);
    @Query("SELECT r.Nom_user FROM User r")
    List<String> findAllNOM();
=======
public interface UserRepositories extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.Nom_user = :userName")
    User findUsersByNomUser(String userName);
>>>>>>> fd67307c27fe31ffc313ded020827b3031d97bb2
}

