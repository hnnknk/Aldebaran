package xyz.hnnknk.aldebaran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.hnnknk.aldebaran.model.Model;
import xyz.hnnknk.aldebaran.repository.ModelRepository;

@Controller
public class IndexController {

    @Autowired
    ModelRepository modelRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        Model model = new Model(1, "hello");
        modelRepository.add(model);
        for (Model model1 : modelRepository.findAll()) {
            System.out.println("Name is: " + model1.getName());
        }
        return "index";
    }
}
