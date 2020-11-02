package com.wc.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author shovel
 * @date 2018/12/24 14:43
 * @since 1.0.0
 */
public class SocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerDemo server = new ServerDemo("127.0.0.1", 8888);
        server.start();

        Socket client = new Socket("127.0.0.1", 8888);
        OutputStream out = client.getOutputStream();
        Thread.sleep(3000);
        out.write("hello, server".getBytes());
        out.close();
        client.close();
    }
}
