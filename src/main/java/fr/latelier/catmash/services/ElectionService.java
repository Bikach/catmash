package fr.latelier.catmash.services;

import fr.latelier.catmash.entities.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface ElectionService {

    void winnerCandidateUpdate(String idWinCandidate);
    
    Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate);

}
