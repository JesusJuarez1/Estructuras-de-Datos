package registros.calculadora;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloPila;
import herramientas.matematicas.ExpresionAritmetica;

public class Calculadora {
    protected ArregloPila pila;
    protected String expresion;

    public Calculadora(String expresion){
        pila = new ArregloPila(expresion.length());
        this.expresion = expresion;
    }

    public Double separarExpresion(){
        String tmp = expresion;
        for(int posicion=0;posicion<expresion.length();posicion++){
            char token = tmp.charAt(posicion);
            if(token != ' '){
                if(!ExpresionAritmetica.esOperando(token)){
                    pila.poner(""+token);
                }else if(esNumero(token)){
                    String numero = "";
                    while(esNumero(token) && posicion<expresion.length()){
                        numero += token;
                        posicion++;
                        token = tmp.charAt(posicion);
                    }
                    pila.poner(Double.parseDouble(numero));
                    posicion--;

                }else if(esVariable(token) || token == '$'){
                    String variable = "";
                    while(esVariable(token) && posicion<expresion.length() && ExpresionAritmetica.esOperando(token)){
                        variable += token;
                        posicion++;
                        token = tmp.charAt(posicion);
                    }
                    pila.poner(pedirValorVariable(variable));
                    posicion--;
                }
            }
        }
        return resolver(pila);
    }

    public Double resolver(ArregloPila pila){
        while(!pila.vacio()){
            if(pila.verTope() == ")"){
                pila.quitar();

            }
        }
        return 0.0;

        /*
        if(!pila.vacio()){
            double resultado = 0.0;
            while(!pila.vacio()){
                Object elemento = pila.verTope();
                if(elemento instanceof Double){
                    Double operando = (Double)pila.quitar();
                    String operador = ""+pila.quitar();
                    if(pila.verTope().equals(")")){
                        Double oper1 = 0.0;
                        String opera = "";
                        Double oper2 = 0.0;
                        Double res = 0.0;
                        while(!pila.vacio()){
                            oper1 = (Double)pila.quitar();
                            opera = ""+pila.quitar();
                            oper2 = (Double)pila.quitar();
                            if(pila.verTope().equals("(")){
                                pila.quitar();
                            }
                            pila.poner(ExpresionAritmetica.operacionAritmetica(oper1,opera.charAt(0),oper2));
                        }
                    }else{
                        Double operando2 = (Double) pila.quitar();
                        if(!pila.vacio()){
                            pila.poner(ExpresionAritmetica.operacionAritmetica(operando,operador.charAt(0),operando2));
                        }else{
                            return ExpresionAritmetica.operacionAritmetica(operando,operador.charAt(0),operando2);
                        }
                    }
                }else if(elemento instanceof String){
                    String operador = ""+pila.quitar();
                    if(operador.equals(")")){
                        Double oper1 = 0.0;
                        String opera = "";
                        Double oper2 = 0.0;
                        Double res = 0.0;
                        while(!pila.vacio()){
                            oper1 = (Double)pila.quitar();
                            opera = ""+pila.quitar();
                            oper2 = (Double)pila.quitar();
                            if(pila.verTope().equals("(")){
                                pila.quitar();
                            }
                            pila.poner(ExpresionAritmetica.operacionAritmetica(oper1,opera.charAt(0),oper2));
                        }
                    }else{
                        return null;
                    }
                }else{
                    return null;
                }
            }
            return resultado;
        }else{
            return null;
        }*/
    }

    /**
     * Pide el valor de la variable encontrada
     * @param var Variable de la cual se va pedir su valor
     * @return El valor que se ingrese
     */
    private Double pedirValorVariable(String var){
        SalidaTerminal.consola("Ingresa el valor de "+var+": ");
        return EntradaTerminal.consolaDouble();
    }

    /**
     * Evalua si el token pertenece a un numero (ya sea siendo un numero o un punto para separar los decimales)
     * @param token Token a evaluar
     * @return True si lo es, false en caso contrario
     */
    private boolean esNumero(char token){
        if(token == '.'){
            return true;
        }else{
            try {
                double n = Double.parseDouble(String.valueOf(token));
                return true;
            }catch(Exception e){
                return false;
            }
        }
    }

    private boolean esVariable(char token){
        if(token != ' ' && token != '(' && token != ')'){
            return true;
        }else{
            return false;
        }
    }
}
