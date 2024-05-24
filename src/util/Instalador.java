package util;

import system.ISistema;
import system.SistemaReproductor;

public class Instalador {

    private final ISistema sistemaReproductor;

    public Instalador(){ this.sistemaReproductor = new SistemaReproductor(); }

    public ISistema inyectarSistema(){ return this.sistemaReproductor; }
}
