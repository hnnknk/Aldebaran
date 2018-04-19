package xyz.hnnknk.aldebaran.unit;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private long id;

    @Column(name = "model_name")
    private String name;

    public GenericModel() {
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
