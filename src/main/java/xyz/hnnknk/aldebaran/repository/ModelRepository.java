package xyz.hnnknk.aldebaran.repository;

import xyz.hnnknk.aldebaran.model.Model;

import java.util.List;

public interface ModelRepository {

    List<Model> findAll();
    void add(Model model);
}
