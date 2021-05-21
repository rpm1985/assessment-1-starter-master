package com.nsa.charitystarter.controllers.api;

import com.nsa.charitystarter.controllers.exceptions.MissingResourceException;
import com.nsa.charitystarter.domain.Sponsor;
import com.nsa.charitystarter.services.SponsorServiceImp;
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
public class SponsorAPI {

    private SponsorServiceImp sService;

    @Autowired
    public SponsorAPI(SponsorServiceImp aService) {
        aService = sService;
    }

    @RequestMapping(path = "/sponsor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sponsor> getSponsor(@PathVariable Long id, Model model) {


        Optional<Sponsor> sponsor = sService.findById(id);
        if (sponsor.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(sponsor.get());
        } else {
            throw new MissingResourceException("No matching sponsor");
        }

    }


}
