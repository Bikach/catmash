package fr.latelier.catmash.dto;

import fr.latelier.catmash.entities.Candidate;

import java.util.ArrayList;
import java.util.List;

public class DTOCast {


    public static Candidate transfertToCandidate(CandidateDTO candidateDTO){
        return new Candidate(candidateDTO.getId(), candidateDTO.getUrl(), candidateDTO.getNumberVote());
    }

    public static CandidateDTO transfertToCandidateDTO(Candidate candidate){
        return new CandidateDTO(candidate.getId(), candidate.getUrl(), candidate.getNumberVote());
    }

    public static List<CandidateDTO> transfertToCandidateDTOList(List<Candidate> candidateList){
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        candidateList.forEach(candidate -> candidateDTOList.add(transfertToCandidateDTO(candidate)));
        return  candidateDTOList;
    }
}
