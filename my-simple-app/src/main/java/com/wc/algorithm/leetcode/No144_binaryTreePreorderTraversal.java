package com.wc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class No144_binaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        // 左子树
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public static void main(String[] args) {
        No144_binaryTreePreorderTraversal no144 = new No144_binaryTreePreorderTraversal();
        TreeNode treeNode = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        treeNode.right = right;
        right.left = new TreeNode(3);
        List<Integer> list = no144.preorderTraversal(treeNode);
        System.out.println(list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

