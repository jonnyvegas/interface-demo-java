package set;

/**
 * Ch 4 HW 3 Pg 239 #14
 * COMP 182
 * Prof. Putnam
 * 10/13/14
 * This interface uses a mathematic set to hold sets of numbers and perform
 * operations on various sets.
 * @author Jonathan Villegas
 */
public interface Set 
{
    //Creates an empty set.
    public void createSet();
    //Determines whether the set is empty.
    public boolean isEmpty();
    //Returns the size of the set (number of items in the set).
    public int size();
    //Adds an integer to the set.
    public void add(int theItem);
    //Determines if a set contains an item.
    public boolean contains(int theItem);
    //Creates a new set with all elements of the calling set and the
    //set in the parameter. Returns a set with all the elements of both
    //and no duplicates.
    public Set union(Object theSet);
    //Creates a new set consisting of the calling set and the parameter set
    //passed. May have duplicates.
    public Set intersection(Object theSet);
    //Remove all items from the set.
    public void removeAll();
}
