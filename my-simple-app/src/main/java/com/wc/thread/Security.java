package com.wc.thread;

/**
 * 线程安全测试
 * @author shovel
 * @date 2018/12/24 10:20
 * @since 1.0.0
 */
public class Security {
    // 因为是static，属于类Security，而不是对象
    private static String uname;
    private static String pword;

    public void doLogin(String username, String password) throws InterruptedException {
        if ("a".equals(username)) {
            uname = username;
            Thread.sleep(1000);
        }

        pword = password;

        System.out.println("username:" + uname + ", password:" + pword);
    }

    public static void main(String[] args) throws InterruptedException {
        TheadA threadA = new TheadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        /**
         * 输出
         * username:a, password:bb
         * username:a, password:aa
         */
    }
}

class TheadA extends Thread {
    @Override
    public void run() {
        try {
            Security security = new Security();
            security.doLogin("a", "aa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            Security security = new Security();
            security.doLogin("b", "bb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
