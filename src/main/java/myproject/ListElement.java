package myproject;

public class ListElement<T> {
	
	private T data = null;
	private ListElement<T> next = null;
	
	public ListElement(T data, ListElement<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public ListElement(T data) {
		this(data, null);
	}

}
