package system;

import model.ListaCircular;
import model.ListaSimple;
import ucn.*;

import java.util.ArrayList;

public class SistemaReproductor implements ISistema{

    // Lista de canciones del sistema.
    ListaSimple listaSimpleCanciones = new ListaSimple();

    // Lista de playlists del usuario.
    ArrayList<ListaCircular> playlists = new ArrayList<>();

    @Override
    public void lecturaArchivo() {
        try {
            ArchivoEntrada archivoEntrada = new ArchivoEntrada("canciones.txt");

            while(!archivoEntrada.isEndFile()){

                // Obtiene la fila del archivo.
                Registro registroEntrada = archivoEntrada.getRegistro();

                String nombreCancion = registroEntrada.getString();
                String genero = registroEntrada.getString();
                int minutos = registroEntrada.getInt();
                int segundos = registroEntrada.getInt();
                int reproducciones = registroEntrada.getInt();
                int puestoRanking = registroEntrada.getInt();

                // TODO: Crear la lógica para agregar las canciones al sistema.

            }
            // Cerramos el archivo.
            archivoEntrada.close();
        }
        catch (Exception e){
            throw new RuntimeException("Ha ocurrido un error al leer el archivo.");
        }
    }
}
