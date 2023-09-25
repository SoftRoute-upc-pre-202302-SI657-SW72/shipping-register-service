package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "shipping_registers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shipping_date", nullable = false, length = 50)
    private String shippingDate;
    @Column(name = "shipping_time", nullable = false, length = 50)
    private String shippingTime;
    @Column(name = "shipping_origin", nullable = false, length = 50)
    private String shippingOrigin;
    @Column(name = "shipping_destination", nullable = false, length = 50)
    private String shippingDestination;
    @Column(name = "shipping_description", nullable = false, length = 50)
    private String shippingDescription;
    @Column(name = "shipping_price", nullable = false, length = 50)
    private String shippingPrice;
    @Column(name = "shipping_status", nullable = false, length = 50)
    private String shippingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_company_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ShippingCompany shippingCompany;


}
