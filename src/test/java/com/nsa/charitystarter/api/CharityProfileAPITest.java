package com.nsa.charitystarter.api;

import com.nsa.charitystarter.controllers.api.CharityAPI;
import com.nsa.charitystarter.domain.Charity;
import com.nsa.charitystarter.services.CharityService;
import com.nsa.charitystarter.services.DonationService;
import com.nsa.charitystarter.services.SponsorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(com.nsa.charitystarter.controllers.DonationController.class)
public class CharityProfileAPITest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private CharityService charityService;

  @MockBean
  private DonationService donationService;

  @MockBean
  private SponsorService sponsorService;

  @MockBean
  private CharityAPI finder;

  @Test
  public void charity1shouldBeRSPCAOnApi() throws Exception {

    Charity rspca = new Charity(
            2L,
            "Royal Society for the Preventation of Cruelty to Animals",
            "12345679",
            "RSPCA",
            "animal, animals, welfare, protection");


    given(this.finder.findById(2L)).willReturn(Optional.of(rspca));

    mvc.perform
            (get
                    ("/api/charity2/2")
            )
            .andDo(
                    print()
            )
            .andExpect(
                    status().isOk()
            )
            .andExpect(
                    content().string(containsString("{\"id\":2,\"name\":\"Royal Society"))
            )

    ;

  }


}
