package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
@Entity
@Table(name = "spares")
@Data
@NoArgsConstructor
public class SpareEntity extends BaseItemEntity {

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

    @Column(name = "weight")
    String weight;

    @Column(name = "volume")
    String volume;

    @Column(name = "features")
    String features;
}
