package xyz.hnnknk.aldebaran.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.hnnknk.aldebaran.Application;
import xyz.hnnknk.aldebaran.model.Model;
import xyz.hnnknk.aldebaran.repository.ModelRepository;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ModelRepositoryImplTest {

    @Autowired
    ModelRepository modelRepository;

    @Rollback
    @Test
    public void findAll() {
        Model model = new Model(0, "hello");
        modelRepository.add(model);
        List<Model> list = modelRepository.findAll();

        assertNotNull(list);
        assertThat(list, hasSize(1));
        assertEquals("hello", list.get(0).getName());
    }
}