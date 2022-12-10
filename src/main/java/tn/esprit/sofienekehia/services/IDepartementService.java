package tn.esprit.sofienekehia.services;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.entities.Departement;

import java.util.List;


public interface IDepartementService {
    List<Departement> getAllDepartements();

    Departement addDepartement (Departement d);

   Departement updateDepartement (Departement d);

    public void removeDepartement (Integer idDep);
    Departement getDepartement (Integer idDepart );

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniv);

}
