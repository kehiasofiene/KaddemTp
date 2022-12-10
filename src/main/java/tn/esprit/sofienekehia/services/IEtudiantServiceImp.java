package tn.esprit.sofienekehia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.sofienekehia.entities.Contrat;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.repositories.ContratRepository;
import tn.esprit.sofienekehia.repositories.DepartementRepository;
import tn.esprit.sofienekehia.repositories.EquipeRepository;
import tn.esprit.sofienekehia.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service//creer une instance(bin) de cette classe.
public class IEtudiantServiceImp implements IEtudiantService {
//Injecte un bean qui implimente l'interface hedheka
    @Autowired
    EtudiantRepository etudiantRepository;
@Autowired
    DepartementRepository departementRepository;
@Autowired
    EquipeRepository equipeRepository;
@Autowired
    ContratRepository contratRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant etudiant=etudiantRepository.findById(etudiantId).orElse(null);
        Departement dept=departementRepository.findById(departementId).orElse(null);
        //
        if(etudiant!=null && dept!=null){
            etudiant.setDept(dept);
        }
        etudiantRepository.save(etudiant);
    }
    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer departementId) {
        //Recherche
       // Departement dep=departementRepository.findById(departementId).orElse(null);
        //if(dep!=null)
       // return dep.getEtud();
        //return null;
     return etudiantRepository.findByDept_IdDepart(departementId);

    }
   @Transactional
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Equipe eq2= equipeRepository.findById(idEquipe).orElse(null);
        Contrat con1=contratRepository.findById(idContrat).orElse(null);
       if(con1!=null && eq2!=null){
           //hedheya metena7ash
             Etudiant e1=etudiantRepository.save(e);
              //Managed entity
             con1.setEtud1(e1);
             //contratRepository.save(con1); bel @transactional mene7tejech na3mel save
             if(e1.getEquipe()!=null){
               e1.getEquipe().add(eq2);
           }
             else{
             List<Equipe> eq =new ArrayList<Equipe>();
            // etudiantRepository.save(e1)
                 eq.add((eq2));
                 e1.setEquipe(eq);
             return e1;
        }}
              return null;}
}
