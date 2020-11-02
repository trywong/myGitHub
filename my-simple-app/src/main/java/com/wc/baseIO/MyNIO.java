package com.wc.baseIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import sun.nio.ch.sctp.SctpChannelImpl;

public class MyNIO {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("E:/iotest/hahaha.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(64);
        while (channel.read(buffer) != -1) {
            /*
             *  通过flip()方法将Buffer从写模式切换到读模式，在读模式下，可以读取之前写入到buffer的所有数据。
             *  写模式下，position指针指向缓存区数据的顶端
             *  切换到读模式后，limit指针指向缓存区数据的顶端（写模式下的position位置），表示最多能读取缓存区所有数据，position指针跳到缓存区数据的开始位置
             */
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入
        }
        file.close();
    }

    public static void mySelector() throws IOException {
        SelectableChannel channel = new SctpChannelImpl(null);
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            int selectCount = selector.select();
            if (selectCount < 1) {
                continue;
            }
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    SelectableChannel readyChannel = key.channel();
                    keyIterator.remove();
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }
}
