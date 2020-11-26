package ru.croc.java.school.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ChatUser {
    private Thread thread;
    private String name;
    private Socket socket;
    private BufferedReader reader;
    private Writer writer;

    public ChatUser(Socket socket, BiConsumer<String, String> sendAll) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        name = reader.readLine();
        thread = new Thread(() -> {
            while (socket.isConnected()) {
                try {
                    String message = reader.readLine();
                    System.out.println(name + "> " + message);
                    sendAll.accept(name, message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }



    public String getName() {
        return name;
    }

    public void send(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
