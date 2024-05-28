package model;

public class ListaCircular {

    private NodoDoble cabeza;
    private int cantidadActual;
    private String cancionActual;

    public ListaCircular() {
        this.cabeza = null;
        this.cantidadActual = 0;
        this.cancionActual = "";
    }

    public boolean agregarCancion(Cancion cancion) {

        // Comprobamos si la lista está vacía.
        if (this.cabeza == null) {
            this.cabeza = new NodoDoble(cancion);

            this.cabeza.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cabeza);

            this.cantidadActual++;
            return true;
        }

        NodoDoble nuevoNodo = new NodoDoble(cancion);

        NodoDoble aux = this.cabeza;

        while (aux.getSiguiente() != this.cabeza){
            aux = aux.getSiguiente();
        }

        nuevoNodo.setSiguiente(this.cabeza);
        this.cabeza.setAnterior(nuevoNodo);

        aux.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(aux);

        this.cantidadActual++;
        return true;
    }
}
