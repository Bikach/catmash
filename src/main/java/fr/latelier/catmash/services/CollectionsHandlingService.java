package fr.latelier.catmash.services;

import fr.latelier.catmash.dto.CandidateDTO;

import java.util.List;
import java.util.Queue;

public interface CollectionsHandlingService {

    Queue<CandidateDTO> transfertListToQueueSortAscOrder(List<CandidateDTO> list);

    void erasesSessionQueueIfItsFull(Queue<CandidateDTO> repositoryQueue);

    Queue<CandidateDTO> updateRepoList(Queue<CandidateDTO> repositoryQueue, String idLooseCandidate, String idWinCandidate);


}
