package xyz.hnnknk.aldebaran.repository;

import xyz.hnnknk.aldebaran.model.Model;

import java.util.List;

/**
 * The interface Model repository.
 */
public interface ModelRepository {

    /**
     * Find all models.
     *
     * @return the list of models
     */
    List<Model> findAll();

    /**
     * Add model to database
     *
     * @param model the model
     */
    void add(Model model);
}
