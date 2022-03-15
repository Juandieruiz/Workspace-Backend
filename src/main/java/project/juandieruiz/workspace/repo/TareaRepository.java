package project.juandieruiz.workspace.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.juandieruiz.workspace.model.Tarea;

public interface TareaRepository extends MongoRepository<Tarea, String> {

}
