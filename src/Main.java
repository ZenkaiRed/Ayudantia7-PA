import system.ISistema;
import ucn.*;
import util.Instalador;

public class Main {

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

        while (!opcion.equals("X")) {
            StdOut.println("--------->Bienvenido a Spotify<---------");
            StdOut.println("[A] Buscar canción.");
            StdOut.println("[B] Reproducir canción.");
            StdOut.println("[C] Agregar canción a playlist.");
            StdOut.println("[D] Ordenar playlist según puesto en ranking.");
            StdOut.println("[E] Eliminar canción de playlist.");
            StdOut.println("[X] Guardar y salir del sistema.");
            StdOut.print("Ingrese su opción: ");

            opcion = StdIn.readString().toUpperCase();

            switch (opcion) {
                //case "A" ->
                case "B" -> reproductor();
                //case "C" ->
                //case "D" ->
                //case "E" ->
                case "X" -> salirSistema();
                default -> StdOut.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    /**
     * Método que hace referencia al reproductor del sistema.
     */
    private static void reproductor() {

        String opcion = "";

        while (!opcion.equals("X")) {
            StdOut.println("--------->Reproductor<---------");

            // TODO: TRAER DATOS DE LA CANCIÓN.

            StdOut.println("[A] Siguiente canción.");
            StdOut.println("[B] Anterior canción.");
            StdOut.println("[X] Volver al menú anterior");
            StdOut.print("Ingrese su opción: ");

            opcion = StdIn.readString().toUpperCase();

            switch (opcion) {
                //case "A" ->
                //case "B" ->
                default -> StdOut.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void salirSistema() {
        // Lógica para salir del sistema
        StdOut.println("Saliendo del sistema...");
    }

}