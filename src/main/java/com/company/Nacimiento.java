package com.company;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

//Utilizando Maven
//Importamos las librerias necesarias para CvsBindByName y lombook, en el fichero pom.xml.

@Data
public class Nacimiento {

    //Todos los campos del csv son de tipo string
    @CsvBindByName
    String codi_districte;
    @CsvBindByName
    String nom_districte;
    @CsvBindByName
    String codi_barri;
    @CsvBindByName
    String nom_barri;
    @CsvBindByName
    String lloc_de_naixement;
    @CsvBindByName
    String nombre;

    public String getcodi_districte() {
        return codi_districte;
    }

    public void setcodi_districte(String codi_districte) {
        codi_districte = codi_districte;
    }

    public String getnom_districte() {
        return nom_districte;
    }

    public void setnom_districte(String nom_districte) {
        nom_districte = nom_districte;
    }

    public String getcodi_barri() {
        return codi_barri;
    }

    public void setcodi_barri(String codi_barri) {
        codi_barri = codi_barri;
    }

    public String getnom_barri() {
        return nom_barri;
    }

    public void setnom_barri(String nom_barri) {
        nom_barri = nom_barri;
    }

    public String getlloc_de_naixement() {
        return lloc_de_naixement;
    }

    public void setlloc_de_naixement(String lloc_de_naixement) {
        lloc_de_naixement = lloc_de_naixement;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Naixement{" +
                "codi_districte='" + codi_districte + '\'' +
                ", nom_districte='" + nom_districte + '\'' +
                ", codi_barri='" + codi_barri + '\'' +
                ", nom_barri='" + nom_barri + '\'' +
                ", lloc_de_naixement='" + lloc_de_naixement + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    /*
    Con string's no puedo hacer compareTo

    @Override
    public int compareTo(Nacimiento n) {
    }
    */
}
