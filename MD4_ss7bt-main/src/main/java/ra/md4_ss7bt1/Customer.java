package ra.md4_ss7bt1;

import java.time.LocalDate;

public class Customer {
    private String name, address, photoUrl;
    private LocalDate birthDay;

    public Customer() {
    }

    public Customer(String name, LocalDate birthDay, String address, String photoUrl) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}