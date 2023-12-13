package bg.softuni.sunpowa.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name="brands")
public class BrandEntity extends BaseEntity{

    private String name;


    private String model;



    public String getName() {
        return this.name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return this.model;
    }

    public BrandEntity setModel(String model) {
        this.model = model;
        return this;
    }
}
