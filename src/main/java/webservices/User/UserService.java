package webservices.User;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(User user) {
		
		if(logger.isInfoEnabled()) {
			logger.info("User is saved with details {}", user.toString());
		}
		return this.userRepository.save(user);
	}
	public List<User> saveUsers(List<User> users) {

		if (logger.isInfoEnabled()) {
			logger.info("users is saved with details {}", users);
		}
		return this.userRepository.saveAll(users);
	}
	public Optional<User> getUser(Integer Id) {

		if (logger.isInfoEnabled()) {
			logger.info("Getting User with Id {}", Id);
		}
		return this.userRepository.findById(Id);

	}

	public List<User> getUsers() {

		return this.userRepository.findAll();
	}
	
	public void deleteUser(Integer id) {
		
		this.userRepository.deleteById(id);
	}
	public Optional<User> putUser(User user,Integer id) {
		
		if (logger.isInfoEnabled()) {
			logger.info("Updating User with Id {}", id);
		}
		Optional<User> userOptional = this.userRepository.findById(id);
		if (!userOptional.isPresent())
			return null;
	
		user.setId(id);
		
		userRepository.save(user);

		return userRepository.findById(id);
		
	}
	
	
}
