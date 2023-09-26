package upc.edu.pe.softroute.shippingregisterservice.dto;

public class SenderDTO {
    private Long id;
    private String senderName;
    private String senderLastName;
    private String senderPhone;
    private String senderEmail;
    private String senderDni;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderDni() {
        return senderDni;
    }

    public void setSenderDni(String senderDni) {
        this.senderDni = senderDni;
    }
}
