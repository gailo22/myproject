package myproject.sorting;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class AttributeSorting {

	public static void main(String[] args) {
		
		Person person = new Person("John");
		List<Friend> friends = Lists.newArrayList(
				new Friend("Emy", TypeEnum.CLOSED),
				new Friend("James", TypeEnum.COMMON),
				new Friend("Eva", TypeEnum.CLOSED),
				new Friend("Jonas", TypeEnum.CLOSED),
				new Friend("Mark", TypeEnum.COMMON)
				);
		
		person.setFriend(friends);
		
		List<Friend> sortedFriend = person.getFriends()
				                          .stream()
				                          .sorted((e1, e2) -> {
				                        	  return Integer.compare(e1.type.ordinal(), e2.type.ordinal());
				                          })
				                          .collect(Collectors.toList());
		
		System.out.println(person);
		
		person.setFriend(sortedFriend);
		
		System.out.println("personSorted: " + person);

	}
	
	static class Person {
		String name;
		List<Friend> friends;
		Person(String name) {
			this.name = name;
		}
		public List<Friend> getFriends() {
			return friends;
		}
		public void setFriend(List<Friend> friends) {
			this.friends = friends;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", friends=" + friends + "]";
		}
	}
	
	static class Friend {
		String name;
		TypeEnum type;
		Friend(String name, TypeEnum type) {
			this.name = name;
			this.type = type;
		}
		@Override
		public String toString() {
			return "(" + name + ": " + type + ")";
		}
	}
	
	static enum TypeEnum {
		CLOSED, COMMON;
	}

}
