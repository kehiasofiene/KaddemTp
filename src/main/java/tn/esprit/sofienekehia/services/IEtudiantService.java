package tn.esprit.sofienekehia.services;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.sofienekehia.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public Etudiant getById(Integer idEtudiant);
    public List<Etudiant> getAllEtudiants();
    public void removeEtudiant(Integer idEtudiant);
    public void assignEtudiantToDepartement( Integer etudiantId, Integer departementId);

     public List<Etudiant> getEtudiantsByDepartement(Integer departementId);
     public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
}
