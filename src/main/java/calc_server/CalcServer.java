package calc_server;

import calculator.Calculator;
import calculator.MyException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключен");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("DataInputStream создан");
            System.out.println("DataOutStream создан");

            while (true) {
                System.out.println("Чтение из канала");
                String input = in.readUTF();

                if (input.equals("ВЫХОД")) break;

                System.out.println("Полученное уравнение: " + input);
                Calculator calculator = new Calculator();
                calculator.addNumbers(input);
                System.out.println("Проверка введенных чисел...");
                int result = calculator.process();
                System.out.println("Отправление результата");
                out.writeUTF(Integer.toString(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
