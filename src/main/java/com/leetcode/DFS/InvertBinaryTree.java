package com.leetcode.DFS;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-18 下午10:17
 * 类名: InvertBinaryTree
 * </pre>
 * 226. 翻转二叉树
 * 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 **/

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        root.left = left;
        root.right = right;
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode res = invertBinaryTree.invertTree(root);
        System.out.println(res.val+"\n"+res.left.val+" "+res.right.val
        +"\n"+res.left.left.val+" "+res.left.right.val+" "+res.right.left.val+" "+res.right.right.val);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}