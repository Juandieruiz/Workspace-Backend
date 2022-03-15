package project.juandieruiz.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.juandieruiz.workspace.model.Tarea;
import project.juandieruiz.workspace.repo.TareaRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("")
    List<Tarea> index(){
        return tareaRepository.findAll();
    };

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Tarea create(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    };

    @PutMapping("{id}")
    Tarea update(@PathVariable String id,@RequestBody Tarea tarea){
        Tarea tareaFromDB = tareaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        tareaFromDB.setNombre(tarea.getNombre());
        tareaFromDB.setCompletado(tarea.isCompletado());

        return tareaRepository.save(tareaFromDB);
    };

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Tarea tareafromDB = tareaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        tareaRepository.delete(tareafromDB);
    }
}

