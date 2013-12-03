public class Find_LCA_of_BinaryTree {
	// top-down solution
	Node find_LCA_td(Node node, Node a, Node b){
		//base cases
		if (node == null) {
			return null;
		} else if (node.item == a.item || node.item == b.item) {
			return node;
		} 
		
		boolean a_in_left = if_in_tree(node.left, a);
		boolean b_in_left = if_in_tree(node.left, b);

		if (a_in_left != b_in_left) {
			return node;
		} else {
			Node child = (a_in_left)?node.left:node.right;
			return find_LCA_td(child, a, b);    // recursive call
		}
	}
	
	// helper function to check if node is in the tree rooted by root
	private boolean if_in_tree(Node root, Node n) {
		if (root == null) {
			return false;
		} else if (root.item == n.item) {
			return true;
		} else {
			return if_in_tree(root.left, n) || if_in_tree(root.right, n); 
		}
	}
	
	// bottom-up solution
	Result find_LCA_bu_2(Node node, Node a, Node b) {
		if (node == null) {
			return new Result(null, false);
		}
		if (node.item == a.item && node.item == b.item) {
			return new Result(node, true);
		}
		
		Result left_result = find_LCA_bu_2(node.left, a, b);
		if (left_result.isResult) {return left_result;}
		Result right_result = find_LCA_bu_2(node.right, a, b);
		if (right_result.isResult) {return right_result;}
		
		if (left_result.node != null && right_result.node != null) {
			return new Result(node, true);
		} else if (node.item == a.item || node.item == b.item) {
			if (left_result.node != null || right_result.node != null) {
				return new Result(node, true);  // one of a and b is another's ancestor
			} else {
				return new Result(node, false); // find one of a and b, but not another one yet
			}
		} else {
			return new Result(left_result.node!=null?left_result.node:right_result.node, false);
		}
 	}
 	
 	//------------- Inner class ------------------
	private static class Result{
		Node node;
		boolean isResult;
		
		Result(Node node, boolean isResult){
			this.node =  node;
			this.isResult = isResult;
		}
	}
}