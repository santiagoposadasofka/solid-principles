package org.example.interfaceSegregation;

public class ModeloActual extends ImpresoraMultifuncional{
    @Override
    public String Cancelar() {
        return "Cancelando impresion";
    }

    @Override
    public String Escanear() {
        return "Escaneando documento";
    }

    @Override
    public String Imprimir() {
        return "Imprimiendo documento";
    }
    public String Fotocopiar(){
        return "Copia de documentos";
    }
}
