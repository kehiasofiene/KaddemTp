package tn.esprit.sofienekehia.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.Utils.HelperClass;
import tn.esprit.sofienekehia.entities.Contrat;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.repositories.ContratRepository;
import tn.esprit.sofienekehia.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j //log variable lil journalisation
@Service
public class IContratServiceImp implements IContratService {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {

        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       /* 1ere methode
       List<Etudiant> etudiants = etudiantRepository.findAll();

        Etudiant etudiant = null;
        for (Etudiant e : etudiants) {
            if (e.getNomE().equals(nomE) && e.getPrenomE().equals(prenomE)) {
                etudiant = e;
            }
        }
        int nbcontratsactifs = 0;
        if (etudiant != null) {
            for (Contrat c : etudiant.getCont()) {
                if (!c.isArchive())
                    nbcontratsactifs++;
            }
            if (nbcontratsactifs < 5) {
                ce.setEtud1(etudiant);
                return contratRepository.save(ce);
            }
        }
/*
        //  Etudiant e = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
      /*  if (e != null && ce != null && e.getCont().size()<5 ) {
            ce.setEtud1(e);
            contratRepository.save(ce);
        }
        return null;*/
        int nbcontratsactifs = contratRepository.countByArchiveIsFalseAndEtud1NomEAndEtud1PrenomE(nomE, prenomE);
        if (nbcontratsactifs < 5) {
            ce.setEtud1(etudiantRepository.findByNomEAndPrenomE(nomE, prenomE));
           return  contratRepository.save(ce);
        }
        return null;
    }


    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.nbContratsValides(startDate, endDate);
    }
@Transactional
    public void archiveContracts(){
        contratRepository.findContratsByArchiveIsFalseAndDateFin(new Date()).stream()
                .forEach(contrat -> contrat.setArchive(true));
    }
//scheduler haja bch tetlanca fel background
    @Scheduled(fixedRate = 60000)
    @Override
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contrats = contratRepository.findContratsByArchiveIsFalse();
        this.archiveContracts();
        for (Contrat c : contrats) {
            // for (Equipe e:c.getEtud1().getEquipe()){
            //log.info(""+e.getNomEquipe());

          /*  contrats.stream()
                    .filter(contrat -> HelperClass.computeDifferenceBetweenDateInDays(new Date(), contrat.getDateFin()) < 16)
                    .forEach(contrat ->
                            log.info("le contrat de l'etudiant: " + contrat.getEtud1().getNomE()));

        }
        /*log.info(" "+c.getEtud1().getEquipe().get(0).getNomEquipe());*/

        }
    }}






