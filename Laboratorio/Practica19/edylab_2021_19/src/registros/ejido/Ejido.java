package registros.ejido;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

/**
 * Clase que almacena los 7 campesinos
 * @author Jesus
 * @version 1.0
 */
public class Ejido implements IEjido{
    protected ArregloDatos campesinos;

    public Ejido(){
        campesinos = new ArregloDatos(7);
    }

    @Override
    public boolean agregarCampesino(Campesino campesino){
        int r = campesinos.agregar(campesino);
        if(r == -1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Double promedioCosechaCampesino(String nombreCampesino,String cosecha){
        Integer pos = (Integer) campesinos.buscar(nombreCampesino);
        if(pos != null){
            Campesino camp = (Campesino) campesinos.obtener(pos);
            return camp.promedioCosecha(cosecha);
        }else{
            return null;
        }
    }

    @Override
    public Campesino menosCosecha(String nombreCos,int year){
        Campesino camp = null;
        Cosecha menor = null;
        for(int posicion=0;posicion<campesinos.cantidadElementos();posicion++){
            Campesino campesino = (Campesino) campesinos.obtener(posicion);
            ArregloDatos anios = campesino.anios;
            Integer bAnio = (Integer)anios.buscar(year);
            if(bAnio != null){
                Anio anio = (Anio)anios.obtener(bAnio);
                ArregloDatos cosechas = anio.cosechas;
                Integer cos = (Integer) cosechas.buscar(nombreCos);
                if(cos != null){
                    Cosecha cosecha = (Cosecha) cosechas.obtener(cos);
                    if(menor == null){
                        menor = cosecha;
                        camp = campesino;
                    }else if(menor.getToneladas() > cosecha.getToneladas()){
                        menor = cosecha;
                        camp = campesino;
                    }
                }
            }else{
                return null;
            }
        }
        return camp;
    }

    @Override
    public Campesino favorecido(int year){
        Campesino camp = null;
        double mayor = 0.0;
        for(int posicion=0;posicion<campesinos.cantidadElementos();posicion++){
            Campesino campesino = (Campesino) campesinos.obtener(posicion);
            ArregloDatos anios = campesino.anios;
            Integer bAnio = (Integer)anios.buscar(year);
            if(bAnio != null){
                Anio anio = (Anio)anios.obtener(bAnio);
                ArregloDatos cosechas = anio.cosechas;
                double cantidad = 0.0;
                for(int pos=0;pos<cosechas.cantidadElementos();pos++){
                    Cosecha cosecha = (Cosecha) cosechas.obtener(pos);
                    cantidad += cosecha.toneladas;
                }
                if(mayor == 0.0){
                    mayor = cantidad;
                    camp = campesino;
                }else if(mayor < cantidad){
                    mayor = cantidad;
                    camp = campesino;
                }
            }else{
                return null;
            }
        }
        return camp;
    }

    @Override
    public Cosecha cosechaMasConvinoAnio(int year){
        ArregloDatos productos = new ArregloDatos(6);
        for(int pos=0;pos<productos.capacidad();pos++){
            productos.agregar(0.0);
        }
        for(int posicion=0;posicion<campesinos.cantidadElementos();posicion++){
            Campesino campesino = (Campesino) campesinos.obtener(posicion);
            ArregloDatos anios = campesino.anios;
            Integer bAnio = (Integer)anios.buscar(year);
            if(bAnio != null) {
                Anio anio = (Anio) anios.obtener(bAnio);
                ArregloDatos cosechas = anio.cosechas;
                for(int pos=0;pos<cosechas.cantidadElementos();pos++){
                    productos.agregar(((double)productos.obtener(pos))+((Cosecha)cosechas.obtener(pos)).toneladas);
                }
            }else{
                return null;
            }
        }
        Cosecha mejor = new Cosecha("Frijol",(double)productos.obtener(0));
        for(int pos=1;pos<productos.cantidadElementos();pos++){
            if(((double)productos.obtener(pos)) > mejor.getToneladas()){
                mejor.setToneladas((double)productos.obtener(pos));
                switch(pos){
                    case 1:
                        mejor.setNombre("Maiz");
                        break;
                    case 2:
                        mejor.setNombre("Chile");
                        break;
                    case 3:
                        mejor.setNombre("Zanahoria");
                        break;
                    case 4:
                        mejor.setNombre("Ajo");
                        break;
                    case 5:
                        mejor.setNombre("Cebolla");
                        break;
                }
            }
        }
        return mejor;
    }

    @Override
    public Anio anioMejorProdujo(String nomCampesino,String producto){
        Anio anioMejor = null;
        double cantidad = 0.0;
        Integer camp = (Integer) campesinos.buscar(nomCampesino);
        if(camp != null){
            Campesino campesino = (Campesino) campesinos.obtener(camp);
            ArregloDatos anios = campesino.anios;
            for(int pos=0;pos<anios.cantidadElementos();pos++){
                Anio anio = (Anio)anios.obtener(pos);
                ArregloDatos cosechas = anio.cosechas;
                Integer cos = (Integer) cosechas.buscar(producto);
                if(cos != null){
                    Cosecha cosecha = (Cosecha) cosechas.obtener(cos);
                    if(cantidad < cosecha.toneladas){
                        cantidad = cosecha.toneladas;
                        anioMejor = anio;
                    }
                }else{
                    return null;
                }
            }
        }else{
            return null;
        }
        return anioMejor;
    }

    public ArregloDatos menorCantProd(String nomCampesino, String producto){ //No terminado
        ArregloDatos menores = new ArregloDatos(6);
        Campesino campes = null;
        double cantidad = 0.0;
        Integer camp = (Integer) campesinos.buscar(nomCampesino);
        if(camp != null){
            Campesino campesino = (Campesino) campesinos.obtener(camp);
            ArregloDatos anios = campesino.anios;
            for(int pos=0;pos<anios.cantidadElementos();pos++){
                Anio anio = (Anio)anios.obtener(pos);
                ArregloDatos cosechas = anio.cosechas;
                Integer cos = (Integer) cosechas.buscar(producto);
                if(cos != null){
                    Cosecha cosecha = (Cosecha) cosechas.obtener(cos);
                    if(cantidad < cosecha.toneladas){
                        cantidad = cosecha.toneladas;
                        campes = campesino;
                    }
                }else{
                    return null;
                }
            }
        }else{
            return null;
        }
        return null;
    }

    @Override
    public Campesino menosCosechaActual(){
        Campesino camp = null;
        double menor = 0.0;
        for(int posicion=0;posicion<campesinos.cantidadElementos();posicion++){
            Campesino campesino = (Campesino) campesinos.obtener(posicion);
            ArregloDatos anios = campesino.anios;
            Anio anio = (Anio)anios.obtener(anios.cantidadElementos()-1);
            ArregloDatos cosechas = anio.cosechas;
            double cantidad = 0.0;
            for(int pos=0;pos<cosechas.cantidadElementos();pos++){
                Cosecha cosecha = (Cosecha) cosechas.obtener(pos);
                cantidad += cosecha.toneladas;
            }
            if(menor > cantidad){
                menor = cantidad;
                camp = campesino;
            }
        }
        return camp;
    }

    @Override
    public Double cantidadTonelCampesinos(ArregloDatos campes,String producto){
        double cantidad = 0.0;
        for(int pos=0;pos<campes.cantidadElementos();pos++){
            Campesino campesino = (Campesino)campesinos.obtener((Integer)campesinos.buscar(campes.obtener(pos)));
            cantidad += campesino.cantidadTonel(producto);
        }
        return cantidad;
    }

    @Override
    public Campesino produceMenosQue(double cantidad){
        ArregloDatos cosechas = ((Anio)((ArregloDatos)((Campesino)campesinos.obtener(0)).anios).obtener(0)).cosechas;
        for(int posicion=0;posicion<campesinos.cantidadElementos();posicion++){
            Campesino campesino = (Campesino) campesinos.obtener(posicion);
            double sumaProductos = 0.0;
            for(int pos=0;pos<cosechas.cantidadElementos();pos++){
                sumaProductos += campesino.cantidadTonel(((Cosecha)cosechas.obtener(pos)).getNombre());
            }
            if(cantidad > (sumaProductos/((ArregloDatos)((Campesino)campesinos.obtener(0)).anios).cantidadElementos())){
                return campesino;
            }
        }
        return null;
    }

    @Override
    public Cosecha produceMasQue(double cantidad){
        for(int pos=0;pos<campesinos.cantidadElementos();pos++){
            Campesino camp = (Campesino) campesinos.obtener(pos);
            Cosecha cos = camp.produceMasQue(cantidad);
            if(cos != null){
                return cos;
            }
        }
        return null;
    }
}
