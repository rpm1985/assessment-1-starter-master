package com.nsa.charitystarter.controllers;


import com.nsa.charitystarter.controllers.exceptions.MissingResourceException;
import com.nsa.charitystarter.domain.Charity;
import com.nsa.charitystarter.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class CharityProfile {

  private CharityService charityService;

  @Autowired
  public CharityProfile(CharityService aService) {
    charityService = aService;
  }


  @RequestMapping(path = "/charity/{id}", method = RequestMethod.GET)
  public String getCharityProfile(@PathVariable Long id, Model model) {

    Optional<Charity> charity = charityService.findById(id);
    if (charity.isPresent()) {
      model.addAttribute("charity", charity.get());
      return "charityProfile";
    } else {
      throw new MissingResourceException("No matching charity", "404");
    }

  }
}

