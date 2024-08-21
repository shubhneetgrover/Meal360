package com.meal360.web.rider.mdoels;

import com.meal360.web.location.model.Location;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "riders")
public class riders {

/*    private String _id;


    @NotNull
    private boolean isActive;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String number;

    @Indexed(unique = true)
    private String email;

    @NotNull
    private boolean active;

    @Indexed(unique = true)
    private String username;

    @NotNull
    private String password;



    private String accountNumber;

//    private deposit

    public riders(String name, String address, String number, String email, boolean active, String username,
                  String password) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }*/

    private String _id;

    private String title;

    private String firstname;

    private String lastname;

    private String photoLocation;

    private String uidNumber;
    private String uidNumberImageLocation;

    private String licenseNumber;
    private String licenseNumberImageLocation;

    private String vehicleType;
    private String vehicleNumber;
    private String vehicleRcImageLocation;

    private String email;

    private String number;

    private String username;
    private String password;

    private String address;
    private String city;
    private String state;
    private String pincode;
    private String locality;

    private boolean active;
    private boolean acceptingOrders;
    private Location location;

    @NotNull
    private Date timeStampCreated;
    private Date timeStampLastUpdated;

    public riders(String title, String firstname, String lastname, String photoLocation, String uidNumber,
                  String uidNumberImageLocation, String licenseNumber, String licenseNumberImageLocation,
                  String vehicleType, String vehicleNumber, String vehicleRcImageLocation, String email,
                  String number, String username, String password, String address, String city, String state,
                  String pincode, String locality) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.photoLocation = photoLocation;
        this.uidNumber = uidNumber;
        this.uidNumberImageLocation = uidNumberImageLocation;
        this.licenseNumber = licenseNumber;
        this.licenseNumberImageLocation = licenseNumberImageLocation;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleRcImageLocation = vehicleRcImageLocation;
        this.email = email;
        this.number = number;
        this.username = username;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.locality = locality;
        this.active = false;
        this.acceptingOrders = false;
        this.timeStampCreated = new Date();
        this.timeStampLastUpdated = new Date();
        this.location = null;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public String getUidNumber() {
        return uidNumber;
    }

    public void setUidNumber(String uidNumber) {
        this.uidNumber = uidNumber;
    }

    public String getUidNumberImageLocation() {
        return uidNumberImageLocation;
    }

    public void setUidNumberImageLocation(String uidNumberImageLocation) {
        this.uidNumberImageLocation = uidNumberImageLocation;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumberImageLocation() {
        return licenseNumberImageLocation;
    }

    public void setLicenseNumberImageLocation(String licenseNumberImageLocation) {
        this.licenseNumberImageLocation = licenseNumberImageLocation;
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

    public String getVehicleRcImageLocation() {
        return vehicleRcImageLocation;
    }

    public void setVehicleRcImageLocation(String vehicleRcImageLocation) {
        this.vehicleRcImageLocation = vehicleRcImageLocation;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAcceptingOrders() {
        return acceptingOrders;
    }

    public void setAcceptingOrders(boolean acceptingOrders) {
        this.acceptingOrders = acceptingOrders;
    }

    public Date getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(Date timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    public Date getTimeStampLastUpdated() {
        return timeStampLastUpdated;
    }

    public void setTimeStampLastUpdated(Date timeStampLastUpdated) {
        this.timeStampLastUpdated = timeStampLastUpdated;
    }
}
