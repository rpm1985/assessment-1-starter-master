package com.nsa.charitystarter.services;

import com.nsa.charitystarter.domain.Donation;
import com.nsa.charitystarter.repositories.DonationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationServiceImpl implements DonationService {

  private DonationRepository donationRepository;
  static final Logger LOG = LoggerFactory.getLogger(DonationServiceImpl.class);

  @Autowired
  public DonationServiceImpl(DonationRepository aRepo) {
    donationRepository = aRepo;
  }

  @Override
  @Transactional
  public void createDonation(Donation aDonation) {

    donationRepository.save(aDonation);
    LOG.info(aDonation.toString());

  }
}
