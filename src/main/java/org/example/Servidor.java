package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 12345;

        String informacion = """
                Introduce tipo de operación: 
                1- Suma
                2- Resta
                3- Multiplicación
                4- División
                0- Salir
                """;

        ServerSocket serverSocket = new ServerSocket(puerto);
        // Aceptar conexión del cliente
        Socket socket = serverSocket.accept();
        // Flujo de entrada y salida
        DataInputStream recivir = new DataInputStream(socket.getInputStream());
        DataOutputStream enviar = new DataOutputStream(socket.getOutputStream());

        try {
            System.out.println("Cliente conectado...");

            // Enviar mensaje al cliente para que elija operación
            do {
                try {
                    enviar.writeUTF(informacion);

                    // Leer la operación elegida por el cliente
                    String mensajeCliente = recivir.readUTF();
                    System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

                    if (mensajeCliente.equals("0")) {
                        break;  // Salir si el cliente envía "0"
                    }

                    int mensaje1 = Integer.parseInt(mensajeCliente);  // Leer operación

                    // Solicitar primer valor
                    enviar.writeUTF("Introduce el primer valor: ");
                    String mensajeCliente2 = recivir.readUTF();
                    int mensaje2 = Integer.parseInt(mensajeCliente2);  // Primer número

                    // Solicitar segundo valor
                    enviar.writeUTF("Introduce el segundo valor: ");
                    String mensajeCliente3 = recivir.readUTF();
                    int mensaje3 = Integer.parseInt(mensajeCliente3);  // Segundo número

                    System.out.println("Números recibidos: " + mensaje1 + ", " + mensaje2 + ", " + mensaje3);

                    // Calcular el resultado
                    String resultado = String.valueOf(Calcular(mensaje1, mensaje2, mensaje3));
                    enviar.writeUTF("El resultado es: " + resultado);  // Enviar el resultado al cliente
                    System.out.println("resultado enviado");

                    // Preguntar si el cliente quiere repetir
                    enviar.writeUTF("Si quieres hacer otra operación inserta cualquier valor numérico que no sea 0, si quieres salir inserta 0.");
                    String mensajeCliente4 = recivir.readUTF();

                    if (mensajeCliente4.equals("0")) {
                        break;  // Salir si el cliente envía "0"
                    }
                    System.out.println("comprbacion realizado");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Uno de los mensajes no es un número válido.");
                    enviar.writeUTF("Error: Uno de los mensajes no es un número válido.");
                }

            } while (true);

            // Cerrar socket del cliente
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int Calcular(int mensaje1, int mensaje2, int mensaje3) {
        int resultado = 0;
        switch (mensaje1) {
            case 1:
                resultado = mensaje2 + mensaje3;
                break;
            case 2:
                resultado = mensaje2 - mensaje3;
                break;
            case 3:
                resultado = mensaje2 * mensaje3;
                break;
            case 4:
                resultado = mensaje2 / mensaje3;
                break;
            default:
        }
        return resultado;
    }
}
