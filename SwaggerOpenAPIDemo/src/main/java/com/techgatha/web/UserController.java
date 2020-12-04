package com.techgatha.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.web.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "userapi")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@Operation(summary = "Get list of all users")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Users not empty"
					,content= {
							@Content(mediaType = "application/json",
							schema=@Schema(implementation = List.class))
					}),
			@ApiResponse(responseCode = "400", description = "Invalid Id Supplied"),
			@ApiResponse(responseCode = "404", description = "Users not found")
	})
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return repository.findAll();
	}
	@Operation(summary = "Get user by iD")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Found User"
					,content= {
							@Content(mediaType = "application/json",
							schema=@Schema(implementation = User.class))
					}),
			@ApiResponse(responseCode = "400", description = "Invalid Id Supplied"),
			@ApiResponse(responseCode = "404", description = "Users not found")
	})
	@GetMapping("/users/{userid}")
	public User getAllUserBYId(@PathVariable String userid)
	{
		return repository.findById(userid).get();
	}
	@Operation(summary = "Inserts a User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description = "User Registered Successfully"
					,content= {
							@Content(mediaType = "application/json",
							schema=@Schema(implementation = User.class))
					}),
			@ApiResponse(responseCode = "400", description = "Invalid Id Supplied"),
			@ApiResponse(responseCode = "404", description = "Users not found")
	})
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User insertUser(@RequestBody User user)
	{
		System.out.println(user);
		User saveUser = user;
		saveUser.setUserid(user.getUserid());
		return repository.save(saveUser);
	}
	
}
