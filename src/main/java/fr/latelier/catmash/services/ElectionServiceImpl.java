package fr.latelier.catmash.services;


import fr.latelier.catmash.CatmashApplication;
import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ElectionServiceImpl implements ElectionService {


    private static final int A_VOTE = 1;
    private static final int MIN = 0;

    private CandidateRepository candidateRepository;
    private CollectionsHandlingService collectionsHandlingService;

    public ElectionServiceImpl(CandidateRepository candidateRepository, CollectionsHandlingService collectionsHandlingService){
        this.candidateRepository = candidateRepository;
        this.collectionsHandlingService = collectionsHandlingService;
    }

    @Override
    public void winnerCandidateUpdate(String idWinCandidate){
        CandidateDTO candidateDTO = candidateRepository.findACandidateById(idWinCandidate);
        candidateDTO.setNumberVote(candidateDTO.getNumberVote() + A_VOTE);
        candidateRepository.saveCandidate(candidateDTO);
    }

    @Override
    public CandidateDTO selectTheNextCandidateWhoHasNotAlreadyPresented(String idLooseCandidate, String idWinCandidate) {
        Queue<CandidateDTO> candidateDTOQueue = collectionsHandlingService.transfertListToQueueSortAscOrder(candidateRepository.findAllCandidatesDTO());
        collectionsHandlingService.erasesSessionQueueIfItsFull(candidateDTOQueue);
        candidateDTOQueue = collectionsHandlingService.updateRepoList(candidateDTOQueue, idLooseCandidate, idWinCandidate);
        CandidateDTO candidateDTO = candidateDTOQueue.poll();
        CatmashApplication.candidatsAlreadyPresentedList.add(candidateDTO);
        return candidateDTO;
    }


    @Override
    public List<CandidateDTO> displayAllCandidatesSortDescOrder() {
        return candidateRepository.findAllCandidatesDTO()
                .stream()
                .sorted(Comparator.comparing(CandidateDTO::getNumberVote).reversed())
                .collect(Collectors.toList());
    }


}
