package co.com.hilos;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jonathan Castelblanco Higuera <jcastelblanco@sistemasenlinea.com.co>
 */
public class Executor {

    public static void main(String[] args) {

        System.out.println("Ejecutando");
        try {
            int milisecondsWrite = 6000;
            if (args.length> 0) {
                milisecondsWrite = Integer.parseInt(args[0]);
            }
            String jarPath = Executor.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();

            String pathDirectory = jarPath.substring(0, jarPath.lastIndexOf("/") + 1);
            String nameFile = pathDirectory + "archivo-prueba-programa-hilos-" + UUID.randomUUID() + ".txt";
            System.out.println("Directorio base: " + pathDirectory);


            System.out.println("Milisegundos de escritura de archivo : " + milisecondsWrite);

            Writer hiloWriter = new Writer(milisecondsWrite, nameFile, "Este es el contenido del archivo de prueba generado " + new Date().toString());
            Reader hiloReader = new Reader(hiloWriter.getPathFile());

            hiloWriter.start();
            hiloReader.start();

        } catch (Exception e) {
            System.err.println("Error en el programa");
        }

    }
}
