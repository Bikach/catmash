package fr.latelier.catmash.services;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IElectionServiceTest {

    private final String ID = "bmp", URL = "http:";
    private final int NUMBER_VOTE_ACTUAL = 32;

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private ElectionServiceImpl electionServiceImpl;


    @Test
    public void shouldAddOneVoteToTheSelectedCandidate(){
        CandidateDTO candidateDTO = new CandidateDTO(ID, URL, NUMBER_VOTE_ACTUAL);
        when(candidateRepository.findACandidateById(anyString())).thenReturn(candidateDTO);
        electionServiceImpl.winnerCandidateUpdate(anyString());
        verify(candidateRepository, times(1)).findACandidateById(Mockito.anyString());
        assertEquals(33, candidateDTO.getNumberVote());
    }


    @Test(expected = CandidateException.class)
    public void shouldReturnCandidateExceptionWhenTheIdDoesNotExist(){
        doThrow(new CandidateException())
                .when(candidateRepository).findACandidateById(anyString());
        electionServiceImpl.winnerCandidateUpdate(anyString());
    }



}