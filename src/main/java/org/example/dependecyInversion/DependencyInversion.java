package org.example.dependecyInversion;

public class DependencyInversion {
    public void ejecutar() {
        System.out.println("Ejecutando ejemplos del patrón Dependency Inversion.");
        /*
         * Instancia de diferentes servicios de correo.
         * Instancia de diferentes empleados.
         * Uso de los métodos del empleado, sin importar el servicio de correo usado.
         */
        ServicioDeCorreo gmailService = new GmailService();
        ServicioDeCorreo outlookService = new OutlookService();
        Empleado SantiagoPosada = new Empleado(gmailService);
        Empleado JesusMiguel = new Empleado(outlookService);
        SantiagoPosada.setServicioDeCorreo(outlookService);
        JesusMiguel.setServicioDeCorreo(gmailService);
        SantiagoPosada.enviarCorreo("Jesús", "Tareas", "Debemos terminar las tareas.");
        JesusMiguel.enviarCorreo("Santiago", "Agendar día", "Claro que si. Ahora agendemos cuándo.");

        System.out.println("\nEjecutando nuevo ejemplo anti-patrón de Dependency Inversion.");
        /*
         * Instancia de un libro.
         * Instancia de un estante
         * Uso de los comportamientos del libro.
         * Se añade el libro al estante.
         * Luego, no es posible agregar carpetas al estante sin modificarlo, se viola el principio Open Close y si se
         * agregara una interfaz objeto no se violaría el principio Dependency Inversion.
         */
        Libro libro = new Libro();
        Estante estante = new Estante();
        libro.marcar();
        libro.leer();
        estante.agregarLibro(libro);
        estante.ordenarEstante();
    }
}

/*
 * Un ejemplo de inversión de dependencia en Java podría ser una clase "Empleado" que depende de una interfaz
 * "ServicioDeCorreo" para enviar correos electrónicos. En lugar de que "Empleado" dependa directamente de una
 * implementación específica de "ServicioDeCorreo", como "GmailService" u "OutlookService", se proporciona una instancia
 * de "ServicioDeCorreo" a través de un constructor o un setter. De esta forma, "Empleado" no tiene conocimiento de cómo
 * se envían los correos electrónicos, sino que simplemente utiliza la interfaz.
 */

interface ServicioDeCorreo {
    void enviarCorreo(String destinatario, String asunto, String mensaje);
}

class GmailService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envía correo utilizando la API de Gmail
        System.out.println("Enviando email desde google " +
                "a " + destinatario + " con el asunto "
                + asunto + "diciéndole: " + mensaje);
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envía correo utilizando la API de Outlook
        System.out.println("Enviando email desde outlook " +
                "a " + destinatario + " con el asunto "
                + asunto + "diciéndole: " + mensaje);
    }
}

/*
 * Se puede ver como la clase Empleado tiene una dependencia de la interfaz ServicioDeCorreo, pero no tiene conocimiento
 * sobre como se envía el correo, sino que se le proporciona un objeto que implementa la interfaz ServicioDeCorreo a
 * través de un constructor o un setter, de esta forma se cumple con el principio de inversión de dependencia, ya que la
 * clase Empleado no depende directamente de una implementación específica de ServicioDeCorreo.
 */

class Empleado {
    private ServicioDeCorreo servicioDeCorreo;

    public Empleado(ServicioDeCorreo servicioDeCorreo) {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public void setServicioDeCorreo(ServicioDeCorreo servicioDeCorreo) {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        servicioDeCorreo.enviarCorreo(destinatario, asunto, mensaje);
    }
}

/*
 * Un ejemplo de anti-patrón del principio de Dependency Inversion en Java podría ser una clase "Estante" que almacena
 * libros. Pero alguien luego quiere agregar también carpetas, por lo que ahora la clase Estante se debe modificar para
 * almacenar estas carpetas con los libros, violando el principio, esto en lugar de almacenar simples objetos como
 * interfase, y que cada nuevo objeto implemente esta interfaz, donde la estantería solo añade objetos sin importarle su
 * clase.
 */

class Libro {
    void leer() {
        System.out.println("Leyendo libro.");
    }

    void marcar() {
        System.out.println("Marcando libro.");
    }
}

class Carpeta {
    void leer() {
        System.out.println("Leyendo carpeta.");
    }

    void marcar() {
        System.out.println("Marcando carpeta.");
    }
}

class Estante {
    Libro libro;
    // Tocaría añadir un atributo tipo Carpeta para agregar carpetas al estante, osea que las dependencias están mal.
    void agregarLibro(Libro libro) {
        this.libro = libro;
        System.out.println("Añadiendo " + libro + " al estante.");
    }

    void ordenarEstante() {
        System.out.println("Ordenando estante.");
    }
}