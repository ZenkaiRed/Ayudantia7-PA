import system.ISistema;
import ucn.*;
import util.Instalador;

import java.util.Objects;

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
            StdOut.println("\n--------->Bienvenido a Spotify<---------");
            StdOut.println("[A] Buscar canción.");
            StdOut.println("[B] Reproducir canción.");
            StdOut.println("[C] Agregar canción a playlist.");
            StdOut.println("[D] Ordenar playlist según puesto en ranking.");
            StdOut.println("[E] Eliminar canción de playlist.");
            StdOut.println("[X] Guardar y salir del sistema.");
            StdOut.print("Ingrese su opción: ");

            opcion = StdIn.readString().toUpperCase();

            switch (opcion) {
                case "A" -> buscarCancion();
                case "B" -> reproductor();
                case "C" -> agregarCancionPlaylist();
                //case "D" ->
                //case "E" ->
                case "X" -> salirSistema();
                default -> StdOut.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void buscarCancion() {
        StdOut.println("\n--------->Buscar una canción<---------");
        StdOut.print("[*] Ingrese el nombre de la canción: ");

        String nombreCancion = StdIn.readLine();

        String cancionEncontrada = SISTEMA_REPRODUCTOR.buscarCancion(nombreCancion);

        if (cancionEncontrada.isEmpty()) {
            StdOut.println("La canción no se encuentra en el sistema.");
        } else {
            StdOut.println("Canción encontrada:");
            StdOut.println(cancionEncontrada);
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

    /**
     * Método que agrega una canción a la playlist del usuario.
     */
    private static void agregarCancionPlaylist() {

        StdOut.println("\n--------->Agregar canción a playlist<---------");
        StdOut.print("[*] Ingrese el nombre de la canción: ");
        String nombreCancion = StdIn.readString();

        boolean resultado = SISTEMA_REPRODUCTOR.agregarCancionPlaylist(nombreCancion);

        if (resultado){
            StdOut.println("Canción agregada a la playlist.");
        } else {
            StdOut.println("La canción no se encuentra en el sistema o ya está en la playlist.");
        }
    }

    private static void salirSistema() {
        // Lógica para salir del sistema
        StdOut.println("Saliendo del sistema...");
    }

}