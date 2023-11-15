public class DecisionTree extends BinaryTree<String> {
    /** leaf constructor */
    public DecisionTree(String data) {
        super(data);
    }

    /** branch constructor */
    public DecisionTree(String data, DecisionTree left, DecisionTree right) {
        super(data, left, right);
    }

    /** accessor (left) */
    public DecisionTree getLeft() {
        return (DecisionTree) super.getLeft();
    }

    /** accessor (right) */
    public DecisionTree getRight() {
        return (DecisionTree) super.getRight();
    }

    /** manipulator (left) */
    public void setLeft(BinaryTree<String> left) {
        if (left instanceof DecisionTree) {
        //this.left = left;
            super.setLeft(left);
        }
        else {
            throw new UnsupportedOperationException("Tried to add non-DecisionTree as child");
        }
    }

    /** manipulator (right) */
    public void setRight(BinaryTree<String> right) {
        if (right instanceof DecisionTree) {
        //this.right = right;
            super.setLeft(right);
        }
        else {
            throw new UnsupportedOperationException("Tried to add non-DecisionTree as child");
        }
    }

    // end condition
    public DecisionTree followPath(String input) {
        if (isLeaf() || input.isEmpty()) {
            return this;
        }
        // before you reach end con
        if (input.substring(0, 1).equals("Y")) {
            return getLeft().followPath(input.substring(1));
        }
        if (input.substring(0, 1).equals("N")) {
            return getRight().followPath(input.substring(1));
        }
        else {
            throw new IllegalArgumentException("Only Y and N inputs accepted.");
        }
    }
}
