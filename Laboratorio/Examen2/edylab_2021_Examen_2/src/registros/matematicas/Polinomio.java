package registros.matematicas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;
import herramientas.matematicas.ExpresionAritmetica;
import herramientas.matematicas.Matematicas;

public class Polinomio {
    protected ListaEncadenada polinomio;
    protected int grado;

    public Polinomio(){
        polinomio = new ListaEncadenada();
        grado = 0;
    }

    /**
     * Pide al usuario que ingrese un polinomio monomio por monomio, separa el monomio y lo agrega a la lista
     */
    public void agregarMonomios(){
        SalidaTerminal.consola("Ingrese el monomio: ");
        String monomio = EntradaTerminal.consolaCadena();
        if(monomio != ""){
            int constante = 1;
            int i = 0;
            char token = monomio.charAt(i);
            if(Matematicas.esNumero(""+token)){
                String num = ""+token;
                i++;
                for(i=i;i<monomio.length();i++){
                    token = monomio.charAt(i);
                    if(Matematicas.esNumero(""+token)){
                        num += token;
                    }else{
                        break;
                    }
                }
                constante = Integer.parseInt(num);
            }
            String var = "";
            String g = "0";
            for(i=i;i<monomio.length();i++){
                token = monomio.charAt(i);
                if(!Matematicas.esNumero(""+token)){
                    var += token;
                }else{
                    g = ""+token;
                }
            }
            if(var.equals("")){
                g = "1";
            }else{
                if(g.equals("0")){
                    g = "1";
                }
            }
            int grado = Integer.parseInt(g);
            polinomio.agregar(new Monomio(constante,var,grado));
        }
        SalidaTerminal.consola("¿Ingresar mas (S/N)? ");
        String r = EntradaTerminal.consolaCadena();
        if(r.equalsIgnoreCase("S")){
            agregarMonomios();
        }
    }

    /**
     * Llama al metodo recursivo imprimirPol
     */
    public void imprimirPolinomio(){
        polinomio.inicializarIterador();
        imprimirPol();
    }

    /**
     * Imprime el polinomio
     */
    private void imprimirPol(){
        if(polinomio.hayElementos()){
            Monomio m = (Monomio)polinomio.obtenerElemento();
            if(m.getConstante() > 0){
                SalidaTerminal.consola("+");
            }else{
                SalidaTerminal.consola("-");
            }
            SalidaTerminal.consola(m.getConstante()+ m.getVariable()+"^"+m.getGrado()+" ");
            imprimirPol();
        }
    }

    /**
     * Invoca al metodo determinarG
     */
    public void determinarGrado(){
        polinomio.inicializarIterador();
        determinarG();
    }

    /**
     * Obtiene el grado mayor de los monomios
     */
    private void determinarG(){
        if(polinomio.hayElementos()){
            Monomio m = (Monomio)polinomio.obtenerElemento();
            if(m.getGrado() > grado){
                grado = m.getGrado();
            }
            determinarG();
        }
    }

    /**
     * Obtiene el grado obtenido
     * @return El grado obtenido
     */
    public int getGrado(){
        return grado;
    }

    /**
     * Invoca al metodo polinomioXEsc
     * @param escalar Escalar por el cual se va a multiplicar el polinomio
     */
    public void xEscalar(int escalar){
        polinomio.inicializarIterador();
        xEscalar(escalar,0);
    }

    /**
     * Multiplica el escalar por cada monomio
     * @param escalar Escalar por el cual se va a multiplicar cada monomio
     * @param posicion Posicion actual en la lista polinomio
     */
    private void xEscalar(int escalar,int posicion){
        if(polinomio.hayElementos()){
            Monomio m = (Monomio)polinomio.obtenerElemento();
            polinomio.cambiar(posicion,new Monomio(m.constante*escalar, m.variable, m.grado));
            xEscalar(escalar,++posicion);
        }
    }

    /**
     * Llama al metodo polinomioXMonomio
     * @param m Monomio por el cual se va a multiplicar el polinomio
     */
    public void xMonomio(Monomio m){
        polinomio.inicializarIterador();
        xMonomio(m,0);
    }

    /**
     * Multiplica un monomio por cada monomio del polinomio
     * @param m Monomio a multiplicar
     * @param posicion Posicion actual en la lista
     */
    private void xMonomio(Monomio m,int posicion){
        if(polinomio.hayElementos()){
            Monomio mon = (Monomio)polinomio.obtenerElemento();
            int g = m.getGrado()+mon.getGrado();
            int con = m.getConstante()*mon.getConstante();
            if(mon.getVariable().equals("")){
                g--;
            }
            polinomio.cambiar(posicion,new Monomio(con,m.getVariable(),g));
            xMonomio(m,++posicion);
        }
    }

    /**
     * Llama al metodo xPol
     * @param p Polinomio por el cual se va multiplicar el polinomio actual
     */
    public void xPolinomio(Polinomio p){
        p.polinomio.inicializarIterador();
        xPol(p);
    }

    /**
     * Obtiene los monomios del polinomio p y llama al metodo xMonomio
     * @param p Polinomio por el cual se va multiplicar
     */
    private void xPol(Polinomio p){
        if(p.polinomio.hayElementos()){
            Monomio m = (Monomio)p.polinomio.obtenerElemento();
            xMonomio(m);
            xPol(p);
        }
    }

    /**
     * Invoca al metodo sumaPol
     * @param p Polinomio a sumar
     */
    public void sumaPolinomio(Polinomio p){
        p.polinomio.inicializarIterador();
        sumaPol(p);
    }

    /**
     * Suma el polinomio p al actual
     * @param p Polinomio a sumar
     */
    private void sumaPol(Polinomio p){
        if(p.polinomio.hayElementos()){
            Monomio m = (Monomio)p.polinomio.obtenerElemento();
            polinomio.inicializarIterador();
            int posicion = 0;
            Monomio m2 = null;
            while(polinomio.hayElementos() ){
                m2 = (Monomio)polinomio.obtenerElemento();
                if(m.getGrado() == m2.grado && m.getVariable().equals(m2.getVariable())){
                    break;
                }
                posicion++;
            }
            if(m.getGrado() == m2.grado && m.getVariable().equals(m2.getVariable())){
                polinomio.cambiar(posicion,new Monomio(m.constante+m2.constante,m.getVariable(),m.getGrado()));
            }else{
                polinomio.agregar(m);
            }
            sumaPol(p);
        }
    }
}
