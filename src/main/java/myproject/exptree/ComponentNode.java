package myproject.exptree;

public abstract class ComponentNode {

	ComponentNode left;

	ComponentNode right;

	int item;

	abstract void accept(ETVisitor visitor);

}
