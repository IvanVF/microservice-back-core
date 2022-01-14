package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bicycles")
@Data
@NoArgsConstructor
public class BicycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_addr")
    String imgAddr;

    @Column(name = "name")
    String name;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "price")
    double price;

    @Column(name = "availability")
    boolean availability;

    @Column(name = "discount")
    double discount;

    @Column(name = "description")
    String description;

    /**
     * Bicycle level from 1 to 8
     */
    @Column(name = "level")
    int level;

    @Column(name = "frame_material")
    String frameMaterial;

    @Column(name = "fork_type")
    String forkType;

    @Column(name = "fork_material")
    String forkMaterial;

    @Column(name = "fork_description")
    String forkDescription;

    @Column(name = "number_of_speeds")
    int numberOfSpeeds;

    /**
     * Gravel, mountain, woman e.t.c.
     */
    @Column(name = "bicycle_type")
    String bicycleType;

    @Column(name = "weight")
    double weight;

    @Column(name = "wheel_diameter")
    String wheelDiameter;

    @Column(name = "rim_type")
    String rimType;

    @Column(name = "break_type")
    String breakType;

    /**
     * Male, Female
     */
    @Column(name = "sex")
    String sex;



}
