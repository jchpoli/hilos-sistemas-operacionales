package co.com.hilos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author Jonathan Castelblanco Higuera <jcastelblanco@sistemasenlinea.com.co>
 */
public class Writer extends Thread {

    private final String pathFile;
    private final String content;
    private final int milisecondsWrite;

    public Writer(int milisecondsWrite, String pathFile, String content) {
        this.pathFile = pathFile;
        this.content = content;
        this.milisecondsWrite= milisecondsWrite;
    }

    public String getPathFile() {
        return pathFile;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void run() {
        this.writeFileContent();
    }

    private void writeFileContent() {
        try {
            System.out.println("Pausando 6 segundos creacion de archivo");
            Thread.sleep(this.milisecondsWrite);
            System.out.println("Creando archivo: " + this.pathFile);
            File fileText = new File(this.pathFile);
            if (!fileText.exists()) {
                fileText.createNewFile();
            }
            System.out.println("Escribiendo en archivo: " + this.pathFile);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileText))) {
                writer.write(this.content);
            }

        } catch (Exception e) {
            System.err.println("Error creando archivo " + pathFile);
        }
    }
}
