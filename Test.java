import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

/**
 * runs a colection test for a given size, and test type and repeas for the number of iterations
 * @author Joel Anderson
 */
public class Test implements CollectionTest
{
    private int size;
    private ArrayList<Person> arrayList;
    private LinkedList<Person> linkedList;
    private HashMap<Integer, Person> hashMap;

    
    public Test(){

    }
    
    /**
     * Defines the size of the collections that should be created when the ADD test is run.
     *
     * @param size the number of unique items to add to each collection.
     */
    public void setSize(int size){
        this.size = size;
    }

    /**
     * Performs the requested test on the requested collection type.
     *
     * ADD test should create a NEW collection of the given type, and populate it with "size" *unique* instances of a Person (as defined by a previous call to setSize).
     * INDEX test should retrieve an item from the collection based on its index in that collection. The position should be approximately half-way through the collection. (e.g. the 42nd item in a collection of size 84) 
     * SEARCH test should retrieve an item from the collection based only the Person's name (e.g. the Person with the name "Person1234"). An item should be chosen that you expect to be approximatley half way through the collection.
     *
     * @param type the type of collection to be tested.
     * @param test the type of test to be undertaken.
     * @param iterations the number of times to repeat the given test before returning.
     */
    public void runTest(CollectionType type, TestType test, int iterations){
        
        for(int i = 0; i <= iterations; i++)
        switch (test +" "+ type) {
            //ADD
            case "ADD LINKED_LIST":
                addLinkedList(size);
            break;
            case "ADD ARRAY_LIST":
                addArrayList(size);
            break;
            case "ADD HASH_MAP":
                addHashMap(size);
            break;
            //INDEX
            case "INDEX LINKED_LIST":
                indexLinkedList(size);
            break;
            case "INDEX ARRAY_LIST":
                indexArrayList(size);
            break;
            case "INDEX HASH_MAP":
                indexHashMap(size);
            break;      
            //SEARCH
            case "SEARCH LINKED_LIST":
                searchLinkedList(size);
            break;
            case "SEARCH ARRAY_LIST":
                searchArrayList(size);
            break;
            case "SEARCH HASH_MAP":
                searchHashMap(size);
            break;

            default:
                break;
        }
    }
    //add
    /**
     * creates a linked list & fills it with people
     * @param size the size of the collection
     */
    private void addLinkedList(int size){
        linkedList = new LinkedList<Person>();
        for (int i = 0; i < size; i++)
            linkedList.add(new Person("Person" + i, i));
    }
    /**
     * creates a array list & fills it with people
     * @param size the size of the collection
     */
    private void addArrayList(int size){
        arrayList = new ArrayList<Person>();
        for (int i = 0; i < size; i++)
            arrayList.add(new Person("Person" + i, i)); 
    }
    /**
     * creates a hash map & fills it with people
     * @param size the size of the collection
     */
    private void addHashMap(int size){
        hashMap = new HashMap<Integer, Person>();       
        for (int i = 0; i < size; i++)
            hashMap.put(i, new Person("Person" + i, i));
    }
    
    //index
    /**
     * gets the person from the index half way through the liked list
     * @param size the size of the collection
     */
    private void indexLinkedList(int size){
        Person p = linkedList.get(size/2);
    } 
    /**
     * gets the person from the index half way through the array list
     * @param size the size of the collection
     */
    private void indexArrayList(int size){
        Person p = arrayList.get(size/2);
    }
    /**
     * gets the person from the index half way through the hash map
     * @param size the size of the collection
     */
    private void indexHashMap(int size){
        Person p = hashMap.get(size/2);
    }

    //search
    /**
     * gets the index of a person that is half way through the linked list
     * @param size the size of the collection
     */
    private void searchLinkedList(int size){
        Person middlePerson = new Person("Person" + size/2, size/2);
        int i = linkedList.indexOf(middlePerson);
    } 
    /**
     * gets the index of a person that is half way through the array list
     * @param size the size of the collection
     */
    private void searchArrayList(int size){
        Person middlePerson = new Person("Person" + size/2, size/2);
        int i = arrayList.indexOf(middlePerson);

    }
    /**
     * gets the index of a person that is half way through the hash map
     * @param size the size of the collection
     */
    private void searchHashMap(int size){

        for (HashMap.Entry<Integer, Person> entry : hashMap.entrySet()) {
              if (Objects.equals(entry.getValue(), new Person("Person" + size/2, size/2))) {
                  int i = entry.getKey();
                  break;
              }
        }
    }
}