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

/**
 * The Main rest controller.
 */
@RestController
public class MainController {

    /**
     * Model repository.
     */
    @Autowired
    private ModelRepository modelRepository;


    /**
     * List all models.
     *
     * @return the response entity with model and http code
     */
    @RequestMapping(value = "/model/", method = RequestMethod.GET)
    public final ResponseEntity<List<Model>> listAll() {
        List<Model> models = modelRepository.findAll();
        if (models.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    /**
     * Create model.
     *
     * @param model the model
     * @return the response entity with http code
     */
    @RequestMapping(value = "/model/", method = RequestMethod.POST)
    public final ResponseEntity<Void> create(@RequestBody final Model model) {
        System.out.println("Creating " + model.toString());

        modelRepository.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
