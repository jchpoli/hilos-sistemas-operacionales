# hilos-sistemas-operacionales

Este programa crea dos hilos, uno que crea un archivo y el otro que lee el archivo.
La creación del archivo se hace por defecto des pues de 6000 milisegundos (esto se puede configurar enviando un parametro a la ejecución del jar).
La lectura del archivo se intenta cada 1000 milisegundos por 10 intentos.

Para ejecutar el jar se realiza así: ```java -jar hilos-1.0-SNAPSHOT.jar 6000```
