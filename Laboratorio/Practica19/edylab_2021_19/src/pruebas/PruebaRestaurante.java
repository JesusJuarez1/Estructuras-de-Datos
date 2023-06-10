package pruebas;

import entradasalida.SalidaTerminal;
import registros.restaurante.Restaurante;
import registros.restaurante.TipoComida;
import registros.restaurante.TipoIngrediente;

public class PruebaRestaurante {
    public static void main(String[] args) {
        Restaurante r = new Restaurante();
        SalidaTerminal.consola("Platillos:\n");
        r.menuPlatillos();
        SalidaTerminal.consola("\nComidas e ingredientes:\n");
        r.comidasIngredientes();
        SalidaTerminal.consola("\nIngredientes de la comida (Torta):\n");
        r.ingredientesComida("Torta");
        SalidaTerminal.consola("\nAgregar ingredientes (Torta):\n");
        r.agregarIngredientes("Torta");
        r.comidasIngredientes();
        SalidaTerminal.consola("\nEliminar ingredientes (Torta):\n");
        r.eliminarIngredientes("Torta");
        r.comidasIngredientes();
        SalidaTerminal.consola("\nAgregar platillo:\n");
        r.agregarComida();
        r.menuPlatillos();
        SalidaTerminal.consola("\nEliminar platillo:\n");
        r.eliminarComida();
        r.menuPlatillos();
        SalidaTerminal.consola("\nPlatillos con ingrediente (Queso):\n");
        r.comidasConIngrediente("Queso");
        SalidaTerminal.consola("\nPlatillos del chef (Juan):\n");
        r.comidasDelChef("Juan");
        SalidaTerminal.consola("\nPlatillos con mas de 100 gramos:\n");
        r.platillosConMas(100);
        SalidaTerminal.consola("\nPlatillos que llevan ingredientes de tipo (liquido)\n");
        r.comidaConIngTipo(TipoIngrediente.LIQUIDO);
        SalidaTerminal.consola("\nPlatillos de tipo (Vejetariano)\n");
        r.platillosTipo(TipoComida.VEGETARIANA);
        SalidaTerminal.consola("\nEliminar platillos tipo (Carnivoros)\n");
        r.eliminarPlatillosTipo(TipoComida.CARNIVORA);
        r.menuPlatillos();
    }
}
