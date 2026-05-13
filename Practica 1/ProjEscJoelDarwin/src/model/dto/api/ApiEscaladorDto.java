package model.dto.api;

public class ApiEscaladorDto {

    private int idEscalador;
    private String dni;
    private String nom;
    private int edat;
    private int estil;

    public ApiEscaladorDto() {
    }

    public int getIdEscalador() {
        return idEscalador;
    }

    public void setIdEscalador(int idEscalador) {
        this.idEscalador = idEscalador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getEstil() {
        return estil;
    }

    public void setEstil(int estil) {
        this.estil = estil;
    }
}