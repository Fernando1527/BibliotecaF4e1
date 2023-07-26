package Libreria.CRUD.Controller;

import Libreria.CRUD.Model.userModel;
import Libreria.CRUD.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/administrarlibros")

public class controller {

    @Autowired
    userService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ArrayList<userModel> getBook() {
        return this.userService.getBook();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public userModel savebook(@RequestBody userModel userModel) {
        return this.userService.saveBook(userModel);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<userModel> getUserByID(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    public userModel updateUserByID(@RequestBody userModel request, @PathVariable("id") Long id) {
        return this.userService.updateByID(request, id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String deletebook(@PathVariable("id") Long id) {
        boolean ok = this.userService.deletebook(id);
        if (ok) {
            return "El libro " + id + ", ha sido eliminado! ";
        } else {
            return "Error, we had a problem deleting this user with ID " + id;
        }
    }
}
