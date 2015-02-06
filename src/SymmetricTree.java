import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x){
			val = x;
		}
	}
    
	public static void main(String[] args) {
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(2);
		
		t0.left = t1;
		//t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		
		System.out.println(isSymmetric(t0));
	}
	// beautifly recursive solution from leetcode
    public static boolean isSymmetric(TreeNode root) {
    	return check(root, root);
    }
    
    public static boolean check(TreeNode p, TreeNode q){
    	if (p == null && q == null) return true;
    	if(p == null ^ q == null || p.val != q.val) return false;
    	return check(p.right, q.left) && check(p.left, q.right);
    }
}