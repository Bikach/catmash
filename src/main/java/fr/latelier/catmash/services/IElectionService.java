package fr.latelier.catmash.services;

import fr.latelier.catmash.entities.Candidate;

public interface IElectionService {

    void winnerCandidateUpdate(String idWinCandidate);
    
    Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate);
}
