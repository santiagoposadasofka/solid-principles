package org.example.singleResponsibility;

public class SingleResponsabilityExample {
    /**
     * Cada clase debe tener un único proposito, o debe cumplir una única función.
     * En el caso del ejemplo, la clase PasswordHasher no debería tener la responsabilidad de
     * guardar información en la base de datos.
     */

    public void ejecutar(){
        PasswordHasher passwordHasher = new PasswordHasher();
        var mensaje = passwordHasher.hashAndSavePassword("my_password");
        System.out.println(mensaje);
    }
}

