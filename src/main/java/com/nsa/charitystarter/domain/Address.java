package com.nsa.charitystarter.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "building_name")
  private String buildingName;

  @Column(name = "building_number")
  private String buildingNumber;

  @Column(name = "street")
  private String street;

  @Column(name = "district")
  private String district;

  @Column(name = "city")
  private String city;

  @Column(name = "postal_code")
  private String postCode;

  @Column(name = "country_iso_code")
  private String countryCode;

  public Long getId() {
    return id;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public String getBuildingNumber() {
    return buildingNumber;
  }

  public String getStreet() {
    return street;
  }

  public String getDistrict() {
    return district;
  }

  public String getCity() {
    return city;
  }

  public String getPostCode() {
    return postCode;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public void setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Address(Long id, String buildingName, String buildingNumber, String street, String district, String city, String postCode, String countryCode) {
    this.id = id;
    this.buildingName = buildingName;
    this.buildingNumber = buildingNumber;
    this.street = street;
    this.district = district;
    this.city = city;
    this.postCode = postCode;
    this.countryCode = countryCode;
  }
}
