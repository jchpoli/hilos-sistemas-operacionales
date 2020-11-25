package co.com.hilos;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Jonathan Castelblanco Higuera <jocastelblanco3@poligran.edu.co>
 */
public class Reader extends Thread {

    private final String pathFile;
    private String contentFile;

    public Reader(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public String getContentFile() {
        return contentFile;
    }

    @Override
    public void run() {
        this.readFileContent();
        if(this.contentFile!=null){
            System.out.println("El contenido del archivo es el siguiente:");
            System.out.println(this.contentFile);
        }else {
            System.out.println("No se encontró archivo para leer");
        }

    }

    private void readFileContent(){
        try {
            int count = 0;
            while (count <= 10) {
                System.out.println("Intento "+count+" de leer el archivo "+this.pathFile);
                File fileText = new File(this.pathFile);
                if (fileText.exists()) {
                    byte[] content = Files.readAllBytes(fileText.toPath());
                    this.contentFile = new String(content);
                    System.out.println("Archivo leido con exito");
                    break;
                } else {
                    count++;
                    System.out.println("Esperando 1 segundo para leer el archivo "+this.pathFile);
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo del archivo " + this.pathFile);
        }
    }
}
