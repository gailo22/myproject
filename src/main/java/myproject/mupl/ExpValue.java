package myproject.mupl;

public interface ExpValue {

	abstract int val();

	abstract ExpValue add(Exp e);

	abstract ExpValue mult(Exp e);

	abstract ExpValue negate();

}
