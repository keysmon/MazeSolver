public class StackRefBased<T> implements Stack<T> {

	private StackNode<T> top;
	private int size;
	
	public StackRefBased(T item) {
		top = new StackNode<T>(item);
		size = 1;
	}
	
    public StackRefBased() {
    	top = null;
    	size = 0;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        if (top == null) {
        	return true;
        }return false;
    }


    public void push(T data) {
    	size++;
    	StackNode<T> naruto = new StackNode<T>(data);
    	if (top==null) {
    		top = naruto;
    	}else {
    		naruto.setNext(top);
    		top = naruto;
    	}
    	
    	
    }


    public T pop() throws StackEmptyException {
    	T temp = null;
    	try {
        	temp = top.getValue();
        	top = top.next;
        	size--;
        	
        	
        }catch (NullPointerException a) {
        	throw new StackEmptyException ("StackEmptyException");
        }return temp;
    }


    public T peek() throws StackEmptyException {
    	try {
    		return top.getValue();
    		
    	}catch (NullPointerException a) {
        	throw new StackEmptyException ("StackEmptyException");
    	}
    	
    }


    public void makeEmpty() {
    	top = null;
    	size = 0;
    }
    


    public String toString() {
    	StringBuilder God = new StringBuilder();
        if (top ==null) {
        	return "";
        }
        StackNode<T> Madara = top;
      
        for (int i=0;i<size-1;i++) {
        	God.insert(0,Madara.getValue()+" ");
        	Madara = Madara.next;
        }God.insert(0,Madara.getValue()+" ");
        
        return God.toString();
    }
}

