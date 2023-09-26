package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "consignees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "consignee_name", nullable = false, length = 50)
    private String consigneeName;
    @Column(name = "consignee_last_name", nullable = false, length = 50)
    private String consigneeLastName;
    @Column(name = "consignee_phone", nullable = false, length = 50)
    private String consigneePhone;
    @Column(name = "consignee_email", nullable = false, length = 50)
    private String consigneeEmail;
    @Column(name = "consignee_dni", nullable = false, length = 50)
    private String consigneeDni;
}
