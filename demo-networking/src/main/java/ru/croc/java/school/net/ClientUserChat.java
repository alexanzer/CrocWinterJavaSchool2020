package ru.croc.java.school.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ClientUserChat {
    private Thread thread;
    private Socket socket;
    private BufferedReader reader;
    private Writer writer;

    public ClientUserChat(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        thread = new Thread(() -> {
            while (socket.isConnected()) {
                try {
                    System.out.println(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void send(String message) throws IOException {
        writer.write(message + "\n");
        writer.flush();
    }
}
