package com.nsa.charitystarter.repositories;


import com.nsa.charitystarter.domain.Charity;

import java.util.List;
import java.util.Optional;


public interface CharityRepository {

  public Optional<Charity> findById(Long id);

  public List<Charity> findBySearchTerm(String name);

  public List<Charity> findByName(String name);

  public List<Charity> findAll();


}
