package ru.croc.java.school.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Socket socket = new Socket("localhost", 8080);
        ClientUserChat chat = new ClientUserChat(socket);
        chat.send(name);
        while (true) {
            chat.send(LocalTime.now().toString());
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        }
    }
}
