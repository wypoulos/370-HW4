
public class Consumer implements Runnable{
	private Buffer buffer;
	private int numsConsumed = 0;
	private double cumulativeValueCons = 0.0;
	Consumer(Buffer bufferIN){
		buffer = bufferIN;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(numsConsumed < 1000000) {
			synchronized (buffer){
				
				while(buffer.size() == 0) {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
								
				double value = buffer.removeFirst();
				cumulativeValueCons += value;
				numsConsumed++;
				
				if(numsConsumed % 100000.0 == 0.0) {
					System.out.println("Consumer: Consumed " + String.format("%1$,d", numsConsumed) + " items, Cumulative value of consumed items=" + String.format("%1$.3f",cumulativeValueCons));
				}
				
				buffer.notify();
			}
		}
		System.out.println("Consumer: Finished consuming 1,000,000 items");
	}
}
