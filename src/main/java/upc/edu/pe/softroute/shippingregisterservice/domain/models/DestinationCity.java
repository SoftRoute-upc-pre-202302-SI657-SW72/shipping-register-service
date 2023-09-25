package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "destination_cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destination_city_name", nullable = false, length = 50)
    private String destinationCityName;

    @OneToOne(mappedBy = "destinationCity", cascade = CascadeType.ALL)
    private Shipping shipping;

    // Otros campos y métodos getter/setter
}

