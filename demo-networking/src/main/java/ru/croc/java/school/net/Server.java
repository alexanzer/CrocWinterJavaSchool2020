package ru.croc.java.school.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        final List<ChatUser> users = new ArrayList<>();
        while (true) {
            final BiConsumer<String, String> sendAll = (name, message) -> {
                users.stream()
                        .filter(u -> !u.getName().equals(name))
                        .forEach(client -> client.send(name + ">> " + message));
            };
            final ChatUser user = new ChatUser(serverSocket.accept(), sendAll);
            users.add(user);
            user.send("Hello " + user.getName());
        }
    }
}
