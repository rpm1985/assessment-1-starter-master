package com.nsa.charitystarter.controllers.api;


import com.nsa.charitystarter.controllers.exceptions.MissingResourceException;
import com.nsa.charitystarter.domain.Charity;
import com.nsa.charitystarter.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CharityAPI {

  private CharityService charityService;

  @Autowired
  public CharityAPI(CharityService aService) {
    charityService = aService;
  }

  @RequestMapping(path = "/charity/{id}", method = RequestMethod.GET)
  public ResponseEntity<Charity> getCharity(@PathVariable Long id, Model model) {


    Optional<Charity> charity = charityService.findById(id);
    if (charity.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(charity.get());
    } else {
      throw new MissingResourceException("No matching charity");
    }

  }


}
