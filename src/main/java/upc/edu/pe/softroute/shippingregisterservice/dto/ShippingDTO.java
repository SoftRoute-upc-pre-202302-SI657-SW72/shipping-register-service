package upc.edu.pe.softroute.shippingregisterservice.dto;

public class ShippingDTO {
    private Long id;
    private String shippingDate;
    private String shippingTime;
    private String shippingDescription;
    private String shippingPrice;
    private ShippingCompanyDTO shippingCompany;
    private OriginCityDTO originCity;
    private DestinationCityDTO destinationCity;
    private SenderDTO sender;
    private ConsigneeDTO consignee;
    private TypePackageDTO typePackage;

    // Agregar getters y setters para todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public String getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(String shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public ShippingCompanyDTO getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(ShippingCompanyDTO shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public OriginCityDTO getOriginCity() {
        return originCity;
    }

    public void setOriginCity(OriginCityDTO originCity) {
        this.originCity = originCity;
    }

    public DestinationCityDTO getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(DestinationCityDTO destinationCity) {
        this.destinationCity = destinationCity;
    }

    public SenderDTO getSender() {
        return sender;
    }

    public void setSender(SenderDTO sender) {
        this.sender = sender;
    }

    public ConsigneeDTO getConsignee() {
        return consignee;
    }

    public void setConsignee(ConsigneeDTO consignee) {
        this.consignee = consignee;
    }

    public TypePackageDTO getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(TypePackageDTO typePackage) {
        this.typePackage = typePackage;
    }
}


