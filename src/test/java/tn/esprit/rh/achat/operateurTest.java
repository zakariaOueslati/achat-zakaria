package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class operateurTest {

    @Mock
    private OperateurRepository operateurRepository;

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllOperateurs() {
        List<Operateur> operateurs = new ArrayList<>();
        operateurs.add(new Operateur());
        when(operateurRepository.findAll()).thenReturn(operateurs);

        List<Operateur> result = operateurService.retrieveAllOperateurs();

        assertEquals(1, result.size());
    }

    @Test
    void testAddOperateur() {
        Operateur operateur = new Operateur();
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur result = operateurService.addOperateur(operateur);

        assertEquals(operateur, result);
    }

    @Test
    void testDeleteOperateur() {
        Long id = 1L;
        operateurService.deleteOperateur(id);

        verify(operateurRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur result = operateurService.updateOperateur(operateur);

        assertEquals(operateur, result);
    }

    @Test
    void testRetrieveOperateur() {
        Long id = 1L;
        Operateur operateur = new Operateur();
        when(operateurRepository.findById(id)).thenReturn(Optional.of(operateur));

        Operateur result = operateurService.retrieveOperateur(id);

        assertEquals(operateur, result);
    }
}
