package com.nsa.charitystarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"id", "donor", "payment", "sponsor"})
@Controller
public class SponsorController {
//
//    static final Logger LOG = getLogger(DonationController.class);
//
//
//    private CharityService charityService;
//    private DonationService donationService;
//
//    @Autowired
//    public SponsorController(CharityService aService, DonationService donService) {
//
//        charityService = aService;
//        donationService = donService;
//    }
//
//    @RequestMapping(path = "/donate/{id}", method = RequestMethod.GET)
//    public String startSponsorDonation(@PathVariable Long id, Model model) {
//
//        model.addAttribute("id", id);
//        model.addAttribute("donor", new DonorForm());
//        return "sponsor";
//
//    }
//
//    @RequestMapping(path = "donorDetails", method = RequestMethod.POST)
//    public String donorSponsorDetails(@SessionAttribute Long id, Model model, @ModelAttribute("donor") @Valid DonorForm donor, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            LOG.error(bindingResult.toString());
//            LOG.error("Donation Form has binding errors");
//            model.addAttribute("donor", donor);
//            model.addAttribute("id", id);
//            return "sponsor";
//        }
//
//        LOG.debug(donor.toString());
//
//        LOG.debug("From session..." + id);
//        model.addAttribute("donor", donor);
//        model.addAttribute("id", id);
//        model.addAttribute("payment", new PaymentForm());
//
//        return "donationPayment";
//    }
//
//    @RequestMapping(path = "paymentDetails", method = RequestMethod.POST)
//    public String donorSponsorDetails(@SessionAttribute DonorForm donor, @SessionAttribute Long id, Model model, @ModelAttribute("payment") @Valid PaymentForm payment, BindingResult bindingResult) {
//
//        LOG.debug("From session..." + donor);
//        LOG.debug("From session..." + id);
//        LOG.debug(payment.toString());
//
//        if (bindingResult.hasErrors()) {
//            LOG.error(bindingResult.toString());
//            LOG.error("Payment Form has binding errors");
//            model.addAttribute("donor", donor);
//            model.addAttribute("id", id);
//            return "donationPayment";
//        }
//
//
//        model.addAttribute("last4Card", payment.getCardNumber().substring(payment.getCardNumber().length() - 4));
//        model.addAttribute("donor", donor);
//        model.addAttribute("id", id);
//        model.addAttribute("payment", payment);
//
//
//        return "paymentConfirmation";
//    }
//
//    @RequestMapping(path = "/confirm", method = RequestMethod.GET)
//    public String confirmSponsorDonation(@SessionAttribute DonorForm donor, @SessionAttribute Long id, @SessionAttribute PaymentForm payment, Model model) {
//
//        //create donation object graph from input
//
//        Address address = new Address(null, null, null,
//                donor.getAddressLine1(),
//                donor.getAddressLine2(),
//                donor.getCity(),
//                donor.getPostcode(),
//                "UK");
//
//        //need some defensive code here.  Pele might donate!
//        Donor newDonor = new Donor(null,
//                donor.getName().split(" ")[0],
//                donor.getName().split(" ")[1],
//                address);
//
//        Long amountInPence = Math.round(donor.getDonationAmount() * 100);
//
//        Donation donation = new Donation(null,
//                amountInPence,
//                LocalDateTime.now(),
//                Boolean.TRUE,
//                Boolean.TRUE,
//                donor.getIsGiftAidEligible(),
//                newDonor,
//                charityService.findById(id).get());
//
//        LOG.debug(donation.toString());
//
//        donationService.createDonation(donation);
//
//        model.addAttribute("donor", donor);
//        model.addAttribute("id", id);
//        model.addAttribute("payment", payment);
//
//        return "receipt";
//    }


}
