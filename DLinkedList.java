/*
 * The DLinkedList<E> class implements List<E>
 */
public class DLinkedList<E> implements List<E>
{
    private Node first;     // Head of the list
    private Node last;      // Last obj on the list
    private int size;    // Size of the list
    
    // Constructor
    public DLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }
    // Check if list is empty
    public boolean isEmpty()
    {
        return first == null;
    }
    
    // Returns the length of the list
    public int size()
    {
        return size;
    }
    // Remove all elements from the list.
    public void clear()
    {
        first = new Node<E>(null, null, null);
        last = new Node<E>(null, null, first);
        first.next = last;
        size = 0;
    }
    // Gets object at given index
    public E get(int index) 
    {
        if(index < 0 || index >= size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        // Locate the node targeted for removal
        Node target = first;
        for(int i = 1; i <= index; i++)
            target = target.next;
        
        E obj = (E) target.obj; // Object to get
        
        return (E)obj;
    }
    public E get(E obj)
    {
        // Locate the node targeted for get
        Node target = first;
        
        while(target != null && !obj.equals(target.obj))
            target = target.next;
        
        return (E) target.obj;
    }
    // Adds obj to the end of the list
    public void add(E e)
    {
        if(isEmpty())
        {
            first = new Node(e);
            last = first;
            size++;
        }
        else
        {
            // Add to end of existing list
            last.next = new Node(e, null, last);
            last = last.next;
            size++;
        }
    }
    // Adds an obj at an index
    public void add(int index, E e)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        // Index is atleast 0
        if(index == 0)
        {
            // New obj goes at beginning
            Node p = first;     // Old first
            first = new Node(e, p, null);
            if(p != null)
                p.prev = first;
            if(last == null)
                last = first;
            size++;
            return;
        }
        // pred will point to the predecessor
        // of the new node.
        Node pred = first;
        for(int k = 1; k <= index - 1; k++)
            pred = pred.next;
        
        // Splice in a node with the new obj
        // we want to go from pred--succ to
        // pred--middle--succ
        Node succ = pred.next;
        Node middle = new Node(e, succ, pred);
        pred.next = middle;
        if(succ == null)
            last = middle;
        else
            succ.prev = middle;
        size++;
    }
    // Removes the obj at a given position
    public E remove(int index)
    {
        if(index < 0 || index >= size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        // Locate the node targeted for removal
        Node target = first;
        for(int k = 1; k <= index; k++)
            target = target.next;
        
        E obj = (E)target.obj;          // Object to return
        Node pred = target.prev;        // Node before the target
        Node succ = target.next;        // Node after the target
        
        // Route forward and back pointers around
        // the node to be removed
        if(pred == null)
            first = succ;
        else
            pred.next = succ;
        
        if(succ == null)
            last = pred;
        else
            succ.prev = pred;
        
        size--;
        return (E)obj;
    }
    // Removes an obj from the list
    public boolean remove(E e)
    {
        if(isEmpty())
            return false;
        
        // Locate the node targeted for removal
        Node target = first;
        while(target != null
                && !e.equals(target.obj))
            target = target.next;
        
        if(target == null)
            return false;
        
        Node pred = target.prev;    // Node before the target
        Node succ = target.next;    // Node after the target
        
        // Route forward and back pointers around
        // the node to be removed
        if(pred == null)
            first = succ;
        else
            pred.next = succ;
        
        if(succ == null)
            last = pred;
        else
            succ.prev = pred;
        size--;
        return true;
    }
    /*
     * The Node class stores a list obj
     * and a reference to the next node.
     */
    private class Node<E>
    {
        private E obj;       // Object of a list obj
        private Node next;   // Next node in the list
        private Node prev;   // Previous obj in the list
        
        // Constructor
        private Node(E value, Node next, Node prev)
        {
            this.obj = value;
            this.next = next;
            this.prev = prev;
        }
        // Constructor
        private Node(E val)
        {
            // Just call the other (sister) constructor
            this(val, null, null);
        }
    }
}