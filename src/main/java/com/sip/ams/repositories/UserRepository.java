package com.sip.ams.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.*;

@Repository("userRepository")

public interface UserRepository extends JpaRepository<User, Integer> {

	
	    User findByEmail(String email);
	}

