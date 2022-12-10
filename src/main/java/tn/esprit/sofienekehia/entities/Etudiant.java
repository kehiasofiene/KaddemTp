package tn.esprit.sofienekehia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    private String pwd;
    @ManyToOne(cascade =CascadeType.PERSIST)
    Departement dept;

    @OneToMany(mappedBy = "etud1")
    List<Contrat> cont;

    @ManyToMany
    List<Equipe> equipe;
}
