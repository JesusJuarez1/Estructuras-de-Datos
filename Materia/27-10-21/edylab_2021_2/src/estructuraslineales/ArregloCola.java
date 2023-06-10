package estructuraslineales;

import entradasalida.SalidaTerminal;

public class ArregloCola implements LoteDatos{
    protected Object lote[];
    protected int frente;
    protected int fin;
    protected int CAPACIDAD;

    public ArregloCola(int capacidad){
        CAPACIDAD=capacidad;
        frente=-1;
        fin=-1;
        lote=new Object[CAPACIDAD];
    }

    @Override
    public boolean vacio(){
        if (frente==-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean lleno(){
        if( (frente==0 && fin==(CAPACIDAD -1)) || fin==(frente - 1)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean poner(Object elemento){
        if(lleno()==false){ //hay espacio
            if(vacio()==true){ //a
                frente=0;
                fin=0;
                //lote[fin]=elemento;
            }else if(fin == (CAPACIDAD -1)){ //c
                fin=0;
                //lote[fin]=elemento;
            }else{ //b y d
                fin++;
                //lote[fin]=elemento;
            }
            lote[fin]=elemento;
            return true;
        }else { //esta llena,  e
            return false;
        }
    }

    @Override
    public Object quitar(){
        if(vacio()==false){
            Object elementoBorrado=elementoBorrado=lote[frente];
            if(frente==fin){ //d
                //elementoBorrado=lote[frente];
                frente=-1;
                fin=-1;
            }else if(frente== (CAPACIDAD-1)){ //f
                //elementoBorrado=lote[frente];
                frente=0;
            }else{ //b y e
                //elementoBorrado=lote[frente];
                frente ++;
            }
            return elementoBorrado;
        }else { //vacio, a
            return null;
        }
    }

    @Override
    public void imprimir(){
        if(vacio()==false){ //hay algo
            if(frente<=fin){ //comportamiento normal
                for(int posicion=frente;posicion<=fin;posicion++){
                    SalidaTerminal.consola(lote[posicion]+ " ");
                }
            }else{ //comportamiento circular
                for(int posicion=frente;posicion<=(CAPACIDAD -1);posicion++){
                    SalidaTerminal.consola(lote[posicion]+ " ");
                }

                for(int posicion=0;posicion<=fin;posicion++){
                    SalidaTerminal.consola(lote[posicion]+ " ");
                }
            }
        }
    }

    @Override
    public Object verTope(){
        if(vacio()==false){
            return lote[frente];
        }else{
            return null;
        }
    }
}
