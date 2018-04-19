package xyz.hnnknk.aldebaran.model;

/**
 * The Model entity.
 */
public class Model {

    /**
     * Model id.
     */
    private long id;

    /**
     * Model name.
     */
    private String name;

    /**
     * Instantiates a new Model.
     */
    public Model() {
    }

    /**
     * Instantiates a new Model.
     *
     * @param id   the id
     * @param name the name
     */
    public Model(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return "Model{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
