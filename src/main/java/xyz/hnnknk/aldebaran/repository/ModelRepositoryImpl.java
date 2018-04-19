package xyz.hnnknk.aldebaran.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.hnnknk.aldebaran.mapper.ModelMapper;
import xyz.hnnknk.aldebaran.model.Model;

import java.util.List;

/**
 * The Model repository.
 */
@Transactional
@Repository
public class ModelRepositoryImpl implements ModelRepository {

    /**
     * The Jdbc template.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public final List<Model> findAll() {
        String sql = "SELECT MODEL_ID, MODEL_NAME FROM MODEL";
        RowMapper<Model> rowMapper = new ModelMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public final void add(final Model model) {
        String sql = "INSERT INTO MODEL (MODEL_NAME) values (?)";
        jdbcTemplate.update(sql, model.getName());
    }

}
