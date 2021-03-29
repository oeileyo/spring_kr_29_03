package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

//    @GetMapping("/start_page")
//    public String start_page(@RequestParam (name="name", required = false, defaultValue = "Bla-bla") String name, Model model){
//        model.addAttribute("name", name);
//        return "start_page.html";
//    }

    @PostMapping(value = "/persons")
    public ResponseEntity<?> create(@RequestBody Person person){
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> findAll(){
        final List<Person> personList = personService.findAll();

        return personList != null && !personList.isEmpty()
                ? new ResponseEntity<>(personList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Person> find(@PathVariable(name="id") Long id){
        final Person person = personService.find(id);

        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
