package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "origin_cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_city_name", nullable = false, length = 50)
    private String originCityName;

    @OneToOne(mappedBy = "originCity", cascade = CascadeType.ALL)
    private Shipping shipping;

    // Otros campos y métodos getter/setter
}
