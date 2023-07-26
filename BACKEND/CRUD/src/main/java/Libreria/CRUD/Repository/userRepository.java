package Libreria.CRUD.Repository;

import Libreria.CRUD.Model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "libros", collectionResourceRel = "libros")
//@Repository (path = "libros", collectionResourceRel = "libros")
public interface userRepository extends JpaRepository<userModel, Long> {


}
