package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accessories")
@Data
@NoArgsConstructor
public class AccessoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_addr")
    String imgAddr;

    @Column(name = "name")
    String name;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "availability")
    boolean availability;

    @Column(name = "price")
    double price;

    @Column(name = "discount")
    double discount;

    @Column(name = "type")
    String type;

    @Column(name = "description")
    String description;

    @Column(name = "material")
    String material;

    @Column(name = "development_country")
    String developmentCountry;

    @Column(name = "manufacturer_country")
    String manufacturerCountry;

    @Column(name = "color")
    String color;

    @Column(name = "size")
    String size;

    @Column(name = "features")
    String features;
}
