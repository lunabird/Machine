package com.leetcode.DFS;

/**
 * <pre>
 * 任务：
 * 描述：给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
   1
  / \
 2   2
 / \ / \
 3  4 4  3
 链接：https://leetcode-cn.com/problems/symmetric-tree
 思路：如果一棵树为空，则是对称的；
      如果不为空，当且仅当它的左子树和右子树对称它才对称；
      左子树和右子树都为空，对称；
      左子树和右子树都只有一个节点并且值相等，对称；
      左子树的左孩子=右子树的右孩子 && 左子树的右孩子=右子树的左孩子，对称；
 * 作者：@author huangpeng
 * 时间：@create 2019-11-24 下午4:15
 * 类名: SymmetricTree
 * </pre>
 **/

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null) return true;
        if(root.left==null||root.right==null) return false;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
