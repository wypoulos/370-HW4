
public class ProducerConsumer {
	public static void main(String[] args) {
		Buffer buffer = new Buffer(1000);
		Thread producer = new Thread(new Producer(buffer));
		Thread consumer = new Thread(new Consumer(buffer));
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Exiting!");
	}
}
