package Libreria.CRUD.Service;

import Libreria.CRUD.Model.userModel;
import Libreria.CRUD.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public ArrayList<userModel> getBook(){
    return (ArrayList<userModel>) userRepository.findAll();
    }

    public userModel saveBook(userModel userModel){
        return userRepository.save(userModel);
    }
    public Optional<userModel> getById(Long id){
        return userRepository.findById(id);
    }

    public userModel updateByID(userModel request, Long id){
        userModel user = userRepository.findById(id).orElse(null);

        if (user != null){
            user.setNombre(request.getNombre());
            user.setAutor(request.getAutor());
            user.setCategoria(request.getCategoria());
            user.setPrecio(request.getPrecio());
            user.setEstado(request.getEstado());

            userModel updatedUser = userRepository.save(user);
            return updatedUser;
        }
        return null;
    }

    public Boolean deletebook(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
