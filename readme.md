Enunciado: Aplicación de Calculadora con Comunicación por Sockets

Debes implementar una aplicación de calculadora distribuida utilizando sockets en Java. La aplicación debe constar de dos partes: un servidor que realizará las
operaciones matemáticas y un cliente que enviará las operaciones al servidor y mostrará los resultados en la consola.

Requerimientos:
1. Servidor:
   ○ El servidor debe escuchar las conexiones en el puerto 12345.
   ○ Cuando un cliente se conecte, el servidor debe aceptar la conexión y crear un hilo dedicado para manejar las solicitudes de ese cliente.
   ○ El servidor debe ser capaz de manejar operaciones de suma, resta, multiplicación y división.
   ○ Después de realizar una operación, el servidor debe enviar el resultado al cliente.


2. Cliente:
   ○ El cliente debe poder conectar al servidor que está en localhost en el puerto 12345.
   ○ El cliente debe permitir al usuario elegir el tipo de operación (suma, resta, multiplicación, división) y proporcionar dos valores para realizar la operación.
   ○ Después de enviar la operación al servidor, el cliente debe recibir y mostrar el resultado en la consola.
   ○ El cliente debe poder realizar múltiples operaciones antes de decidir cerrar la conexión. Para salir, el cliente puede ingresar 0.
   Para el envio del mensaje del cliente al servidor con la operación a realizar, puedes utilizar un String con el formato “op#n1#n2” donde op será el valor de la operación a
   realizar (1 a 4), n1 el primer operador y n2 el segundo. El servidor recibirá este mensaje y con el método split puede obtener un array con los tres campos.
  
 
3.Restricciones:
   ● La comunicación entre el cliente y el servidor debe realizarse mediante sockets TCP/IP.
   ● El código debe estar correctamente comentado para explicar el funcionamiento de las diferentes partes del programa.
   ● La aplicación debe ser capaz de manejar errores de manera adecuada, por ejemplo, si el cliente intenta enviar datos no válidos o si hay un problema de
   conexión entre el cliente y el servidor.


   Ejemplo de ejecución:
   En la consola del cliente:
   Conexion establecida con el servidor.
   Introduce tipo de operación: 1- Suma, 2- Resta, 3-Multiplicación, 4 -División: 3
   Introduce primer valor: 2
   Introduce segundo valor: 4
   El resultado es: 8
   Si quieres hacer otra operación inserta cualquier valor numérico que no sea 0, si quieres salir
   inserta 0.
   5
   Introduce tipo de operación: 1- Suma, 2- Resta, 3-Multiplicación, 4 -División: 1
   Introduce primer valor: 5
   Introduce segundo valor: 6
   El resultado es: 11
   Si quieres hacer otra operación inserta cualquier valor numérico que no sea 0, si quieres salir
   inserta 0.
   0
   Process finished with exit code 0
   En la consola del servidor:
   Servidor esperando conexiones...
   Nuevo cliente conectado.