import system.ISistema;
import system.SistemaReproductor;
import ucn.*;
import util.Instalador;

public class Main {

    /**
     * Esta variable estática indica cual será la opción que permite salir del sistema.
     */
    private static final String OPCION_SALIDA = "X";
    private static ISistema SISTEMA_REPRODUCTOR;

    public static void main(String[] args) {
        // Guardamos la instancia del sistema en una variable estática.
        SISTEMA_REPRODUCTOR = instalarSistema();

        // Llamamos a la lectura del archivo.
        SISTEMA_REPRODUCTOR.lecturaArchivo();

        // Llamamos al menú inicial.
        menuInicial();
    }

    /**
     * Método que instancia el sistema.
     * @return Sistema instanciado.
     */
    private static ISistema instalarSistema() { return new Instalador().inyectarSistema(); }

    /**
     * Menú inicial del sistema.
     */
    private static void menuInicial() {

        String opcion = "";

        while (!OPCION_SALIDA.equals(opcion)) {
            StdOut.println("--------->Bienvenido a Spotify<---------");
            StdOut.println("[A] Buscar canción.");
            StdOut.println("[B] Crear playlist.");
            StdOut.println("[C] Reproducir canción.");
            StdOut.println("[D] Agregar canción a playlist.");
            StdOut.println("[E] Ordenar playlist según puesto en ranking.");
            StdOut.println("[F] Eliminar canción de playlist.");
            StdOut.println("[X] Guardar y salir del sistema.");
            StdOut.print("Ingrese su opción: ");

            opcion = StdIn.readString().toUpperCase();

            switch (opcion) {
                //case "A" ->
                //case "B" ->
                //case "C" ->
                //case "D" ->
                //case "E" ->
                //case "F" ->
                case OPCION_SALIDA -> salirSistema();
                default -> StdOut.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void salirSistema() {
        // Lógica para salir del sistema
        StdOut.println("Saliendo del sistema...");
    }

}