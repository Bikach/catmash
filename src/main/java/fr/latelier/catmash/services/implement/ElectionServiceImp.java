package fr.latelier.catmash.services.implement;

import fr.latelier.catmash.entities.Candidate;
import fr.latelier.catmash.services.IElectionService;

public class ElectionServiceImp implements IElectionService {

    @Override
    public void winnerCandidateUpdate(String idWinCandidate) {

    }

    @Override
    public Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate) {
        return null;
    }
}
