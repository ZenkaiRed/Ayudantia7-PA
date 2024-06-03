package system;

public interface ISistema {

    void lecturaArchivo();

    String reproducirCancion();

    String buscarCancion(String nombre);

    boolean agregarCancionPlaylist(String nombreCancion);

}
