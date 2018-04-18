package xyz.hnnknk.aldebaran.model;

public class Model {
    private long id;
    private String name;

    public Model() {
    }

    public Model(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
