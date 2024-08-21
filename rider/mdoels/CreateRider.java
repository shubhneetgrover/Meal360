package com.meal360.web.rider.mdoels;

public class CreateRider {


    private String title;

    private String firstname;

    private String lastname;

    private String photoUri;
    private String photoName;

    private String uidNumber;
    private String uidNumberImageUri;
    private String uidNumberImagename;

    private String licenseNumber;
    private String licenseNumberImageUri;
    private String licenseNumberImagename;

    private String vehicleType;
    private String vehicleNumber;
    private String vehicleRcImageUri;
    private String vehicleRcImagename;

    private String email;

    private String number;

    private String username;
    private String password;

    private String address;
    private String city;
    private String state;
    private String pincode;
    private String locality;

    public CreateRider(String title, String firstname, String lastname,
                       String photoUri, String photoName, String uidNumber, String uidNumberImageUri,
                       String uidNumberImagename, String licenseNumber, String licenseNumberImageUri,
                       String licenseNumberImagename, String vehicleType, String vehicleNumber,
                       String vehicleRcImageUri, String vehicleRcImagename, String email, String number,
                       String username, String password, String address, String city, String state,
                       String pincode, String locality) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.photoUri = photoUri;
        this.photoName = photoName;
        this.uidNumber = uidNumber;
        this.uidNumberImageUri = uidNumberImageUri;
        this.uidNumberImagename = uidNumberImagename;
        this.licenseNumber = licenseNumber;
        this.licenseNumberImageUri = licenseNumberImageUri;
        this.licenseNumberImagename = licenseNumberImagename;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleRcImageUri = vehicleRcImageUri;
        this.vehicleRcImagename = vehicleRcImagename;
        this.email = email;
        this.number = number;
        this.username = username;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.locality = locality;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getphotoUri() {
        return photoUri;
    }

    public void setphotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getUidNumber() {
        return uidNumber;
    }

    public void setUidNumber(String uidNumber) {
        this.uidNumber = uidNumber;
    }

    public String getUidNumberImageUri() {
        return uidNumberImageUri;
    }

    public void setUidNumberImageUri(String uidNumberImageUri) {
        this.uidNumberImageUri = uidNumberImageUri;
    }

    public String getUidNumberImagename() {
        return uidNumberImagename;
    }

    public void setUidNumberImagename(String uidNumberImagename) {
        this.uidNumberImagename = uidNumberImagename;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumberImageUri() {
        return licenseNumberImageUri;
    }

    public void setLicenseNumberImageUri(String licenseNumberImageUri) {
        this.licenseNumberImageUri = licenseNumberImageUri;
    }

    public String getLicenseNumberImagename() {
        return licenseNumberImagename;
    }

    public void setLicenseNumberImagename(String licenseNumberImagename) {
        this.licenseNumberImagename = licenseNumberImagename;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleRcImageUri() {
        return vehicleRcImageUri;
    }

    public void setVehicleRcImageUri(String vehicleRcImageUri) {
        this.vehicleRcImageUri = vehicleRcImageUri;
    }

    public String getVehicleRcImagename() {
        return vehicleRcImagename;
    }

    public void setVehicleRcImagename(String vehicleRcImagename) {
        this.vehicleRcImagename = vehicleRcImagename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
