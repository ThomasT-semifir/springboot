package fr.semifir.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Singe {
    private String nom;
    private Double taille;

    public String manger(String nourriture) {
        return this.getNom() + " qui mesure "+ this.getTaille() +"mètre mange "+ nourriture + " et est content";
    }
}
