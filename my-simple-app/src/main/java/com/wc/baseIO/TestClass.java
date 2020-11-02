package com.wc.baseIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

/**
 * @author shovel
 * @date 2018/12/23 11:58
 * @since 1.0.0
 */
public class TestClass {
    public static void main(String[] args) throws IOException {
        ServerDemo server = new ServerDemo();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            reader.lines().forEach(s -> {
                System.out.print(s);
            });
        }
    }
}

class ServerDemo extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            // 自动绑定一个空闲端口
            serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
                // 启动单线程，回复客户端
                RequestHandler handler = new RequestHandler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


