package com.example.sms_lorusso_silvia.mDataObject;

public class Carrello {
    String telefono;
    int id;
    String nomeP;
    String tipoP;
    String prezzoP;
    String oraC;

    String idd = Integer.toString(id);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getOraC() {
        return oraC;
    }

    public void setOraC(String oraC) {
        this.oraC = oraC;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public String getPrezzoP() {
        return prezzoP;
    }


    public void setPrezzoP(String prezzoP) {
        this.prezzoP = prezzoP;
    }
}
