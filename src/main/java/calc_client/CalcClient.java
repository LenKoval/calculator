package calc_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8088);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            String ans1 = in.readUTF();
            System.out.println(ans1);
            while (true) {
                String ans2 = in.readUTF();
                System.out.println(ans2);
                String mes = scanner.nextLine();
                if (mes.equals("ВЫХОД")) break;
                out.writeUTF(mes);
                String ans3 = in.readUTF();
                System.out.println("Ответ: " + ans3);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
