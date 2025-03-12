package com.nightBot.TradeX.Repository;


import com.nightBot.TradeX.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {

     User findByEmail(String email);
}
