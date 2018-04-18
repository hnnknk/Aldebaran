package xyz.hnnknk.aldebaran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.hnnknk.aldebaran.model.Model;
import xyz.hnnknk.aldebaran.repository.ModelRepository;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ModelRepository modelRepository;


    @RequestMapping(value = "/model/", method = RequestMethod.GET)
    public ResponseEntity<List<Model>> listAll() {
        List<Model> models = modelRepository.findAll();
        if(models.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @RequestMapping(value = "/model/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Model model) {
        System.out.println("Creating " + model.toString());

        modelRepository.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
