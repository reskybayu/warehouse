package warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.warehouse.model.User;
import warehouse.warehouse.repositories.UserRepo;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public ResponseEntity<List<User>>GetAllUser()
    {
        try
        {
            List<User> user = this.userRepo.findAll();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Object> SaveUser(@RequestBody User user) {
        User userData = this.userRepo.save(user);
        try {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception exception) {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> UpdateUser(@RequestBody User user, @PathVariable("id") Long id)
    {
        Optional<User> userData = this.userRepo.findById(id);
        if(userData.isPresent())
        {
            user.setId(id);
            this.userRepo.save(user);
            ResponseEntity rest = new ResponseEntity<>("Success", HttpStatus.OK);
            return rest;
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<User>> GetUserById(@PathVariable("id") Long id)
    {
        try
        {
            Optional<User> user = this.userRepo.findById(id);
            if(user.isPresent())
            {
                ResponseEntity rest = new ResponseEntity<>(user, HttpStatus.OK);
                return rest;
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> DeleteUser(@PathVariable("id") Long id)
    {
        this.userRepo.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
