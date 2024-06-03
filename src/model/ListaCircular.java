package model;

public class ListaCircular {

    private NodoDoble cabeza;
    private int cantidadActual;

    public ListaCircular() {
        this.cabeza = null;
        this.cantidadActual = 0;
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

    public Cancion obtenerCancion(String nombre) {

        if (this.cabeza == null) {
            return null;
        }

        NodoDoble aux = this.cabeza;

        if (aux.getCancion().getNombre().equals(nombre)){
            return aux.getCancion();
        }

        aux = aux.getSiguiente();
        while (aux != this.cabeza){
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

    public boolean eliminarCancion(String nombre) {

        if (this.cabeza == null) {
            return false;
        }

        if (this.cabeza.getCancion().getNombre().equals(nombre)) {
            this.cabeza.setSiguiente(this.cabeza.getSiguiente());
        }

        NodoDoble aux = this.cabeza;
        NodoDoble auxAnterior = this.cabeza.getAnterior();

        while (aux.getSiguiente() != this.cabeza){
            if (aux.getCancion().getNombre().equals(nombre)) {

                aux.getSiguiente().setAnterior(auxAnterior);
                auxAnterior.setSiguiente(aux.getSiguiente());

                if (aux == this.cabeza) {
                    this.cabeza = aux.getSiguiente();
                }
                this.cantidadActual--;
                return true;
            }

            auxAnterior = aux;
            aux = aux.getSiguiente();
        }

        return false;
    }

}
