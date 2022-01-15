package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "scooters")
@Data
@NoArgsConstructor
public class ScooterEntity extends BaseItemEntity {

    @Column(name = "material")
    String material;

    @Column(name = "development_country")
    String developmentCountry;

    @Column(name = "manufacturer_country")
    String manufacturerCountry;

    @Column(name = "color")
    String color;
}
