package com.nsa.charitystarter.context;

import com.nsa.charitystarter.controllers.DonorForm;
import com.nsa.charitystarter.domain.Charity;
import com.nsa.charitystarter.domain.Donation;
import com.nsa.charitystarter.services.CharityService;
import com.nsa.charitystarter.services.DonationService;
import com.nsa.charitystarter.services.SponsorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(com.nsa.charitystarter.controllers.DonationController.class)
public class MakeDonations {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private CharityService finder; //don't need to set the mock here yet.  Can pass the Charity object to the session directly.

  @MockBean
  private DonationService creator;

  @MockBean
  private SponsorService sponsorService;

  @Test
  public void theOneWhereTheDonorDetailsAreOK() throws Exception {

      //@SessionAttributes({"id", "donor", "payment", "sponsor"})
    mvc.perform
            (post
                    ("/donorDetails")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("name", "Bob Geldof")
                    .param("addressLine1", "Boomtown Towers")
                    .param("addressLine2", "Ravenhill")
                    .param("city", "Belfast")
                    .param("postcode", "BF1 1BG")
                    .param("countryISO", "GB")
                    .param("donationAmount", "1000")
                    .param("isGiftAidEligible", "1")
                    .sessionAttr("id", 1)
                    .sessionAttr("donor", new DonorForm())
                    .sessionAttr("payment", new Donation())
                    .sessionAttr("sponsor", new Charity(
                            3L,
                            "Cancer Research UK",
                            "22345678",
                            "CRUK",
                            "cancer, research, oncology"))
            )
            .andDo(
                    print()
            )
            .andExpect(
                    status().isOk()
            )
            .andExpect(
                    content().string(containsString("You are donating to:"))
            )
            .andExpect(
                    content().string(containsString("<span>Cancer Research UK</span>"))
            )
            .andExpect(
                    content().string(containsString("<title>Payment</title>"))
            )
    ;


  }
}
