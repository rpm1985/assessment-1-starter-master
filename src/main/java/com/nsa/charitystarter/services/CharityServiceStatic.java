package com.nsa.charitystarter.services;

import com.nsa.charitystarter.domain.Charity;
import com.nsa.charitystarter.repositories.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharityServiceStatic implements CharityService {

  //private static CharityServiceStatic theInstance;
  private List<Charity> theCharities;
  private CharityRepository charityRepository;

  @Autowired
  public CharityServiceStatic(CharityRepository aRepo) {

    charityRepository = aRepo;
  }

  public List<Charity> findCharities(String searchTerm) {

    return charityRepository.findBySearchTerm(searchTerm);
  }


//  @Override
//  public List<Sponsor> findSponsors(String searchTerm) {
//    return null;
//  }
//
//  @Override
//  public Optional<Sponsor> findByFurl(String furl) {
//    return Optional.empty();
//  }

  public Optional<Charity> findById(Long id) {

    return charityRepository.findById(id);

  }


}