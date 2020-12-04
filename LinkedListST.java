package homework;
import algs13.Queue;


public class LinkedListST<Key extends Comparable<Key>, Value extends Comparable<Value>> {
    private Node first;      // the linked list of key-value pairs
	private Key max;
	private Key tempMax;
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    public LinkedListST() {
    	first = null;
    }
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("argument to get() is null"); 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("first argument to put() is null"); 
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null"); 
        first = delete(first, key);
    }  
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    public int size () {
    	return size(first);
    }
    public int size(Node x) {
    	
    	if (x == null) return 0; 
    	else return 1 + size(x.next);
    	
    }
    public Key secondMaxKey () {
    	if(first == null || size() <= 1) return null;
    
    	Key max = null;
    	Key secondMax = null;
    	
    	for (Node x = first; x != null; x = x.next) {
    		if(max == null || x.key.compareTo(max) > 0){
    			secondMax = max;
    			max = x.key;
    		}
    		else {
    			if(secondMax == null || x.key.compareTo(secondMax) > 0)
    				secondMax = x.key;
    		}
    	}
     return secondMax; // ToDo 2    fix this
    }
    public int rank (Key key) {return rankHelper(key, first);}
    public int rankHelper(Key key, Node x) {
    	int counter = 0;
    	
    	if(x == null) return 0;
    	if(key.compareTo(x.key) > 0) counter++;
    	
    	return counter + rankHelper(key,x.next);
    }    
    public Key floor (Key key) {
    	
    	Key max = null;
    	Key temp = null;
    	
    	for (Node x = first; x!= null; x = x.next) {
    		if(x.key.equals(key)) return key;
    		else {
    			if(x.key.compareTo(key) <= 0)
    				temp=x.key;
    			if(max==null || temp.compareTo(max)>0)
    				max = temp;
    		}
    		
    	}

    	return max;
    	
    }
    public LinkedListST<Value, Key> inverse () {
    	
    	LinkedListST<Value,Key> inverse = new LinkedListST<Value,Key>();
    	
    	for(Node x = first; x != null; x = x.next) {
    		Value v = x.val;
    		Key k = x.key;
    		
    		inverse.put(v,k);
    		
    	}
    	
    	return inverse; // Todo 5   fix this
    }
    public Iterable<Key>  keys() {
    	Queue<Key> theKeys = new Queue<Key>();
    	for ( Node temp = first; temp != null; temp=temp.next) {
    		theKeys.enqueue(temp.key);
    	}
    	return theKeys;
    }
}