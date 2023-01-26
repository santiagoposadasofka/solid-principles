package org.example.singleResponsibility;

public class Puerta {

        private boolean estado;

        public Puerta(boolean estadoI) { this.estado = estadoI; }

        public void abrir(boolean estado) throws IllegalArgumentException {
            if (estado == true) {
                throw new IllegalArgumentException("La puerta esta abierta, no se puede volver a abrir");
            } else {
                System.out.println("Abriendo puerta");
                this.estado=true;
            }
        }

        public void cerrar(boolean estado) throws IllegalArgumentException {
            if (estado == false) {
                throw new IllegalArgumentException("La puerta esta cerrada, no se puede volver cerrar");
            } else {
                System.out.println("cerrando puerta");
                this.estado=false;
            }

        }

        public boolean isEstado() {
            return estado;
        }
    }

