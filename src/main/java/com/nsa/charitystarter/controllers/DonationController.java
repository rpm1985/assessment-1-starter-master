package com.nsa.charitystarter.controllers;

import com.nsa.charitystarter.domain.Address;
import com.nsa.charitystarter.domain.Donation;
import com.nsa.charitystarter.domain.Donor;
import com.nsa.charitystarter.domain.Sponsor;
import com.nsa.charitystarter.services.CharityService;
import com.nsa.charitystarter.services.DonationService;
import com.nsa.charitystarter.services.SponsorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


@SessionAttributes({"id", "donor", "payment", "sponsor"})
@Controller
public class DonationController {

  static final Logger LOG = LoggerFactory.getLogger(DonationController.class);


  private CharityService charityService;
  private DonationService donationService;
  private SponsorService sponsorService;

  @Autowired
  public DonationController(CharityService aService, DonationService donService, SponsorService sponService) {

    charityService = aService;
    donationService = donService;
    sponsorService = sponService;
  }

  @RequestMapping(path = "/donate/{id}", method = RequestMethod.GET)
  public String startDonation(@PathVariable("id")  String id, Model model) {

    Integer charityId = null;
    Sponsor sponsor = null;

    if(id.matches("-?\\d+(\\.\\d+)?")){
      charityId = Integer.parseInt(id);
      /**
       * want to be able to determine i came from a sponsor form or
       * direct from the charity via the detection of letters in the id
       */
    }else{
      sponsor = (sponsorService.findByFurl(id).get());
      charityId = sponsor.getCharity().getId().intValue();
      System.out.println(charityId);
    }


    model.addAttribute("id", charityId);
    model.addAttribute("donor", new DonorForm(id));
    model.addAttribute("sponsor", sponsor);
    return "donation";

  }

  @RequestMapping(path = "donorDetails", method = RequestMethod.POST)
  public String donorDetails(@SessionAttribute Long id, Model model, @ModelAttribute("donor") @Valid DonorForm donor, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      LOG.error(bindingResult.toString());
      LOG.error("Donation Form has binding errors");
      model.addAttribute("donor", donor);
      model.addAttribute("id", id);
      return "donation";
    }

    LOG.debug(donor.toString());

    LOG.debug("From session..." + id);
    model.addAttribute("donor", donor);
    model.addAttribute("id", id);
    model.addAttribute("payment", new PaymentForm());

    return "donationPayment";
  }

  @RequestMapping(path = "paymentDetails", method = RequestMethod.POST)
  public String donorDetails(@SessionAttribute DonorForm donor, @SessionAttribute Long id, Model model, @ModelAttribute("payment") @Valid PaymentForm payment, BindingResult bindingResult) {

    LOG.debug("From session..." + donor);
    LOG.debug("From session..." + id);
    LOG.debug(payment.toString());

    if (bindingResult.hasErrors()) {
      LOG.error(bindingResult.toString());
      LOG.error("Payment Form has binding errors");
      model.addAttribute("donor", donor);
      model.addAttribute("id", id);
      return "donationPayment";
    }


    model.addAttribute("last4Card", payment.getCardNumber().substring(payment.getCardNumber().length() - 4));
    model.addAttribute("donor", donor);
    model.addAttribute("id", id);
    model.addAttribute("payment", payment);


    return "paymentConfirmation";
  }

  @RequestMapping(path = "/confirm", method = RequestMethod.GET)
  public String confirmDonation(@SessionAttribute DonorForm donor, @SessionAttribute Long id, @SessionAttribute PaymentForm payment, Model model) {

    //create donation object graph from input

    Address address = new Address(null, null, null,
            donor.getAddressLine1(),
            donor.getAddressLine2(),
            donor.getCity(),
            donor.getPostcode(),
            "UK");

    //need some defensive code here.  Pele might donate!
    Donor newDonor = new Donor(null,
            donor.getName().split(" ")[0],
            donor.getName().split(" ")[1],
            address);

    Long amountInPence = Math.round(donor.getDonationAmount() * 100);

    Donation donation = new Donation(null,
            amountInPence,
            LocalDateTime.now(),
            Boolean.TRUE,
            Boolean.TRUE,
            donor.getIsGiftAidEligible(),
            newDonor,
            charityService.findById(id).get());

    LOG.debug(donation.toString());

    donationService.createDonation(donation);

    model.addAttribute("donor", donor);
    model.addAttribute("id", id);
    model.addAttribute("payment", payment);

    return "receipt";
  }


}
