import java.util.LinkedList;

public class Buffer {
	private LinkedList<Double> list = new LinkedList<Double>();
	int bufferSize;
	
	Buffer(int size){
		bufferSize = size;
	}
	public void add(Double a) {
		if(list.size() < bufferSize) {
			list.add(a);
		}else {
			throw new IndexOutOfBoundsException("Buffer: Size limit reached!");
		}
	}
	
	public Double removeFirst() {		
		return list.removeFirst();
	}
	public int bufferSize() {
		// TODO Auto-generated method stub
		return bufferSize;
	}
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
	
}
