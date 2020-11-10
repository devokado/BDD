package webservices.User;

import org.springframework.http.MediaType;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.util.Assert;
import webservices.User.UserNotFoundException;
import webservices.User.User;
import webservices.User.UserRepository;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> RetriveAllUser() {

		return userService.getUsers();
	}

	@PostMapping("/users")
	public User CreateUser(@RequestBody User user) {

		if (user != null) {
			user = this.userService.saveUser(user);
		}
		return user;
	}

	@GetMapping("/users/{id}")
	public Optional<User> RetriveUser(@PathVariable Integer id) {
		Assert.notNull(id, "UserId cannot be empty");

		Optional<User> user =  userService.getUser(id);
		
		if (!(user.isPresent())) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}

	@DeleteMapping("/users/{id}")
	public void DeleteUser(@PathVariable int id) {

		Assert.notNull(id, "UserId cannot be empty");

		userService.deleteUser(id);
	}

	@PutMapping("/users/{id}")
	public Optional<User> updateUser(@RequestBody User user, @PathVariable int id) {

		Assert.notNull(id, "UserId cannot be empty");
		return userService.putUser(user, id);

	}

}
