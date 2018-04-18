package xyz.hnnknk.aldebaran.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.hnnknk.aldebaran.mapper.ModelMapper;
import xyz.hnnknk.aldebaran.model.Model;

import java.util.List;

@Transactional
@Repository
public class ModelRepositoryImpl implements ModelRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Model> findAll() {
        String sql = "SELECT MODEL_ID, MODEL_NAME FROM MODEL";
        RowMapper<Model> rowMapper = new ModelMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void add(Model model) {
        String sql = "INSERT INTO MODEL (MODEL_ID, MODEL_NAME) values (?, ?)";
        jdbcTemplate.update(sql, model.getId(), model.getName());
    }
}
