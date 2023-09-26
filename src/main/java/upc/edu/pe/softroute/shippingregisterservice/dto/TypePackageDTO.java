package upc.edu.pe.softroute.shippingregisterservice.dto;

public class TypePackageDTO {
    private Long id;
    private String typePackageName;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePackageName() {
        return typePackageName;
    }

    public void setTypePackageName(String typePackageName) {
        this.typePackageName = typePackageName;
    }
}

