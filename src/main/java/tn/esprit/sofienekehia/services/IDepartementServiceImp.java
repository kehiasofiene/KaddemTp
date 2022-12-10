package tn.esprit.sofienekehia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Universite;
import tn.esprit.sofienekehia.repositories.DepartementRepository;
import tn.esprit.sofienekehia.repositories.UniversiteRepository;

import java.util.List;
@Service
public class IDepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void removeDepartement(Integer idDep) {
        departementRepository.deleteById(idDep);
    }
    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniv) {
        Universite u = universiteRepository.findById(idUniv).orElse(null);
        if (u != null) {
            return u.getDepart();
        }
        return null;
    }

    @Override
    public Departement getDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }
}
