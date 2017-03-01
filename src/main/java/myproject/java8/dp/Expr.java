package myproject.java8.dp;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Expr {
	public static Expr parse(Iterator<String> it) {
		String token = it.next();
		Optional<Operator> operator = Operator.parse(token);
		if (operator.isPresent()) {
			Expr left = parse(it);
			Expr right = parse(it);
			return new BinaryOp(operator.get(), left, right);
		}
		try {
			return new Value(Double.parseDouble(token));
		} catch (NumberFormatException ex) {
			return new Variable(token);
		}
	}
	
	public static Expr parse(Iterator<String> it,
			Function<String, Optional<Expr>> factory) {
		String token = it.next();
		return factory.apply(token).orElseThrow(() -> new IllegalArgumentException());
	}
	
	public static Optional<Expr> parseBinaryOp(String token, Supplier<Expr> supplier) {
		return Operator.parse(token)
				       .map(op -> new BinaryOp(op, supplier.get(), supplier.get()));
	}
	
	public static Optional<Expr> parseValue(String token) {
		try {
			return Optional.of(new Value(Double.parseDouble(token)));
		} catch(NumberFormatException ex) {
			return Optional.empty();
		}
	}
	
	public static Optional<Expr> parseVariable(String token) {
		return Optional.of(new Variable(token));
	}
	
	public static Expr create(Iterator<String> it) {
		return parse(it, token -> {
			return null;
//			require java 9
//			parseBinaryOp(token, () -> create(it))
//			  .or(() -> parseValue(token))
//			  .or(() -> parseVariable(token));
		});
	}
	
	public static void main(String[] args) {
		Expr expr = parse(Arrays.asList("+ 2 * a 3".split(" ")).iterator());
		Expr expr2 = create(Arrays.asList("+ 2 * a 3".split(" ")).iterator());
	}
}

enum Operator {
	ADD("+"), SUB("-"), MUL("*");
	final String symbol;
	private static final Map<String, Operator> map = 
			Arrays.stream(values()).collect(toMap(op -> op.symbol, op -> op));
	public static Optional<Operator> parse(String token) {
		return Optional.ofNullable(map.get(token));
	}
	Operator(String symbol) { this.symbol = symbol; }
}

class BinaryOp implements Expr {
	private final Operator operator;
	private final Expr left, right;
	BinaryOp(Operator operator, Expr left, Expr right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
}

class Variable implements Expr {
	private final String name;
	Variable(String name) { this.name = name; }
}

class Value implements Expr {
	private final double value;
	Value(double value) { this.value = value; }
}
