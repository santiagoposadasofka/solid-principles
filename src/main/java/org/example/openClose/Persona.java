package org.example.openClose;

public class Persona {
    private String nombre;
    private String membresia;
    public Persona(String nombre, String membresia) {
        this.nombre = nombre;
        this.membresia = membresia;
    }
    public String getNombre() {
        return nombre;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }
}
