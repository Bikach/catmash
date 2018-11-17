package fr.latelier.catmash.dao;

import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository {

    void saveCandidate(CandidateDTO candidateDTO);

    CandidateDTO findACandidateById(String candidateId);

    List<CandidateDTO> findAllCandidatesSortDesc0rAscOrder(String sortType);

}
