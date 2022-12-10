package tn.esprit.sofienekehia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.Utils.HelperClass;
import tn.esprit.sofienekehia.entities.Contrat;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.entities.Niveau;
import tn.esprit.sofienekehia.repositories.EquipeRepository;
import tn.esprit.sofienekehia.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;
@Service
public class IEquipeServiceImp implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe getEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
       equipeRepository.deleteById(idEquipe);
    }
    @Scheduled(fixedRate = 60000)
    @Override
    public void faireEvoluerEquipes() {
      /*int nbrValide=0;
        List<Equipe>equipes=equipeRepository.findAll();
        List<Etudiant>etudiants=null;
        List<Contrat>contrats=null;
        for (Equipe e:equipes) {
            nbrValide=0;
            etudiants=etudiantRepository.findByEquipe(e);

            for (Etudiant et:etudiants) {
                contrats=et.getCont();

                for (Contrat c:contrats) {
                   if (HelperClass.DiffTwoDate(c.getDateDebut(),new Date())>=365){
                       nbrValide++;
                    }
                }
            }
            if (nbrValide>=3){
                if (e.getNiveau().equals(Niveau.JUNIOR)){
                    e.setNiveau(Niveau.SENIOR);
                }
                else if(e.getNiveau().equals(Niveau.SENIOR)){
                    e.setNiveau(Niveau.EXPERT);
                }
            }
        }
    }*/
    }
}
