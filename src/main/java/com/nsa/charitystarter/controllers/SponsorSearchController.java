package com.nsa.charitystarter.controllers;

import com.nsa.charitystarter.controllers.exceptions.MissingResourceException;
import com.nsa.charitystarter.domain.Sponsor;
import com.nsa.charitystarter.services.CharityService;
import com.nsa.charitystarter.services.SponsorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SponsorSearchController {

    static final Logger LOG = LoggerFactory.getLogger(CharitySearchController.class);


    private CharityService charityService;

    private SponsorService sponsorService;


    /**
     * @param aService - a provider of a charity service interface.
     */
    @Autowired
    public SponsorSearchController(CharityService aService, SponsorService sponsorService) {
        charityService = aService;
        this.sponsorService = sponsorService;
    }

    /**
     * @param search
     * @param model
     * @return Name of the next view
     */

    @RequestMapping(path = "sponsor/{id}", method = RequestMethod.GET)
    public String getSponsorProfile(@PathVariable("id") String furl, Model model) {
        Optional<Sponsor> sponsor = sponsorService.findByFurl(furl);
        if (sponsor.isPresent()) {
            model.addAttribute("sponsor", sponsor.get());
            return "sponsorProfile";
        } else {
            LOG.error("missing sponsors");
            throw new MissingResourceException("No matching sponsor", "404");
        }

    }

    @RequestMapping(path = "/findSponsor", method = RequestMethod.GET)
    public String listSponsorProfiles(@RequestParam("search") String search, Model model) {

        LOG.debug("Handling /findCharity");

        List<Sponsor> sponsor = sponsorService.findSponsors(search);


        model.addAttribute("searchTerm", search);
        model.addAttribute("matches", sponsor);


        return "sponsorSearchResults"; //the return is the name of the next page (but we're not doing templating, so we redirect to the home page.


    }

    /*

    We can use @Controllers to create dynamic server-side pages.  This is normally achieved
    using a templating framework such as Thymeleaf.  There are plenty of online resources on the combination of
    Spring (boot) and Thymeleaf, but be careful with versions.

    We are going to tend towards JQuery so we will inject HTML into a static page using data from REST api end-points.

    This is a step towards full single-page applications and reactive applications.

    Spring Boot 2.0 will have full support for reactive applications (because Spring 5.0) has it.



     */
}

