package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_addr")
    private String imgAddr;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "description")
    private String description;

    /**
     * Stels, Cube, Deuter e.t.c
     */
    @Column(name = "manufacturer")
    private String manufacturer;

    /**
     * Is available in store or warehouse
     */
    @Column(name = "availability")
    private boolean availability;

    /**
     * Subtypes of bicycles (gravel, road..), scooters (offroad, city..), accessories e.t.s
     */
    @Column(name = "type")
    private String type;
}
