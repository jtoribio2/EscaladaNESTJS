package model.dto.api;

public class ApiViaDto {

    private int id_via;
    private String nom;
    private int llargada;
    private String dificultat;
    private String orientacio;
    private String ancoratge;
    private String troca;

    private ApiSectorDto sector;
    private ApiTipusViaDto tipusVia;

    public ApiViaDto() {
    }

    public int getId_via() {
        return id_via;
    }

    public void setId_via(int id_via) {
        this.id_via = id_via;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLlargada() {
        return llargada;
    }

    public void setLlargada(int llargada) {
        this.llargada = llargada;
    }

    public String getDificultat() {
        return dificultat;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }

    public String getAncoratge() {
        return ancoratge;
    }

    public void setAncoratge(String ancoratge) {
        this.ancoratge = ancoratge;
    }

    public String getTroca() {
        return troca;
    }

    public void setTroca(String troca) {
        this.troca = troca;
    }

    public ApiSectorDto getSector() {
        return sector;
    }

    public void setSector(ApiSectorDto sector) {
        this.sector = sector;
    }

    public ApiTipusViaDto getTipusVia() {
        return tipusVia;
    }

    public void setTipusVia(ApiTipusViaDto tipusVia) {
        this.tipusVia = tipusVia;
    }
}