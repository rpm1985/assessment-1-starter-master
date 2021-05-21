package com.nsa.charitystarter.services;

import com.nsa.charitystarter.domain.Sponsor;
import com.nsa.charitystarter.repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImp implements SponsorService {
    SponsorRepository sponsorRepository;

    @Autowired
    public SponsorServiceImp(SponsorRepository repo) {
        sponsorRepository = repo;
    }

    @Override
    public List<Sponsor> findSponsors(String searchTerm) {
        return sponsorRepository.findSponsors(searchTerm);
    }

    @Override
    public Optional<Sponsor> findByFurl(String furl) {
        return sponsorRepository.findByFurl(furl);
    }

    @Override
    public Optional<Sponsor> findById(Long id) {
        return sponsorRepository.findById(id);
    }
}
