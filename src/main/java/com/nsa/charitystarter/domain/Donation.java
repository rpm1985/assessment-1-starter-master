package com.nsa.charitystarter.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "amount_in_pence")
  private Long amountInPence;

  @Column(name = "donation_date")
  private LocalDateTime donationDate;


  @Column(name = "is_own_money")
  private Boolean isOwnMoney;

  @Column(name = "has_no_benefit_to_donor")
  private Boolean hasNoBenefitToDonor;

  @Column(name = "wishes_to_gift_aid")
  private Boolean wishesToGiftAid;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "donor_id")
  private Donor donor;

  @ManyToOne
  @JoinColumn(name = "charity_id")
  private Charity charity;

  public void setWishesToGiftAid(Boolean yesNo) {
    this.wishesToGiftAid = yesNo;
    this.hasNoBenefitToDonor = yesNo;
    this.isOwnMoney = yesNo;
  }

  public Long getId() {
    return id;
  }

  public Long getAmountInPence() {
    return amountInPence;
  }

  public LocalDateTime getDonationDate() {
    return donationDate;
  }

  public Boolean getOwnMoney() {
    return isOwnMoney;
  }

  public Boolean getHasNoBenefitToDonor() {
    return hasNoBenefitToDonor;
  }

  public Boolean getWishesToGiftAid() {
    return wishesToGiftAid;
  }

  public Donor getDonor() {
    return donor;
  }

  public Charity getCharity() {
    return charity;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Donation(Long id,Long amountInPence, LocalDateTime donationDate, Boolean isOwnMoney, Boolean hasNoBenefitToDonor, Boolean wishesToGiftAid, Donor donor, Charity charity) {
    this.id = id;
    this.amountInPence = amountInPence;
    this.donationDate = donationDate;
    this.isOwnMoney = isOwnMoney;
    this.hasNoBenefitToDonor = hasNoBenefitToDonor;
    this.wishesToGiftAid = wishesToGiftAid;
    this.donor = donor;
    this.charity = charity;
  }
}
