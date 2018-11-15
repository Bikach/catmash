package fr.latelier.catmash.dto;

import fr.latelier.catmash.entities.Candidate;

public class DTOCast {


    public static Candidate transfertToCandidate(CandidateDTO candidateDTO){
        return new Candidate(candidateDTO.getId(), candidateDTO.getUrl(), candidateDTO.getNumberVote());
    }

    public static CandidateDTO transfertToCandidateDTO(Candidate candidate){
        return new CandidateDTO(candidate.getId(), candidate.getUrl(), candidate.getNumberVote());
    }


}
