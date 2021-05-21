package com.nsa.charitystarter.services;

import com.nsa.charitystarter.domain.Sponsor;

import java.util.List;
import java.util.Optional;

public interface SponsorService {

    public List<Sponsor> findSponsors(String searchTerm);

    public Optional<Sponsor> findByFurl(String furl);

    public Optional<Sponsor> findById(Long id);
}
