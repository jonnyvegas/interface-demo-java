package set;

/**
 * Ch 4 Project #4 Pg 239-240 #14
 * COMP 182
 * Prof. Putnam
 * 10/13/14
 * The class arraySet implements the interface Set. It overrides all operations
 * on the sets and can perform various operations on the sets.
 * @author Jonathan Villegas
 */
public class arraySet implements Set
{
    //Maximum number of items in the set.
    private final int maxNumOfItems = 100;
    //The set of numbers.
    private int[] theSet;
    //Number of items in the set.
    private int numOfItems;
    
    //Constructor.
    public arraySet()
    {
        theSet = new int[maxNumOfItems];
        numOfItems = 0;
    }
    /**
     * Creates a new set of numbers.
     */
    @Override
    public void createSet()
    {
        theSet = new int[maxNumOfItems];
        numOfItems = 0;
    }
    /**
     * Precondition: None
     * Postcondition: returns if a set is empty or not.
     * Determines if a set is empty or not.
     * @return true if the set is empty, false if not.
     */
    @Override
    public boolean isEmpty()
    {
        boolean empty = false;
        //It's empty.
        if(numOfItems == 0)
        {
            empty = true;
            return empty;
        }
        //It's not empty.
        else
        {
            return empty;
        }
    }
    /**
     * Precondition: none.
     * Postcondition: returns the size of the set.
     * Determines the size of the set.
     * @return the size of the set.
     */
    @Override
    public int size()
    {
        return numOfItems;
    }

    /**
     * Precondition: theItem is an int to be added to the set.
     * Postcondition: theItem is added to the set provided it is not 
     * a duplicate.
     * Adds an item to the set if it is not already present in the set.
     * @param theItem: the item to be added to the set.
     */
    @Override
    public void add(int theItem)
    {
        boolean duplicate = false;
        for(int i = 0; i < numOfItems; i++)
        {
            if(theSet[i] == theItem)
            {
                //We have a duplicate item. Do nothing.
                duplicate = true;
            }
        }
        //If it isn't in the set, add it to the set.
        if(!duplicate)
        {
            theSet[numOfItems] = theItem;
            numOfItems++;
        }
    }
    /**
     * Precondition: theItem is the item to be checked.
     * Postcondition: returns true if the item is in the set, false if not.
     * Determines if a set contains an int theItem.
     * @param theItem the item to be checked.
     * @return true if the item is in the set, false if not.
     */
    @Override
    public boolean contains(int theItem)
    {
        //Haven't found it yet.
        boolean found = false;
        //We have no items. Set cannot contain theItem.
        if(numOfItems == 0)
        {
            return found;
        }
        else
        {
            for(int i = 0; i < numOfItems; i++)
            {
                //Found it.
                if(theSet[i] == theItem)
                {
                    found = true;
                }
            }
        }
        return found;
    }
    /**
     * Precondition: theSet is a set that has numbers to combine with the
     * calling set.
     * Postcondition: a set is returned that has the calling set and the
     * parameter, theSet, combined with no duplicates.
     * Returns a set that has both numbers from the calling set and theSet
     * and no duplicates.
     * @param theSet the set with numbers to be added to another set.
     * @return a set that has both numbers from the calling set and theSet
     * and no duplicates.
     */
    @Override
    public Set union(Object theSet)
    {
        arraySet newSet = new arraySet();
        arraySet secondSet = (arraySet) theSet;
        //Go through each element of this and copy into the new set.
        //The add method makes sure there aren't any duplicates.
        for(int i = 0; i < this.size(); i++)
        {
            newSet.add(this.theSet[i]);
        }
        //Go through each element of theSet and copy into the new set.
        //The add method makes sure there aren't any duplicates.
        for(int i = 0; i < secondSet.size(); i++)
        {
            newSet.add(secondSet.theSet[i]);
        }
        return newSet;
    }
    /**
     * Precondition: theSet is a set of ints to be combined with the 
     * calling set.
     * Postcondition: a set is returned that has the elements of the
     * calling set and theSet.
     * Returns a set that is a combination of the calling set and the
     * parameter passed, theSet. Duplicates are allowed.
     * @param theSet a set of ints to be combined with the calling set.
     * @return a set that is the combination of the calling set and
     * theSet. Duplicates are allowed.
     */
    @Override
    public Set intersection(Object theSet)
    {
        //Create the new set.
        arraySet newSet = new arraySet();
        int items1 = this.size();
        //Cast theSet to an arraySet.
        arraySet secondSet = (arraySet) theSet;
        int items2 = secondSet.size();
        //The new set is the size of both combined.
        newSet.numOfItems = this.size() + secondSet.size();
        //Copy all items from this into the new set.
        System.arraycopy(this.theSet, 0, newSet.theSet, 0, items1);
        //Copy all items from theSet into the new set.
        System.arraycopy(secondSet.theSet, 0, newSet.theSet, items1, items2);
        return newSet;
    }
    /**
     * Removes all elements from the set.
     */
    @Override
    public void removeAll()
    {
        this.theSet = new int[100];
        this.numOfItems = 0;
    }
    /**
     * Prints the set.
     */
    public void printSet()
    {
        if(this.size() == 0)
        {
            System.out.println("The set is empty!");
        }
        else
        {
            System.out.print("{");
            for(int i = 0; i < this.size() - 1; i++)
            {
                System.out.print(this.theSet[i] + ", ");
            }
            System.out.print(this.theSet[this.size() - 1] +"}");
            System.out.println();
        }
    }
    /**
     * Turns the set into a String.
     * @return String representation of the set.
     */
    @Override
    public String toString()
    {
        if(this.size() == 0)
        {
            String theMessage = "The array is empty.";
            return theMessage;
        }
        else
        {
            String theMessage = "";
            theMessage = theMessage + "{";
            for(int i = 0; i < this.size() - 1; i++)
            {
                theMessage = theMessage + this.theSet[i];
                theMessage = theMessage + ", ";
            }
            theMessage = theMessage + this.theSet[this.size() - 1];
            theMessage = theMessage + "}"; 
            return theMessage;
        }
    }
    public static void main(String[] args)
    {
        arraySet set1 = new arraySet();
        arraySet set2 = new arraySet();
        System.out.println("First set is empty: " + set1.isEmpty());
        
        System.out.println("Second set is empty: " + set2.isEmpty());
        for(int i = 2; i <= 20; i += 2)
        {
            set1.add(i);
        }
        for(int i = 3; i <= 30; i += 3)
        {
            set2.add(i);
        }
        
        System.out.println("First set is empty: " + set1.isEmpty());
        System.out.println("Second set is empty: " + set2.isEmpty());
        System.out.println("First set contains 100: " + set1.contains(100));
        System.out.println("Second set contains 21: " + set2.contains(21));
        System.out.println("First set: " + set1);
        System.out.println("Second set: " + set2);
        int n = set1.size();
        System.out.println("First set size: " + n);
        n = set2.size();
        System.out.println("Second set size: " + n);
        arraySet set3 = (arraySet) set1.union(set2);
        arraySet set4 = (arraySet) set1.intersection(set2);
        System.out.println("The union (set 3) is: " + set3);
        n = set3.size();
        System.out.println("The union (set 3) size is: " + n);
        System.out.println("The intersection (set 4) is: " + set4);
        n = set4.size();
        System.out.println("The intersection (set 4) size is: " + n);
        arraySet set5 = (arraySet) set3.union(set4);
        System.out.println("The union (set 5) is: " + set5);
        n = set5.size();
        System.out.println("The union (set 5) size is: " + n);
        arraySet set6 = (arraySet) set3.intersection(set4);
        System.out.println("The intersection (set 6) is: " + set6);
        n = set6.size();
        System.out.println("The intersection (set 6) size is: " + n);
        set1.removeAll();
        n = set1.size();
        set2.removeAll();
        System.out.println("Set 2 is empty: " + set2.isEmpty());
        System.out.println("Number of items in set 1: " + n);
    }
}
