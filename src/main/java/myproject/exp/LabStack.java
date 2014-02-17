package myproject.exp;


import java.util.EmptyStackException;

/**
 * A simple stack implementation.
 *
 * @author pajensen
 */
public class LabStack<E>
{
    // Instance variable(s).
    
    Node head;
    
    /**
     * Empty constructor -- Initializes the stack to be empty.
     */
    public LabStack ()
    {
        this.head = null;
    }
    
    /**
     * Adds an data element to the top of the stack.
     * 
     * @param element the data element to be added to the stack
     */
    public void push (E element)
    {
        head = new Node(element, head);
    }
    
    /**
     * Removes and returns the top data element from the stack.  If the stack
     * is empty, an exception is thrown.
     * 
     * @return element the data element that was on the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E pop ()
    {
        if (head == null)
            throw new EmptyStackException ();
        
        E result = head.data;
        head = head.next;
        return result;
    }
      
    /**
     * Returns the size of the stack.  The size is defined as the number of
     * data elements stored in the stack.
     * 
     * @return the size of the stack
     */
    public int size ()
    {
        int size = 0;
        Node current = head;
        while (current != null)
        {
            size++;
            current = current.next;     
        }
        return size;
    }

    /**
     * Returns a String representation of the contents of the stack.  
     * The final string looks like this:
     * 
     * "[top element, element, element, element, bottom element]"
     * 
     * @return a String representing the elements on the stack
     */
    public String toString ()
    {
        String result = "";
        String separator = "";
        Node current = head;
        while (current != null)
        {
            result = result + separator + current.data;
            separator = ", ";
            current = current.next;
        }
        
        return "[" + result + "]";
    }

    /**
     * The linked list is created using Node objects.  This class
     * declares the node objects, but there are no accessors or
     * mutators.  It is expected that the enclosing class will
     * directly access and mutate the instance variables within a
     * node.
     * 
     * @author pajensen
     */
    private class Node
    {
        // Node instance variables.
        
        E data;
        Node next;
                
        /**
         * Builds a node with the specified data and next node.
         */
        Node (E data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }    
}
