package tn.esprit.sofienekehia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Universite;
import tn.esprit.sofienekehia.services.IDepartementService;

import java.util.List;
@RestController
@RequestMapping("departement")
public class DepartementController {
    @Autowired
    IDepartementService iDepartementService;
    @GetMapping("/Alldept")
    public List<Departement> getAll() {
        List<Departement> dept = iDepartementService.getAllDepartements();
        return dept;
    }

    @PostMapping("/add")
    public Departement addDepartement(@RequestBody Departement d) {
        return iDepartementService.addDepartement(d);
    }

    @PutMapping ("/update")
    public Departement UpdateDepartement(@RequestBody Departement d) {
        return iDepartementService.updateDepartement(d);
    }

    @DeleteMapping("/removeDept/{id}")
    public String removeDept(@PathVariable Integer id) {
        iDepartementService.removeDepartement(id);
        return "Removed";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Integer id) {
        Departement dept = iDepartementService.getDepartement(id);
        if (null != dept) {
            return "hello" +dept.getIdDepart();
        } else {
            return "not exists";
        }
    }
    @GetMapping ("{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniv){
        return iDepartementService.retrieveDepartementsByUniversite(idUniv);
    }
}
