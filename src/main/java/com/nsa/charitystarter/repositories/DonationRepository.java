package com.nsa.charitystarter.repositories;

import com.nsa.charitystarter.domain.Donation;

public interface DonationRepository {

  public Donation save(Donation aDonation);

  public Donation saveAndFlush(Donation aDonation);

  public Long findLastDonationId();

}
