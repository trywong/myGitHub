package cn.westm.rpc;

import cn.westm.service.HelloService;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Client {
    String host;
    int port;
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public <T> T newProxyInstance(final Class<T> service) {
        try {
            final Socket socket = new Socket("127.0.0.1", 8181);
            return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{service}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                    oos.writeObject(service.getName() /*HelloService.class.getName()*/);
                    oos.writeObject(method.getName());
                    oos.writeObject(method.getParameterTypes());
                    oos.writeObject(args);
                    oos.flush();
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(inputStream);
                    Object result = ois.readObject();
                    return result;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8181);
        HelloService helloService = client.newProxyInstance(HelloService.class);
        String result = helloService.hello("hello world");
        System.out.println("client:" + result);
    }
}
