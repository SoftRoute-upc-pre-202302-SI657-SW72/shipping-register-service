package upc.edu.pe.softroute.shippingregisterservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "shipping_companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingCompany {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shipping_company_name", nullable = false, length = 50)
    private String shippingCompanyName;
    @Column(name = "shipping_company_description", nullable = false, length = 50)
    private String shippingCompanyDescription;
    @Column(name = "shipping_company_address", nullable = false, length = 50)
    private String shippingCompanyAddress;
    @Column(name = "shipping_company_phone", nullable = false, length = 50)
    private String shippingCompanyPhone;
    @Column(name = "shipping_company_email", nullable = false, length = 50)
    private String shippingCompanyEmail;
    @Column(name = "shipping_company_ruc", nullable = false, length = 50)
    private String shippingCompanyRuc;
}
