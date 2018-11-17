package fr.latelier.catmash.services;

import fr.latelier.catmash.dto.CandidateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectionService {

    void winnerCandidateUpdate(String idWinCandidate);
    
    CandidateDTO displayNextCandidate(String idLooseCandidate, String idWinCandidate);

    List<CandidateDTO> displayAllCandidatesSortDesc0rAscOrder(String sortType);

}
