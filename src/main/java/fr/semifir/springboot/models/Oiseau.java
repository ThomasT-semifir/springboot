package fr.semifir.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oiseau {
    private String nom;
    private String couleur;

    public String manger(String nourriture) {
        return this.getNom() + " d'une belle couleur "+ this.getCouleur() +" mange "+ nourriture + " et est content";
    }
}
