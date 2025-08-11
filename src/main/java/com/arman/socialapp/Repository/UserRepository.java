package com.arman.socialapp.Repository;

import com.arman.socialapp.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
