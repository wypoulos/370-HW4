import java.util.Random;

public class Producer implements Runnable{
	private Buffer buffer;
	private int BUFLIMIT;
	private int numsProduced = 0;
	private double cumulativeValueProd = 0.0;
	Producer(Buffer bufferIN){
		buffer = bufferIN;
		BUFLIMIT = buffer.bufferSize();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(numsProduced < 1000000) {
			synchronized (buffer){
				
				while(buffer.size() == BUFLIMIT) {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Random random = new Random();
				Double bufferElement = random.nextDouble() * 100.0;
				
				buffer.add(bufferElement);
				cumulativeValueProd += bufferElement;
				numsProduced++;
				
				if(numsProduced % 100000.0 == 0.0) {
					System.out.println("Producer: Generated " + String.format("%1$,d", numsProduced) + " items, Cumulative value of generated items=" + String.format("%1$.3f",cumulativeValueProd));
				}
				
				buffer.notify();
			}
		}
		System.out.println("Producer: Finished generating 1,000,000 items");
	}
}
