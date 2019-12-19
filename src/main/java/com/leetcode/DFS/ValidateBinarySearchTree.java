package com.leetcode.DFS;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-18 下午10:33
 * 类名: ValidateBinarySearchTree
 * </pre>
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:
 输入:
   2
  / \
 1   3
 输出: true
 示例 2:
 输入:
     5
    / \
   1   4
      / \
     3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
      根节点的值为 5 ，但是其右子节点值为 4 。
 **/

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root,long min,long max){
        if(root==null) return true;
        return (root.val < max
        && root.val > min
        && dfs(root.left,min,root.val)
        && dfs(root.right,root.val,max));
    }


    public boolean isValidBST1(TreeNode root) {
        if(root == null)
            return true;
        return isValidBST1(root.left)
                && isValidBST1(root.right)
                && (root.left == null?true:root.left.val<root.val)
                && (root.right == null?true:root.right.val>root.val)
                && (getMax(root.left)==null?true:root.val>getMax(root.left))
                && (getMin(root.right)==null?true:root.val<getMin(root.right));
    }
    public Integer getMax(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        Integer l = getMax(root.left);
        Integer r = getMax(root.right);
        return Math.max(l,r);
    }
    public Integer getMin(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        Integer l = getMin(root.left);
        Integer r = getMin(root.right);
        return Math.min(l,r);
    }
}
