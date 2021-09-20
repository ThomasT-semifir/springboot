package fr.semifir.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String nom;
    private String prenom;

    public String getToto() {
        return "Hello";
    }
}
