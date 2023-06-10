package registros.matematicas;

public class Monomio {
    protected int constante;
    protected String variable;
    protected int grado;

    public Monomio(int constante,String variable,int poencia){
        this.constante = constante;
        this.variable = variable;
        this.grado = poencia;
    }

    public int getConstante() {
        return constante;
    }

    public void setConstante(int constante) {
        this.constante = constante;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String toString(){
        return constante+variable+grado;
    }
}
