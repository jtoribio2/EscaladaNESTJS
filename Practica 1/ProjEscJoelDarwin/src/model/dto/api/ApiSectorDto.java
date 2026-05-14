package model.dto.api;

public class ApiSectorDto {

    private int idSector;
    private String nom;
    private float latitut;
    private float longitut;
    private String aproximacio;
    private int popularitat;

    private ApiEscolaDto escola;

    public ApiSectorDto() {
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getLatitut() {
        return latitut;
    }

    public void setLatitut(float latitut) {
        this.latitut = latitut;
    }

    public float getLongitut() {
        return longitut;
    }

    public void setLongitut(float longitut) {
        this.longitut = longitut;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public void setAproximacio(String aproximacio) {
        this.aproximacio = aproximacio;
    }

    public int getPopularitat() {
        return popularitat;
    }

    public void setPopularitat(int popularitat) {
        this.popularitat = popularitat;
    }

    public ApiEscolaDto getEscola() {
        return escola;
    }

    public void setEscola(ApiEscolaDto escola) {
        this.escola = escola;
    }
}