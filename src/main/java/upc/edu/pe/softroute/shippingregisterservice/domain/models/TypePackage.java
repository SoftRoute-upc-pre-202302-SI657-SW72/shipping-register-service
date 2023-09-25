package upc.edu.pe.softroute.shippingregisterservice.domain.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "type_packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_package_name", nullable = false, length = 50)
    private String typePackageName;
}
