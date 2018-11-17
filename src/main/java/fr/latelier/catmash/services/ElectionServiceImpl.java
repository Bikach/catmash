package fr.latelier.catmash.services;


import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

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
    public CandidateDTO displayNextCandidate(String idLooseCandidate, String idWinCandidate) {
        Queue<CandidateDTO> candidateDTOQueue =
                (Queue<CandidateDTO>) candidateRepository.findAllCandidatesSortDesc0rAscOrder("ASC");

        return null;
    }

    @Override
    public List<CandidateDTO> displayAllCandidatesSortDesc0rAscOrder(String sortType) {
        return candidateRepository.findAllCandidatesSortDesc0rAscOrder(sortType);
    }



}
