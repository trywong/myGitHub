package com.wc.algorithm;


/**
 * 红黑树，平衡二叉树的一种实现方式
 * @author wangchuan
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * 获取元素
     * RedBlackTree.get()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 添加元素
     * RedBlackTree.put()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param key
     * @param val
     * @return
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    /**
     * 删除元素
     * RedBlackTree.delete()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param key
     * @return
     */
    public void delete(Key key) {
        // 1.待删除结点不是2-结点，完成
        // 2.待删除结点和亲兄弟（离得最近的）结点都是2-结点，将父结点中最小键与这两个键组成一个4-结点
        // 3.待删除结点是2-结点，亲兄弟结点不是2-结点，从兄弟结点中的一个键移到待删除结点
    }

    /**
     * 删除最小键
     * 因为红黑树是黑色完美平衡的，删除红链接不影响该性质，所以目的是确保待删除结点是红链接
     * RedBlackTree.deleteMin()
     * @author wangchuan
     * @Date 2018年3月6日
     * @param x
     * @return
     */
    public Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }
        // 1.待删除结点是红链接，完成
        if (isRed(x)) {

        }
        // 2.待删除结点和亲兄弟（离得最近的）结点都是2-结点，将父结点中最小键与这两个键组成一个4-结点
        // 2.待删除结点和亲兄弟（离得最近的）结点都是黑链接，
        // 3.待删除结点是2-结点，亲兄弟结点不是2-结点，从兄弟结点中的一个键移到待删除结点
        return null;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        }

        return x.value;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            System.out.println("新建结点：" + key);
            // 所有新建结点，都用红链接与父链接相连
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(x.key);
        // 找到相同key，覆盖value
        if (cmp == 0) {
            x.value = value;
            return x;
        }

        if (cmp < 0) {
            x.left = put(x.left, key, value);
            System.out.println(x.key);
            System.out.println("/");
            System.out.println(x.left.key);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
            System.out.println(x.key);
            System.out.println("\\");
            System.out.println(x.right.key);
        }

        /*
         * 局部调整：旋转+颜色转换
         */
        // 只有右子结点为红链接
        if (!isRed(x.left) && isRed(x.right)) {
            x = rotateLeft(x);
        }
        // 连续两条红链接
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        // 左右子结点都为红链接
        if (isRed(x.left) && isRed(x.right)) {
            // 颜色转换
            flipColors(x);
        }
        
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 左旋转
     * RedBlackTree.rotateLeft()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param x
     * @return
     */
    private Node rotateLeft(Node x) {
        System.out.println("左旋转：" + x.key);
        Node t = x;
        x = t.right;
        t.right = x.left;
        x.left = t;
        x.color = t.color;
        t.color = RED;
        return x;
    }

    /**
     * 右旋转
     * RedBlackTree.rotateLeft()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param x
     * @return
     */
    private Node rotateRight(Node x) {
        System.out.println("右旋转：" + x.key);
        Node t = x;
        x = t.left;
        t.left = x.right;
        x.right = t;
        x.color = t.color;
        t.color = RED;
        return x;
    }

    /**
     * 颜色转换
     * RedBlackTree.flipColors()
     * @author wangchuan
     * @Date 2018年3月1日
     * @param x
     */
    private void flipColors(Node x) {
        if (x == null) {
            return;
        }

        x.left.color = BLACK;
        x.right.color = BLACK;
        System.out.println("对" + x.key + "的子结点（" + x.left.key + ", " + x.right.key + "）颜色转换");
        x.color = RED;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;

        private boolean color;

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        String[] array = new String[] { "E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N" };
        RedBlackTree<String, Integer> rbTree = new RedBlackTree<String, Integer>();
        for (String ele : array) {
            rbTree.put(ele, 0);
        }
    }
}
