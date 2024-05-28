package model;

public class ListaSimple {

    private NodoSimple cabeza;
    private int cantidad;

    public ListaSimple() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    public void agregarCancion(Cancion cancion) {

        // Si la lista está vacía.
        if (this.cabeza == null) {
            this.cabeza = new NodoSimple(cancion);
            this.cantidad++;
            return;
        }

        // Si la lista tiene al menos un dato.

        NodoSimple nodoSimple = new NodoSimple(cancion);

        // Creamos un nodo aux para recorrer la lista.
        NodoSimple aux = this.cabeza;

        // Recorremos hasta encontrar el último nodo.
        while(aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }

        // Se setea el siguiente al nodo auxiliar.
        aux.setSiguiente(nodoSimple);
        this.cantidad++;
    }

    public Cancion obtenerCancion(String nombre) {

        if (this.cabeza == null) {
            return null;
        }

        NodoSimple aux = this.cabeza;

        while (aux != null){

            // Retornamos la canción si es que está en la lista.
            if (aux.getCancion().getNombre().equals(nombre)){
                return aux.getCancion();
            }
            // Cambiamos de nodo.
            aux = aux.getSiguiente();
        }

        // La canción no está en la lista.
        return null;
    }

    public NodoSimple getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoSimple cabeza) {
        this.cabeza = cabeza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
