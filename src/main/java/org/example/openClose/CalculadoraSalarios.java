package org.example.openClose;

public class CalculadoraSalarios {

    /**
     *Ejemplo de antipatron OpenClose
     * Que toma el objeto del tipo empleado y devuelve el salario calculado
     **/

    public double calcularSalario(Empleado empleado) {
        if (empleado.getTipoEmpleado().equals("fulltime")) {
            return empleado.getHorasTrabajadas() * empleado.getTarifaHora() + empleado.getBono();
        } else if (empleado.getTipoEmpleado().equals("parttime")) {
            return empleado.getHorasTrabajadas() * empleado.getTarifaHora();
        } else if (empleado.getTipoEmpleado().equals("temporario")) {
            return empleado.getHorasTrabajadas() * empleado.getTarifaHora() * 1.5;
        } else if (empleado.getTipoEmpleado().equals("contratista")) {
            return empleado.getHorasTrabajadas() * empleado.getTarifaHora() * 2;
        } else {
            return 0;
        }
    }
}
