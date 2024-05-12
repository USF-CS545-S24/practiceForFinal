package solution;

public class BooleanExpressionTree {
    private Node root;  //root of the tree

    // Inner class Node that represents one node of the boolean expression tree
    private class Node {
        String element; // for leaves, it will be "true" or "false"; for internal nodes, "AND" or "OR".
        Node leftChild;
        Node rightChild;

        Node(String elem) {
            element  = elem;
            leftChild = null;
            rightChild = null;
        }
    }

    /** Computes the value of the boolean expression tree with the given root
     *
     * @param root root of the tree
     * @return boolean value represented by this expression tree
     */
    public boolean evaluate(Node root) {
        if (root == null)
            return false;
        if (root.leftChild == null && root.rightChild == null) {
            if (root.element.equals("true"))
                return true;
            else
                return false;
        }

        if (root.element.equals("AND"))
            return evaluate(root.leftChild) && evaluate(root.rightChild);
        else
            return evaluate(root.leftChild) || evaluate(root.rightChild);
    }

    /** Creates a simple tree */
    public void createExampleTree() {
        Node op1 = new Node ("AND");
        Node op2 = new Node ("OR");
        Node op3 = new Node("AND");
        Node op4 = new Node("OR");

        op1.leftChild = new Node("true");
        op1.rightChild = op2;
        op2.leftChild = op3;
        op2.rightChild = new Node("true");
        op3.leftChild = new Node("false");
        op3.rightChild = op4;
        op4.leftChild = new Node("false");
        op4.rightChild = new Node("true");
        this.root = op1;
    }

    public static void main(String[] args) {
        BooleanExpressionTree tree = new BooleanExpressionTree();
        tree.createExampleTree();

        System.out.println(tree.evaluate(tree.root));
    }

}

