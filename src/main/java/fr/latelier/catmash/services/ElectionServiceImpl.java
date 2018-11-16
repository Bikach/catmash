package fr.latelier.catmash.services;


import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.entities.Candidate;

import org.springframework.stereotype.Service;

@Service
public class ElectionServiceImpl implements ElectionService {


    private static final int A_VOTE = 1;

    private CandidateRepository candidateRepository;


    public ElectionServiceImpl(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void winnerCandidateUpdate(String idWinCandidate){
        CandidateDTO candidateDTO = candidateRepository.findACandidateById(idWinCandidate);
        candidateDTO.setNumberVote(candidateDTO.getNumberVote() + A_VOTE);
        candidateRepository.saveCandidate(candidateDTO);
    }


    @Override
    public Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate) {
        // TODO
        return null;
    }


}
