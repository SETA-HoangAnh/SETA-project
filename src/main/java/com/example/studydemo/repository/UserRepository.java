package com.example.studydemo.repository;

import com.example.studydemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(nativeQuery = true,
    value = """
            SELECT u.user_id, u.user_name, u.user_address 
            FROM users u 
            WHERE u.user_name like %?1% and u.user_address like %?2% """)
    List<Users> getUser(String userName, String userAddress);
}
