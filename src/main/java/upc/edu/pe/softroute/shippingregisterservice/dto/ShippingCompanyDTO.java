package upc.edu.pe.softroute.shippingregisterservice.dto;

public class ShippingCompanyDTO {
    private Long id;
    private String shippingCompanyName;
    private String shippingCompanyDescription;
    private String shippingCompanyAddress;
    private String shippingCompanyPhone;
    private String shippingCompanyEmail;
    private String shippingCompanyRuc;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingCompanyName() {
        return shippingCompanyName;
    }

    public void setShippingCompanyName(String shippingCompanyName) {
        this.shippingCompanyName = shippingCompanyName;
    }

    public String getShippingCompanyDescription() {
        return shippingCompanyDescription;
    }

    public void setShippingCompanyDescription(String shippingCompanyDescription) {
        this.shippingCompanyDescription = shippingCompanyDescription;
    }

    public String getShippingCompanyAddress() {
        return shippingCompanyAddress;
    }

    public void setShippingCompanyAddress(String shippingCompanyAddress) {
        this.shippingCompanyAddress = shippingCompanyAddress;
    }

    public String getShippingCompanyPhone() {
        return shippingCompanyPhone;
    }

    public void setShippingCompanyPhone(String shippingCompanyPhone) {
        this.shippingCompanyPhone = shippingCompanyPhone;
    }

    public String getShippingCompanyEmail() {
        return shippingCompanyEmail;
    }

    public void setShippingCompanyEmail(String shippingCompanyEmail) {
        this.shippingCompanyEmail = shippingCompanyEmail;
    }

    public String getShippingCompanyRuc() {
        return shippingCompanyRuc;
    }

    public void setShippingCompanyRuc(String shippingCompanyRuc) {
        this.shippingCompanyRuc = shippingCompanyRuc;
    }
}
