package backcore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "accessories")
@Data
@NoArgsConstructor
public class AccessoryEntity extends BaseItemEntity {

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
