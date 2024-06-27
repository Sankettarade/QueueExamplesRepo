package collectionqueue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueEx {

	public static void main(String[] args) {
		
		 
		        // Create aLinkedTransferQueue instance
		        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

		        // Create producer thread
		        Thread producer = new Thread(() -> {
		            try {
		                // Add an element to the queue
		                System.out.println("Producer: Adding elements to queue");
		                queue.add("Java");
		                queue.transfer("Hello world"); 
		                System.out.println("Producer: Element added to queue");
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        });

		        // Create consumer thread
		        Thread consumer = new Thread(() -> {
		            try {
		                // Take an element from the queue
		                System.out.println("Consumer: Waiting for element in queue");
		                String element = queue.take(); // takes the element from the producer
		                System.out.println("Consumer: Element taken from queue: " + element);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        });

		        // Start the producer and consumer threads
		        producer.start();
		        consumer.start();
		    }
		

	}


