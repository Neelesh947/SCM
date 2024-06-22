package in.neelesh.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.neelesh.scm.dto.UserDto;
import in.neelesh.scm.model.User;
import in.neelesh.scm.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create-user")
	public ResponseEntity<User> createUser(@ModelAttribute UserDto userDto) throws Exception{
		User createUser=this.userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
}
