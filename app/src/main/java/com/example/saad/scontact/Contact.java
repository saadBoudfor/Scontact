package com.example.saad.scontact;

/**
 * Created by saad on 2/10/16.
 */
public class Contact {
    private String nom;
    private String prenom;
    private String phone;
    private String portable;

    private String adresse;
    private String email;
    private String profession;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String presnom) {
        this.prenom = presnom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Contact(String nom, String presnom, String phone, String portable, String adresse, String email, String profession, int id, String webSite) {

        this.nom = nom;
        this.prenom = presnom;
        this.phone = phone;
        this.portable = portable;
        this.adresse = adresse;
        this.email = email;
        this.profession = profession;
        this.id = id;
        this.webSite = webSite;
    }


    public Contact(String nom, String presnom, String phone, String portable, String adresse, String email, String profession,  String webSite) {

        this.nom = nom;
        this.prenom = presnom;
        this.phone = phone;
        this.portable = portable;
        this.adresse = adresse;
        this.email = email;
        this.profession = profession;
        this.id = id;
        this.webSite = webSite;
    }
    public Contact() {

    }

    private String webSite;


    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phone='" + phone + '\'' +
                ", portable='" + portable + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", id=" + id +
                ", webSite='" + webSite + '\'' +
                '}';
    }
}
