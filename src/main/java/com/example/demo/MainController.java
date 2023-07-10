package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.String;

@Controller 
@RequestMapping(path="/") 
public class MainController {
    
    @Autowired 
    
    private CursoRepository userRepository;

    @GetMapping(path="/") 
    public @ResponseBody String home() {
        return "Claudio Arturo Jara Almonacid - AT70392439";
    }

    @GetMapping(path="/codigo") 
    public @ResponseBody String cod() {
        return "AT70392439";
    }

    @GetMapping(path="/nombre-completo") 
    public @ResponseBody String nom() {
        return "Claudio Arturo Jara Almonacid";
    }


    
    @GetMapping(path="/listar") 
    public @ResponseBody Iterable<Curso> listar() {
        return userRepository.findAll();
    }

    @PostMapping(path="/nuevo")
    public @ResponseBody String nuevo (@RequestParam String nombre, @RequestParam Integer creditos) {
    Curso n = new Curso();
    n.setNombre(nombre);
    n.setCreditos(creditos);
    userRepository.save(n);
    return "Saved";
    }

    @DeleteMapping(path = "/eliminar")
    public @ResponseBody String eliminar(@RequestParam Integer id){
        Curso user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.delete(user);
            return "Deleted";
        }
        return "Not Found";
    }

}
