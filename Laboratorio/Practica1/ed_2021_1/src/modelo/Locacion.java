package modelo;

public class Locacion {
    protected int cp;
    protected String estado;
    protected String municipio;
    protected String colonia;
    protected String calle;
    protected int numero;

    public Locacion(int cp,String estado,String municipio,String colonia,String calle,int numero) {
        this.cp = cp;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Locacion{" +
                "cp=" + cp +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", colonia='" + colonia + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                '}';
    }
}
