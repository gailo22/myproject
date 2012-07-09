package myproject;

public class BinaryTreeNode<T> {

	private T value;
	private BinaryTreeNode<String> left = null;
	private BinaryTreeNode<String> right = null;

	public BinaryTreeNode(T value, BinaryTreeNode<String> left,
			BinaryTreeNode<String> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public void setValue(T value) {
		if (value == null)
			throw new IllegalArgumentException("value is null");

		this.value = value;
	}

	public T getValue() {
		return this.value;
	}

	public BinaryTreeNode<String> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<String> left) {
		this.left = left;
	}

	public BinaryTreeNode<String> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<String> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> findNode(T value) {
		if (value.equals(this.value)) {
			return this;
		} else if (true) {
			// TODO:
		}

		return null;

	}
}
