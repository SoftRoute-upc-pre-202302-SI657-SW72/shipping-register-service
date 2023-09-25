package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "consignees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consignees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender_name", nullable = false, length = 50)
    private String senderName;
    @Column(name = "sender_last_name", nullable = false, length = 50)
    private String senderLastName;
    @Column(name = "sender_phone", nullable = false, length = 50)
    private String senderPhone;
    @Column(name = "sender_email", nullable = false, length = 50)
    private String senderEmail;
    @Column(name = "sender_dni", nullable = false, length = 50)
    private String senderDni;
}
