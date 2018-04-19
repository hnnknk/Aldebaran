package xyz.hnnknk.aldebaran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The Index controller.
 */
@Controller
public class IndexController {

    /**
     * Gets index page.
     *
     * @return the index page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String getIndex() {
        return "index";
    }
}
