package com.nsa.charitystarter.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "charity")
public class Charity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "acronym")
  private String acronym;

  @Column(name = "purpose")
  private String description;

  @Column(name = "logo_file_name")
  private String logoPath;

  @Column(name = "registration_id")
  private String registrationNumber;

  @Column(name = "is_active")
  private Boolean isActive;

  public Long getId() {
    return id;
  }

  public Charity(Long id, String name, String acronym, String description, String logoPath, String registrationNumber, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.acronym = acronym;
    this.description = description;
    this.logoPath = logoPath;
    this.registrationNumber = registrationNumber;
    this.isActive = isActive;
  }
}
