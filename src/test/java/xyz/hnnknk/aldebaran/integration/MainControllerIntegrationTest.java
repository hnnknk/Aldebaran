package xyz.hnnknk.aldebaran.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import xyz.hnnknk.aldebaran.Application;
import xyz.hnnknk.aldebaran.model.Model;
import xyz.hnnknk.aldebaran.repository.ModelRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
@AutoConfigureMockMvc
@Transactional
public class MainControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ModelRepository repository;

    @Rollback
    @Test
    public void listAllEmpty() throws Exception {

        mvc.perform(get("/model/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Rollback
    @Test
    public void createSuccess() throws Exception {
        Model model = new Model(0, "hello");

        String d = new ObjectMapper().writeValueAsString(model);

        mvc.perform(post("/model/").content(d).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        assertEquals("hello", repository.findAll().get(0).getName());
    }

    @Rollback
    @Test
    public void listAllSuccess() throws Exception {
        Model model = new Model(0, "hello");

        repository.add(model);

        mvc.perform(get("/model/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(model.getName())));
    }
}
