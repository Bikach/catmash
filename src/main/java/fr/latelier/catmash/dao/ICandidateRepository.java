package fr.latelier.catmash.dao;

import fr.latelier.catmash.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate, String> {
}
