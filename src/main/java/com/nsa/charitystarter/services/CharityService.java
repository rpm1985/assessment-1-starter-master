package com.nsa.charitystarter.services;

import com.nsa.charitystarter.domain.Charity;

import java.util.List;
import java.util.Optional;

public interface CharityService {

  public List<Charity> findCharities(String searchTerm);

  public Optional<Charity> findById(Long id);

}