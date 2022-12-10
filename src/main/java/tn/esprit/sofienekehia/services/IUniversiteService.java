package tn.esprit.sofienekehia.services;

import tn.esprit.sofienekehia.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getAllUniversites();
    public Universite addUniversite (Universite u);
    public Universite updateUniversite (Universite u);
    public Universite getUniversite (Integer idUniversite);
    public void removeUniversite (Integer idUniversite);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
