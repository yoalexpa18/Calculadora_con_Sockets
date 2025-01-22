package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static int puerto = 12345;
    static String servidor = "localhost";

    public static void main(String[] args) throws IOException {
        String tecla = "1";

        // Conecta al servidor
        Socket socket = new Socket(servidor, puerto);
        System.out.println("Conectando");

        // Recibir respuesta
        DataInputStream recibir = new DataInputStream(socket.getInputStream());
        DataOutputStream enviar = new DataOutputStream(socket.getOutputStream());

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner teclado = new Scanner(System.in);
        String replica;


        do {
            // Recibe información inicial
            String respuesta = recibir.readUTF();
            System.out.println(respuesta);

            // Leer la operación que el cliente quiere realizar
            String nunero1 = teclado.nextLine();
            tecla = nunero1;

            // Enviar la operación al servidor
            enviar.writeUTF(nunero1);
            System.out.println("Mensaje enviado");

            if (nunero1.equals("0")) {
                break;
            }
            if (!nunero1.equals("0")) {
                // Recibir mensaje del servidor para primer número
                respuesta = recibir.readUTF();
                System.out.println(respuesta);

                // Enviar el primer número
                String nunero2 = teclado.nextLine();
                enviar.writeUTF(nunero2);
                System.out.println("Mensaje enviado");

                // Recibir mensaje del servidor para el segundo número
                respuesta = recibir.readUTF();
                System.out.println(respuesta);

                // Enviar el segundo número
                String nunero3 = teclado.nextLine();
                enviar.writeUTF(nunero3);
                System.out.println("Mensaje enviado");
            }

            // Recibir el resultado de la operación
            String resultado = recibir.readUTF();
            System.out.println(resultado);

            // Preguntar si el cliente quiere hacer otra operación
            respuesta = recibir.readUTF();
            System.out.println(respuesta);

            // Enviar la respuesta para continuar o salir
            replica = teclado.nextLine();
            enviar.writeUTF(replica);
            System.out.println("replica enviado");

        } while (!replica.equals("0"));

        // Cerrar la conexión con el servidor
        socket.close();
    }
}
