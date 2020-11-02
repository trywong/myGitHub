package com.wc.algorithm;

/**
 * 二叉树
 * @author wangchuan
 */
public class BinarySearchTree<Key extends Comparable<Key>, Val> {
    private Node root;

    private class Node {
        private Key key;
        private Val val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Val val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.N;
    }

    public Val get(Key key) {
        return get(root, key);
    }

    private Val get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Val val) {
        root = put(root, key, val);
    }

    /**
     * 1.等于当前节点，替换值
     * 2.小于当前节点，在左子树中查找
     * 3.大于当前节点，在右子树中查找
     * 4.直到找到一个空链接，创建一个新节点
     * BinarySearchTree.put()
     * @author wangchuan
     * @Date 2018年2月28日
     * @param x 操作开始的根节点
     * @param key
     * @param val
     * @return
     */
    private Node put(Node x, Key key, Val val) {
        if (x == null) {
            return new Node(key, val, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 1.删除的节点没有子树
     * 2.删除的节点只有左子树
     * 3.删除的节点只有右子树
     * 4.删除的节点有左子树和右子树：用后继结点替换待删除节点
     * BinarySearchTree.delete()
     * @author wangchuan
     * @Date 2018年2月28日
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }

            if (x.right == null) {
                return x.left;
            }

            /*
             * 有左子树和右子树
             */
            Node t = x;
            // 后继结点
            x = min(t.right);
            // 删除后继结点，并将后继结点的右链接指向重置父链接后的链接[应该是指向待删除节点t的右子节点]
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        String[] array = new String[] { "S", "E", "A", "R", "C", "H", "S", "O", "M", "E", "T", "H", "I", "N", "G" };
        int i = 0;
        for (String ele : array) {
            st.put(ele, i);
            i++;
        }

        // st.delete("O");
        System.out.println(st.get("O"));
    }
}
