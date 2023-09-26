package upc.edu.pe.softroute.shippingregisterservice.dto;

public class DestinationCityDTO {
    private Long id;
    private String destinationCityName;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
    }
}

