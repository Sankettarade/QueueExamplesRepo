package collectionqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLikedQueueEx {

	public static void main(String[] args) {
		
		// Create ConcurrentLinkedQueue
		
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		
		// Add elements in queue
		
		queue.add("Anil");
		queue.add("Ram");
		queue.add("Shyam");
		queue.add("Sai");
		
		
		System.out.println("Elements the queue : "+queue);
		
		// Remove element for the queue
		
		String removeElement = queue.poll();
		
		System.out.println("Removed Element : "+removeElement);
		
		System.out.println("Elements of the queue after removeing : "+queue);
				
	}

}
