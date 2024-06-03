package model;

public class Cancion {

    private String nombre;
    private String genero;
    private int minutos;
    private int segundos;
    private int reproducciones;
    private int puestoRanking;

    public Cancion(String nombre, String genero, int minutos, int segundos, int reproducciones, int puestoRanking) {
        this.nombre = nombre;
        this.genero = genero;
        this.minutos = minutos;
        this.segundos = segundos;
        this.reproducciones = reproducciones;
        this.puestoRanking = puestoRanking;
    }

    /**
     * Constructor de copia.
     * @param cancion Canción a copiar.
     */
    public Cancion(Cancion cancion) {
        this.nombre = cancion.getNombre();
        this.genero = cancion.getGenero();
        this.minutos = cancion.getMinutos();
        this.segundos = cancion.getSegundos();
        this.reproducciones = cancion.getReproducciones();
        this.puestoRanking = cancion.getPuestoRanking();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public int getPuestoRanking() {
        return puestoRanking;
    }

    public void setPuestoRanking(int puestoRanking) {
        this.puestoRanking = puestoRanking;
    }

    @Override
    public String toString() {

        // Formateamos la salida de la canción.
        return """
                Nombre: %s
                Tipo: %s
                Minutos: %d
                Segundos: %d
                Reproducciones: %d
                Ranking: %d
                """.formatted(this.nombre, this.genero, this.minutos, this.segundos, this.reproducciones, this.puestoRanking);
    }
}
