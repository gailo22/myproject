package myproject;

public interface MyList<E> {

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size();

	/**
	 * Appends the specified element to the end of the list.
	 * 
	 * @param element
	 *            the element to append to this list.
	 * @return true (added the specified element to the list) (as per
	 *         Collection.add contract)
	 */
	public boolean add(E element);

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element at the specified position (if any) and any subsequent
	 * elements towards the end of the list.
	 * 
	 * @param index
	 *            index at which to insert the specified element.
	 * @param element
	 *            element to insert.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index > size()).
	 */
	public void add(int index, E element);

	/**
	 * Removes the element at the specified position in this list. Shifts
	 * elements subsequent to the removed element (if any) towards the beginning
	 * of the array.
	 * 
	 * @param index
	 *            the index of the element to remove.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size()).
	 */
	public E remove(int index);

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the element to replace.
	 * @return element at the specified position in this list.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size()).
	 */
	public E get(int index);

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 *            index of element to replace.
	 * @param value
	 *            element value to store at the specified position.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size()).
	 */
	public E set(int index, E value);

}
