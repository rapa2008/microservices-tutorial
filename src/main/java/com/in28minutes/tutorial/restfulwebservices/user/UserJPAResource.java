package com.in28minutes.tutorial.restfulwebservices.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by RA371996 on 4/7/2019.
 * 200 OK success
 * 201 resource created
 * 404 resource Not Found
 * 401 Unauthorized access
 * 403 forbidden
 * 500 Internal server error
 */
@RestController
@ApiOperation(value = "User Controller")
public class UserJPAResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    @ApiOperation(value = "Method to get User by id")
    public Resource<User> getUserById(@PathVariable Integer id){
        Optional<User> foundUser = userRepository.findById(id);
        if(!foundUser.isPresent())
            throw new ResourceNotFoundException("id=" + id);

        Resource<User> resource = new Resource<User>(foundUser.get());

        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User createdUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable Integer id){
        userRepository.deleteById(id);
    }
}
