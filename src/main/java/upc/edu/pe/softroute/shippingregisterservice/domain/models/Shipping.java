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

    @Column(name = "shipping_description", nullable = false, length = 50)
    private String shippingDescription;

    @Column(name = "shipping_price", nullable = false, length = 50)
    private String shippingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_company_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ShippingCompany shippingCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_city_id")
    private OriginCity originCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_city_id")
    private DestinationCity destinationCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private Sender sender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consignee_id")
    private Consignee consignee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_package_id")
    private TypePackage typePackage;
}

