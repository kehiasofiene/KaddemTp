package tn.esprit.sofienekehia.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.sofienekehia.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> getAllContrats();
    Contrat addContrat (Contrat ce);
    Contrat updateContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant(Contrat ce, String nomE,String prenomE);
    Integer nbContratsValides(Date startDate, Date endDate);
    void retrieveAndUpdateStatusContrat();
}
