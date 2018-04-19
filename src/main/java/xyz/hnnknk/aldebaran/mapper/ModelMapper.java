package xyz.hnnknk.aldebaran.mapper;

import org.springframework.jdbc.core.RowMapper;
import xyz.hnnknk.aldebaran.model.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Model mapper for spring jdbc.
 */
public class ModelMapper implements RowMapper<Model> {

    @Override
    public final Model mapRow(final ResultSet resultSet, final int i) throws SQLException {
        Model model = new Model();
        model.setId(resultSet.getInt("model_id"));
        model.setName(resultSet.getString("model_name"));
        return model;
    }
}
