package tn.esprit.sofienekehia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Universite;
import tn.esprit.sofienekehia.repositories.DepartementRepository;
import tn.esprit.sofienekehia.repositories.UniversiteRepository;

import java.util.List;
@Service //instance mel classe hedhi
public class IUniversiteServiceImp implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    DepartementRepository deptRepository;
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite getUniversite(Integer idUniversite) {
        return  universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
@Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        Departement dept=deptRepository.findById(idDepartement).orElse(null);
        if(universite !=null && dept!=null){
            universite.getDepart().add(dept);
            universiteRepository.save(universite);
        }
    }
}
