package fr.latelier.catmash.services;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IElectionServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private ElectionServiceImpl electionServiceImpl;

    private CandidateDTO candidateDTO;
    private List<CandidateDTO> candidateDTOList;

    @Before
    public void setUp() {
        candidateDTO = new CandidateDTO("bmp", "http/bmp", 32);
        CandidateDTO cdto1 = new CandidateDTO("a", "http//a", 10);
        CandidateDTO cdto2 = new CandidateDTO("b", "http//b", 20);
        CandidateDTO cdto3 = new CandidateDTO("c", "http//c", 30);
        candidateDTOList = new ArrayList<>();
        candidateDTOList.add(cdto1);
        candidateDTOList.add(cdto2);
        candidateDTOList.add(cdto3);
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
        when(candidateRepository.findAllCandidatesSortInDesc0rder()).thenReturn(candidateDTOList);
        List<CandidateDTO> candidateDTOList2 = electionServiceImpl.displayAllCandidatesSortDesc0rder();
        verify(candidateRepository, times(1)).findAllCandidatesSortInDesc0rder();
        assertEquals("a", candidateDTOList2.get(0).getId());
    }

}