public interface List<E> 
{
    // Add the object to the end of the list
    public void add(E obj);
    
    // Add the object to the list at the position given by index
    public void add(int index, E object);
    
    // Remove and return the object at the position given by index
    public E remove(int index);
    
    // Remove the object and return true if the object was removed
    public boolean remove(E object);
    
    //return the object at given index
    public E get(int index);
    
    // Return the object that matches passed object
    public E get(E obj);
    
    //returns the index of the object to synchronise
    //public int getCurrentIndex();
    
    //returns the size of the structure
    public int size();
    
    // Check if the list is empty
    public boolean isEmpty();
}