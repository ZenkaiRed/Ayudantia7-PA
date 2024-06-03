package system;

import model.Cancion;
import model.ListaCircular;
import model.ListaSimple;
import ucn.*;


public class SistemaReproductor implements ISistema{

    // Lista de canciones del sistema.
    ListaSimple listaCanciones = new ListaSimple();

    // Lista de playlists del usuario.
    ListaCircular playlist = new ListaCircular();
    int posicionCancionActual = 0;

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
                Cancion cancion = new Cancion(nombreCancion, genero, minutos, segundos, reproducciones, puestoRanking);
                this.listaCanciones.agregarCancion(cancion);

            }
            // Cerramos el archivo.
            archivoEntrada.close();
        }
        catch (Exception e){
            throw new RuntimeException("Ha ocurrido un error al leer el archivo.");
        }
    }

    @Override
    public String reproducirCancion() {

        if (this.listaCanciones.getCabeza() == null){
            return "No hay canciones en el sistema.";
        }

        if (this.posicionCancionActual >= this.listaCanciones.getCantidad()){
            return "No hay más canciones en la lista.";
        }

        Cancion cancionActual = this.listaCanciones.getCabeza().getCancion();
        this.posicionCancionActual = 0;

        return cancionActual.getNombre();
    }

    @Override
    public String buscarCancion(String nombre) {

        Cancion cancion = this.listaCanciones.obtenerCancion(nombre);

        if (cancion != null){
            return cancion.toString();
        }

        return "";
    }

    @Override
    public boolean agregarCancionPlaylist(String nombreCancion) {

        // Verificamos que la canción exista en el sistema.
        Cancion cancion = this.listaCanciones.obtenerCancion(nombreCancion);

        if (cancion != null){

            // Verificamos que la canción no esté en la playlist.
            Cancion cancionPlaylist = this.playlist.obtenerCancion(nombreCancion);

            if (cancionPlaylist != null){
                return false;
            }

            // Creamos una canción "copia" para agregar a la playlist.
            Cancion agregarCancion = new Cancion(cancion);

            // Agregamos la canción a la playlist y retornamos el resultado.
            return this.playlist.agregarCancion(agregarCancion);
        }

        return false;
    }
}
