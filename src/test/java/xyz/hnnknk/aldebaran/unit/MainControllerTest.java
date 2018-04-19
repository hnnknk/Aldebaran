package xyz.hnnknk.aldebaran.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import xyz.hnnknk.aldebaran.controller.MainController;
import xyz.hnnknk.aldebaran.model.Model;
import xyz.hnnknk.aldebaran.repository.ModelRepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ModelRepositoryImpl repository;

    @Test
    public void listAllSuccess() throws Exception {
        Model model = new Model(0, "hello");

        List<Model> models = Arrays.asList(model);

        given(repository.findAll()).willReturn(models);

        mvc.perform(get("/model/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(model.getName())));
    }

    @Test
    public void listAllEmpty() throws Exception {

        List<Model> models = new ArrayList<>();

        given(repository.findAll()).willReturn(models);

        mvc.perform(get("/model/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void createSuccess() throws Exception {
        Model model = new Model(0, "hello");

        String d = new ObjectMapper().writeValueAsString(model);

        mvc.perform(post("/model/").content(d).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }
}