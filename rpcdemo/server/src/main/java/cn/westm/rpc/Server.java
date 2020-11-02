package cn.westm.rpc;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private int port;
    private Map<String, Class<?>> services = new HashMap<>();

    public Server(int port) {
        this.port = port;
    }

    public void regist(Class<?> service, Class<?> serviceImpl) {
        services.put(service.getName(), serviceImpl);
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server start:" + port);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(inputStream);
                String serviceName = (String) ois.readObject();
                String methodName = (String) ois.readObject();
                Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
                Object[] args = (Object[]) ois.readObject();
                Class<?> service = services.get(serviceName);

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                if (service == null) {
                    oos.writeObject(new IllegalStateException("ServiceName not Support!"));
                } else {
                    Object svc = service.newInstance();
                    Method method = service.getMethod(methodName, parameterTypes);
                    Object result = method.invoke(svc, args);
                    oos.writeObject(result);
                }
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
