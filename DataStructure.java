
public class DataStructure <E> implements List<E> {    
    //head node 
    private Node head;
    
    //size of the linkedlist, also used for indexes (start from zero)
    private int size;
    
    //default constructor
    public DataStructure() {
        //head = blank node
        head = new Node();
        size = 0;
    }
    
    //add to the data structure, encapsulate in a node
    public void add(E obj) {
        //increment the size by one
        int index = size;
        
        //increment the size of the datastructure
        size++;
        
        //create a new node, add to head
        Node temp = new Node(obj, index);
        
        //add to the top of the list
        temp.setNext(head.getNext());
        
        //make the head node point to the next node
        head.setNext(temp);
    }
    
    //remove from datastructure
    public E remove(int index) {
        //remove obj E and dereference Node
        E obj = null;
        
        //start from the top of the list
        Node current = head;
        
        //while not at the end of the list
        while(current.getNext() != null) {
            //keep searching
            if(current.getNext().getIndex() == index) {
                //the index matches, remove the object
                obj = (E) current.getNext().getObj();
                
                //remove the next node from the list
                current.setNext(current.getNext().getNext());
                
                //decrement size
                size--;
                
                //obj removed and node dereferenced
                return obj;                
            } else {
                //keep searching
                current = current.getNext();
            }
        }
        
        //the index has not been found
        return obj; //*** null pointer, handle for safety on calling code
    }
    
    public E get(int index) {
        E obj;
        Node current = head;
        
        while(current.getNext() != null)
        {
            if(current.getNext().getIndex() == index)
            {
                obj = (E) current.getNext().getObj();
                return obj;
            }
            else
            {
                current = current.getNext();
            }
        }
        // index not found
        return null;
    }
    
    
    //synchronize object E index reference with this method BEFORE adding
    public int getCurrentIndex() {
        return size;
    }
    
    //returns the size of the data structure
    public int size() {
        return size;
    }
    
    //Node modules
    private class Node <E> {
        //object and index in the data structure
        E obj;
        int index;
        
        //reference to the next Node, null if last
        Node next;
        
        //create a Node with no data/index (used for head nodes)
        Node() {}
        
        //private methods to abstract to DataStructure only
        private Node(E obj, int index) {
            this.obj = obj;
            this.index = index;
        }
        
        //set the next node in the list
        private void setNext(Node next) {
            this.next = next;
        }
        
        //return a reference to the next node
        private Node getNext() {
            return next;
        } 
        
        //return the current node index
        private int getIndex() {
            return index;
        }
        
        //return the current node's data
        private E getObj() {
            return obj;
        }
    }
}
