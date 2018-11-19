package fr.latelier.catmash.services;

import fr.latelier.catmash.CatmashApplication;
import fr.latelier.catmash.dto.CandidateDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CollectionsHandlingServiceImpl implements CollectionsHandlingService {



    @Override
    public Queue<CandidateDTO> transfertListToQueueSortAscOrder(List<CandidateDTO> list) {
        return list.stream()
                .sorted(Comparator.comparing(CandidateDTO::getNumberVote))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    @Override
    public void erasesSessionQueueIfItsFull(Queue<CandidateDTO> repositoryQueue) {
        if(CatmashApplication.candidatsAlreadyPresentedList.size() == repositoryQueue.size()) CatmashApplication.candidatsAlreadyPresentedList.clear();
    }

    @Override
    public Queue<CandidateDTO> updateRepoList(Queue<CandidateDTO> repositoryQueue, String idLooseCandidate, String idWinCandidate) {
        return repositoryQueue.stream()
                .filter(candidateDTO -> !repositoryQueue.contains(CatmashApplication.candidatsAlreadyPresentedList))
                .filter(candidateDTO -> isNotTheSameId(candidateDTO, idLooseCandidate, idWinCandidate))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private boolean isNotTheSameId(CandidateDTO candidateDTO, String idLooseCandidate, String idWinCandidate){
        return candidateDTO.getId().equals(idLooseCandidate) || candidateDTO.getId().equals(idWinCandidate);
    }
}
