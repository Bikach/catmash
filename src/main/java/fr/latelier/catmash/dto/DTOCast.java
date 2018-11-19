package fr.latelier.catmash.dto;

import fr.latelier.catmash.entities.Candidate;

import java.util.List;
import java.util.stream.Collectors;

public class DTOCast {


    public static Candidate transfertToCandidate(CandidateDTO candidateDTO){
        return new Candidate(candidateDTO.getId(), candidateDTO.getUrl(), candidateDTO.getNumberVote());
    }

    public static CandidateDTO transfertToCandidateDTO(Candidate candidate){
        return new CandidateDTO(candidate.getId(), candidate.getUrl(), candidate.getNumberVote());
    }

    public static List<CandidateDTO> transfertToCandidateDTOList(List<Candidate> candidateList){
        return  candidateList.stream()
                .map(DTOCast::transfertToCandidateDTO)
                .collect(Collectors.toList());
    }
}
