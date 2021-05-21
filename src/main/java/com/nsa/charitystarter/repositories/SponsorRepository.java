package com.nsa.charitystarter.repositories;

import com.nsa.charitystarter.domain.Sponsor;

import java.util.List;
import java.util.Optional;

public interface SponsorRepository {

    public List<Sponsor> findSponsors(String searchTerm);

    public Optional<Sponsor> findByFurl(String furl);

    public Optional<Sponsor> findById(Long Id);

}
