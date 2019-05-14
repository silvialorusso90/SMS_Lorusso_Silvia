package com.example.sms_lorusso_silvia.mDataObject;

public class Utenti {
    int  telefonoo;
    String nome, cognome, oraconsegna;

    String telefono = Integer.toString(telefonoo);

    public int getTelefonoo() {
        return telefonoo;
    }

    public void setTelefonoo(int telefonoo) {
        this.telefonoo = telefonoo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getOraconsegna() {
        return oraconsegna;
    }

    public void setOraconsegna(String oraconsegna) {
        this.oraconsegna = oraconsegna;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
