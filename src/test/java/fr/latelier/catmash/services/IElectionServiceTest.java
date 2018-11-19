package fr.latelier.catmash.services;

import fr.latelier.catmash.CatmashApplication;
import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IElectionServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private ElectionServiceImpl electionServiceImpl;

    @InjectMocks
    private CollectionsHandlingServiceImpl collectionsHandlingService;

    private CandidateDTO candidateDTO;
    private List<CandidateDTO> candidateDTOList;
    private Queue<CandidateDTO> candidateDTOQueue;
    @Before
    public void setUp() {
        candidateDTO = new CandidateDTO("bmp", "http/bmp", 32);
        CandidateDTO cdto1 = new CandidateDTO("a", "http//a", 10);
        CandidateDTO cdto2 = new CandidateDTO("b", "http//b", 20);
        CandidateDTO cdto3 = new CandidateDTO("c", "http//c", 30);
        CandidateDTO cdto4 = new CandidateDTO("d", "http//d", 40);
        candidateDTOList = new ArrayList<>();
        candidateDTOList.add(cdto2); candidateDTOList.add(cdto3);
        candidateDTOList.add(cdto4); candidateDTOList.add(cdto1);
        candidateDTOQueue = collectionsHandlingService.transfertListToQueueSortAscOrder(candidateDTOList);
    }



    @Test
    public void shouldAddOneVoteToTheSelectedCandidate(){
        when(candidateRepository.findACandidateById(anyString())).thenReturn(candidateDTO);
        electionServiceImpl.winnerCandidateUpdate(anyString());
        verify(candidateRepository, times(1)).findACandidateById(anyString());
        assertEquals(33, candidateDTO.getNumberVote());
    }


    @Test(expected = CandidateException.class)
    public void shouldReturnCandidateExceptionWhenTheIdDoesNotExist(){
        doThrow(new CandidateException())
                .when(candidateRepository).findACandidateById(anyString());
        electionServiceImpl.winnerCandidateUpdate(anyString());
    }


    @Test
    public void shouldReturnCandidatesListSortDescOrder(){
        when(candidateRepository.findAllCandidatesDTO()).thenReturn(candidateDTOList);
        List<CandidateDTO> candidateDTOList2 = electionServiceImpl.displayAllCandidatesSortDescOrder();
        verify(candidateRepository, times(1)).findAllCandidatesDTO();
        assertEquals("d", candidateDTOList2.get(0).getId());
    }


    @Test
    public void shouldReturnTheFollowingCandidateThatIsNotDisplayed(){
        when(candidateRepository.findAllCandidatesDTO()).thenReturn(candidateDTOList);
        when(collectionsHandlingService.transfertListToQueueSortAscOrder(candidateDTOList)).thenReturn(candidateDTOQueue);
        CandidateDTO nextCandidateDTO = electionServiceImpl.selectTheNextCandidateWhoHasNotAlreadyPresented("a", "b");
        verify(candidateRepository, times(1)).findAllCandidatesDTO();
        verify(collectionsHandlingService, times(1)).transfertListToQueueSortAscOrder(anyList());

        assertEquals("d", nextCandidateDTO.getId());
        assertEquals(nextCandidateDTO.getId(), CatmashApplication.candidatsAlreadyPresentedList.get(0).getId());
    }


}