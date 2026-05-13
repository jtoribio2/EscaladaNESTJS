package model.dto.api;

public class ApiTipusViaDto {

    private int idTipusVia;
    private String tipus;

    public ApiTipusViaDto() {
    }

    public int getIdTipusVia() {
        return idTipusVia;
    }

    public void setIdTipusVia(int idTipusVia) {
        this.idTipusVia = idTipusVia;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}