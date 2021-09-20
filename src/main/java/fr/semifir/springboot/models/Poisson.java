package fr.semifir.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Poisson {
    private String nom;
    private String espece;

    public String manger(String nourriture) {
        return this.getNom() + " le "+ this.getEspece() +" mange "+ nourriture + " et est content";
    }
}
