package registros.productos;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla3D;

public class ControlCosechas {
    protected Tabla3D toneladasProductos;
    protected ArregloDatos campesinos;
    protected ArregloDatos anios;
    protected ArregloDatos productos;

    public ControlCosechas(int numProductos, int numCampesinos, int numAnios){
        toneladasProductos=new Tabla3D(numProductos,numCampesinos,numAnios,0.0);
        productos=new ArregloDatos(numProductos);
        campesinos=new ArregloDatos(numCampesinos);
        anios=new ArregloDatos(numAnios);
    }

    public boolean agregarProducto(String producto){
        Integer posicionB=(Integer)productos.buscar(producto);
        if(posicionB==null) { //no existe, podemos agregarlo
            int posicionA=productos.agregar(producto);
            if(posicionA==-1){ //no lo pudo agregar
                return false;
            }else{ //si lo agregó
                return true;
            }
        }else{ //ya existe
            return false;
        }
    }

    public boolean agregarCampesino(Campesino objCampesino){
        Integer posicionB=(Integer)campesinos.buscar(objCampesino);
        if(posicionB==null) { //no existe, podemos agregarlo
            int posicionA=campesinos.agregar(objCampesino);
            if(posicionA==-1){ //no lo pudo agregar
                return false;
            }else{ //si lo agregó
                return true;
            }
        }else{//ya existe
            return false;
        }
    }

    public boolean agregarAnio(int anio){
        Integer posicionB=(Integer)anios.buscar(anio);
        if(posicionB==null) { //no existe, podemos agregarlo
            int posicionA=anios.agregar(anio);
            if(posicionA==-1){ //no lo pudo agregar
                return false;
            }else{ //si lo agregó
                return true;
            }
        }else{ //ya existe
            return false;
        }
    }

    public boolean agregarCosecha(String producto, String claveCamp, int anio, double toneladasProducto){
        //Necesito buscar las posiciones fila, col, prof, en mi tabla3d
        ArregloDatos indices=validarCelda(producto,claveCamp,anio);
        if(indices!=null){ //existe una celda valida
            return toneladasProductos.asignarCelda((int)indices.obtener(0),
                                                (int)indices.obtener(1),(int)indices.obtener(2),
                                                toneladasProducto);
        }else{//no existe uno de esos valores buscados
            return false;
        }
    }

    public void imprimirProductos(){
        productos.imprimirOrdenInverso();
    }

    public void imprimirCampesinos(){
        campesinos.imprimirOrdenInverso();
    }

    public void imprimirAnios(){
        anios.imprimirOrdenInverso();
    }

    public void imprimirCosechas(){
        toneladasProductos.imprimirxColumnas();
    }

    public void imprimirDatosCosechas(){
        SalidaTerminal.consola("Los datos de las cosechas son los siguientes \n");
        SalidaTerminal.consola("Los datos de los productos: \n");
        imprimirProductos();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Los datos de los campesinos: \n");
        imprimirCampesinos();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Los datos de los años: \n");
        imprimirAnios();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Los datos de las toneladas: \n");
        imprimirCosechas();
        SalidaTerminal.consola("\n");
    }

    public double cosechaProductoCampesino(String producto, String claveCamp, ArregloDatos aniosSolicitados){
        double toneladasCosechas=0.0;

        //me piden de varios anios, recorro el arreglo
        for(int anio=0;anio<aniosSolicitados.cantidadElementos();anio++){
            //sacar cada año y necesito extraer la celda de ese año, de ese campesino, de ese producto
            double celdaToneladas=obtenerCosechaxProductoCampesinoAnio(producto,claveCamp,
                                                                        (int)aniosSolicitados.obtener(anio));
            if(celdaToneladas!=-1){
                //acumular toneladas
                toneladasCosechas= toneladasCosechas + celdaToneladas;
            }
        }
        return toneladasCosechas;
    }

    public double obtenerCosechaxProductoCampesinoAnio(String producto, String claveCamp, int anio){
        ArregloDatos indices=validarCelda(producto,claveCamp,anio);
        if(indices!=null){ //si existen esos indices
            //sscar de la celda, el valor de las toneladas
            return (double)toneladasProductos.obtenerCelda((int)indices.obtener(0), //fila
                                                            (int)indices.obtener(1),//colum
                                                            (int)indices.obtener(2)); //prof
        }else{ //no son indices validos
            return -1.0;
        }
    }

    private ArregloDatos validarCelda(String producto, String claveCamp, int anio){
        //Necesito buscar las posiciones fila, col, prof, en mi tabla3d
        Integer indiceProducto=(Integer)productos.buscar(producto);
        Integer indiceCampesino=(Integer)campesinos.buscar(claveCamp);
        Integer indiceAnio=(Integer)anios.buscar(anio);

        if(indiceProducto!=null && indiceCampesino!=null && indiceAnio!=null) { //existe una celda valida
            ArregloDatos indices=new ArregloDatos(3);
            indices.agregar(indiceProducto.intValue());
            indices.agregar(indiceCampesino.intValue());
            indices.agregar(indiceAnio.intValue());
            return indices;
        }else{ //no existe esda celda
            return null;
        }
    }
}
