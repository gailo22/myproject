package myproject.java8.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

// Monad design pattern
public class Validator<T> {
	
	private final T t;
	private final IllegalStateException error;
	private final List<Throwable> throwables = new ArrayList<>();

	private Validator(T t, IllegalStateException error) {
		this.t = t;
		this.error = error;
	}
	
	public static <T> Validator<T> of(T t) {
		return new Validator<>(Objects.requireNonNull(t), null);
	}
	
	public Validator<T> validate(Predicate<T> validation, String message) {
		if (!validation.test(t)) {
			throwables.add(new IllegalStateException(message));
		}
		return this;
	}
	
	public <U> Validator<T> validate(Function<T, U> projection, 
			                         Predicate<U> validation, 
			                         String message) {
		//return validate(t -> validation.test(projection.apply(t)), message);
		return validate(projection.andThen(validation::test)::apply, message);
	}
	
	public T get2() throws IllegalStateException {
		if (error == null) { return t; }
		throw error;
	}
	
	public T get() throws IllegalStateException {
		if (throwables.isEmpty()) { return t; }
		IllegalStateException e = new IllegalStateException();
		throwables.forEach(e::addSuppressed);
		throw e;
	}
	
	static class User {
		private String name;
		private int age;
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
		public int getAge() { return age; }
		public void setAge(int age) { this.age = age; }
	}
	
	private static Predicate<Integer> inBetween(int start, int end) {
		return value -> value > start && value < end;
	}
	
	public static void main(String[] args) {
		User user = new User();
		User validatedUser = Validator.of(user)
				.validate(u -> u.getName() != null, "name is null")
				.validate(u -> !u.getName().isEmpty(), "name is empty")
				.validate(u -> u.getAge() > 0 && u.getAge() < 50, "age is out of range")
				.get();
		
		User validatedUser2 = Validator.of(user)
				.validate(User::getName, Objects::nonNull, "name is null")
				.validate(User::getName, name -> !name.isEmpty(), "name is empty")
				.validate(User::getAge, inBetween(0, 50), "age is out of range")
				.get();
	}
}
