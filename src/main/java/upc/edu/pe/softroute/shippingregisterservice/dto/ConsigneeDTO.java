package upc.edu.pe.softroute.shippingregisterservice.dto;

public class ConsigneeDTO {
    private Long id;
    private String consigneeName;
    private String consigneeLastName;
    private String consigneePhone;
    private String consigneeEmail;
    private String consigneeDni;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeLastName() {
        return consigneeLastName;
    }

    public void setConsigneeLastName(String consigneeLastName) {
        this.consigneeLastName = consigneeLastName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeEmail() {
        return consigneeEmail;
    }

    public void setConsigneeEmail(String consigneeEmail) {
        this.consigneeEmail = consigneeEmail;
    }

    public String getConsigneeDni() {
        return consigneeDni;
    }

    public void setConsigneeDni(String consigneeDni) {
        this.consigneeDni = consigneeDni;
    }
}

