package com.wc.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shovel
 * @date 2018/12/24 14:19
 * @since 1.0.0
 */
public class ServerDemo extends Thread {
    private String address;
    private int port;

    public ServerDemo(String address, int port) {
        this.address = address;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress(address, port));
            Socket socket = server.accept();

            System.out.println("server accepting...");

            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                // out.write(buffer, 0, len);
                System.out.println(new String(buffer, 0, len));
            }

            System.out.println("server accepted");
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
