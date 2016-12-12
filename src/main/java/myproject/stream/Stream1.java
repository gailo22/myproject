package myproject.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Stream1 {

	public static void main(String[] args) {
		
		Stream.of("apple", "banana", "mango").forEach(x -> {
			System.out.println(x + "_x");
		});
		
		IntStream.of(1,2,3,4,5)
		         .forEach(System.out::println);
		
		IntStream.iterate(0, i -> i + 2)
		         .limit(100)
		         .forEach(System.out::println);
		
		IntStream.rangeClosed(1, 10)
		         .forEach(System.out::println);
		
		System.out.println("-------------");
		IntStream.rangeClosed(1, 4)
                 .flatMap(i -> IntStream.iterate(i, j -> i + j).limit(i))
		         .forEach(System.out::println);
		
		List<Person> people = Lists.newArrayList(new Person("John", 30), 
                new Person("Jane", 20),
                new Person("Jones", 20));

		Map<Integer, List<Person>> groupByAge = people.stream()
		                  .collect(
		                       Collectors.groupingBy(Person::getAge, 
		               		    Collectors.mapping(Function.identity(), 
		               				               Collectors.toList())));
		System.out.println(groupByAge);
		
		Person findPerson = people.stream()
		      .filter(p -> p.getAge() == 20)
		      .findFirst()
		      .orElse(null);
		
		System.out.println("found: " + findPerson);
		
		Person notFoundPerson = people.stream()
			      .filter(p -> p.getAge() == 60)
			      .findFirst()
			      .orElse(null);
			
		System.out.println("not found: " + notFoundPerson);
		      
		List<String> listOfStuff = null;
		List<String> listOfStuffFiltered = Optional.ofNullable(listOfStuff)
              .orElseGet(Collections::emptyList)
              .stream()
              .filter(Objects::nonNull)
              .collect(Collectors.toList());
		
		System.out.println(listOfStuffFiltered);
	}
	
	static class Person {
		private String name;
		private int age;
		
		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}

}
