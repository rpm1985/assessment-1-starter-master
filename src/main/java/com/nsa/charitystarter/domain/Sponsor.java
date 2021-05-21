package com.nsa.charitystarter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sponsor_form")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fundraiser_name")
    private String fundraiserName;

    @ManyToOne
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @Column(name = "fundraising_action")
    private String fundraisingAction;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "first_valid_day")
    private LocalDateTime firstValidDay;

    @Column(name = "Last_Valid_day")
    private LocalDateTime lastValidDay;

    @Column(name = "furl")
    private String furl;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "donor_id")
//    private Donor donor;

}
