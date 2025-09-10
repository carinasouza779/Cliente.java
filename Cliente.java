import java.net.*;
import java.io.*;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            System.out.print("Você: ");
            msg = teclado.readLine();
            out.println(msg);

            String resposta = in.readLine();
            System.out.println("Servidor: " + resposta);

            if (msg.equalsIgnoreCase("sair")) break;
        }

        socket.close();
    }
}
