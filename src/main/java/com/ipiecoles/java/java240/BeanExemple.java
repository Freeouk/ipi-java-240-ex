package com.ipiecoles.java.java240;

//Soit la classe suivante que l'on faire gérer par Spring
public class BeanExemple{
    private String msg;


    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;


    public BeanExemple(String m){msg=m;}
    public void init() {}
    public void cleanup() {}
}
