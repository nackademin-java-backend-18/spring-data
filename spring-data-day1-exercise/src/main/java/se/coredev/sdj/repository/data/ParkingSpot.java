package se.coredev.sdj.repository.data;

import javax.persistence.*;

@Entity
public class ParkingSpot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @OneToOne(mappedBy = "parkingSpot")
    private Employee employee;

    protected ParkingSpot(){}

    public ParkingSpot(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Label:%s", id, label);
    }
}