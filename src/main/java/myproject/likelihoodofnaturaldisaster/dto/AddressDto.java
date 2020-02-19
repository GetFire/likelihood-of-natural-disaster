package myproject.likelihoodofnaturaldisaster.dto;

public class AddressDto {
    private String houseNumber;
    private String street;
    private PhoneDto phone;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public PhoneDto getPhone() {
        return phone;
    }

    public void setPhone(PhoneDto phone) {
        this.phone = phone;
    }
}
