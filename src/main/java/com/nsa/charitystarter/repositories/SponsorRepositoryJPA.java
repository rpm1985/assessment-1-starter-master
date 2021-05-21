package com.nsa.charitystarter.repositories;

import com.nsa.charitystarter.domain.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SponsorRepositoryJPA extends JpaRepository<Sponsor, Long>, SponsorRepository {

    @Query(value = "select * from sponsor_form where fundraiser_name like %:term% or furl like %:term% ", nativeQuery = true)
    List<Sponsor> findSponsors(@Param("term") String term);

    @Query(value = "select * from sponsor_form where furl = :furl", nativeQuery = true)
    Optional<Sponsor> findByFurl(@Param("furl") String furl);

    @Query(value = "select * from sponsor_form where id = :id", nativeQuery = true)
    Optional<Sponsor> findById(@Param("id") Long id);
}
