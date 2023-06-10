package herramientas.matematicas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloPila;
import estructuraslineales.ListaEncadenada;

public class ExpresionAritmetica {
    public static String pasarEInfijaAPostfija(String infija){
        return "";
    }

    public static String pasarEInfijaAPrefija(String infija){
        return "";
    }

    public static Double evaluaarEPostfija(String postfija){
        return 0.0;
    }

    public static Double evaluarEPrefija(String prefija){
        ArregloPila pila=new ArregloPila(prefija.length());

        //Tokenizar la E prefija     <----- -(0)  x(1)  *(2)  /(3)  y(4)  +(5)  f(6)  g(7)  ^(8)  h(9)  q(10)
        for(int posToken= (prefija.length() -1); posToken>=0;posToken-- ){
            //saco el token
            char token=prefija.charAt(posToken);

            //Si el token:
            //- Operando, se mete en una pila.
            if(esOperando(token)){
                if(pila.poner(""+token)==false){ //hubo algún error y no hay espacio en la pila
                    return null;
                }
            }else{
                //- Operador, se sacan dos operandos de la pila
                //(el primer elemento que se saca es OP1),
                //se aplica la operación del token y el resultado
                //se mete en la pila.
                String operando1=(String)pila.quitar();
                String operando2=(String)pila.quitar();

                if(operando1==null || operando2==null){ //hubo un error
                    return null;
                }else{ //si se pudo sacar de la pila dos elementos
                    Double resultadoTemporal=operacionAritmetica(Double.parseDouble(operando1), token,
                            Double.parseDouble(operando2));
                    if(resultadoTemporal==null){ //hubo un problema
                        return null;
                    }else{ //no hubo problema
                        pila.poner(""+resultadoTemporal);
                    }
                }
            }
        } //for de tokenizar
        //NOTA: El resultado final de la evaluación
        //está guardado en el tope de la pila.
        String resultadoFinal=(String)pila.quitar();
        if(resultadoFinal==null){
            return null; //la evaluación regresa null
        }else {
            return Double.parseDouble(resultadoFinal);
        }
    }

    public static Double operacionAritmetica(double operando1, char operador, double operando2){
        if(operador=='^'){
            return Math.pow(operando1,operando2);
        }else if(operador=='*'){
            return operando1*operando2;
        }else if(operador=='/'){
            return operando1/operando2;
        }else if(operador=='+'){
            return operando1+operando2;
        }else if(operador=='-'){
            return operando1-operando2;
        }else{
            return null;
        }
    }

    public static boolean esOperando(char token){
        if(token=='^' || token=='*' || token=='/' || token=='+' || token=='-' || token=='(' || token==')'){
            return false; //no es operando
        }else{
            return true; //si es operando
        }
    }

    public static boolean prioridad(String op, String op2) {
        if (op == "^") {
            if (op2 == "^") {
                return false;
            } else {
                return true;
            }
        } else if (op == "*" || op == "/") {
            if (op2 == "^" || op2 == "*" || op2 == "/") {
                return false;
            } else {
                return true;
            }
        } else{
            return false;
        }
    }
}
