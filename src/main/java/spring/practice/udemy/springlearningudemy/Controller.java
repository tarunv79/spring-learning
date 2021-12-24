package spring.practice.udemy.springlearningudemy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.practice.udemy.springlearningudemy.exception.UserNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    @Autowired
    UserRepository service;

    @GetMapping(value="/users")
    public List<User> getAllUsers(){
        return service.getUsers();
    }

    @GetMapping(value="/users/{id}")
    public User getUser(@PathVariable int id){
        Optional<User> user =  service.getUser(id);
        if(!user.isPresent())
            throw new UserNotFoundException(id);
        return user.get();
    }
    
    @PostMapping(value="/users")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        User savedUser =  service.save(user);

        //below will return location -> http://localhost:8052/users
        /*URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .build().toUri();*/

        //below will return location -> http://localhost:8052/users/4
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        //this will return the 201 Created HTTP Status code instead of 200 OK
        return ResponseEntity.created(location).build();
    }
    
}
