package org.example.interfaceSegregation;

public class ModeloAntigup extends ImpresoraMultifuncional{
    @Override
    public String Cancelar() {
        return "Cancelando Impresion";
    }

    @Override
    public String Escanear() {
        return "Escaneando documento";
    }

    @Override
    public String Imprimir() {
        return "Imprimiendo documentos";
    }
}
