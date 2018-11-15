package fr.latelier.catmash.dto;

import fr.latelier.catmash.entities.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTOCastTest {

    Candidate candidate;
    CandidateDTO candidateDTO;

    @BeforeEach
    void setUp() {
        candidate = new Candidate("candidate_id", "http//candidate.com", 20);

        candidateDTO = new CandidateDTO("candidateDTO_id", "http//candidateDTO.com", 40);
    }


    @Test
    void candidateMustGetAllCandidateDTOData(){
        candidate = DTOCast.transfertToCandidate(candidateDTO);
        assertEquals(candidate.getId(), "candidateDTO_id");
        assertEquals(candidate.getUrl(), "http//candidateDTO.com");
        assertEquals(candidate.getNumberVote(), 40);
    }


    @Test
    void candidateDTOMustGetAllCandidateData(){
        candidateDTO = DTOCast.transfertToCandidateDTO(candidate);
        assertEquals(candidateDTO.getId(), "candidate_id");
        assertEquals(candidateDTO.getUrl(), "http//candidate.com");
        assertEquals(candidateDTO.getNumberVote(), 20);
    }
}