package webservices.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webservices.User.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
