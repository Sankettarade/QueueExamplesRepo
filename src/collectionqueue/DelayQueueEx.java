package collectionqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayData implements Delayed{
	private String data;
	private long delayTime;
	private long expireTime;
	
	public DelayData(String data, long delayTime)
	{
		this.data = data;
		this.delayTime = delayTime;
		this.expireTime = System.currentTimeMillis() + delayTime;
	}



public long getDelay(TimeUnit unit) {
    long diff = expireTime - System.currentTimeMillis();
    return unit.convert(diff, TimeUnit.MILLISECONDS);
}

public int compareTo(Delayed other) {
    return Long.compare(this.expireTime, ((DelayData) other).expireTime);
}

   @Override
   public String toString() {
      return "DelayData{" +
            "data='" + data + '\'' +
            ", delayTime=" + delayTime +
            '}';
  }
}

public class DelayQueueEx {

	public static void main(String[] args) throws InterruptedException{
	
		// Create DelayQueue
		
		DelayQueue<DelayData> delayQueue = new DelayQueue<>();
		
		// Add delayed elements to the queue
	    delayQueue.put(new DelayData("Task 1", 1000));
	    delayQueue.put(new DelayData("Task 2", 3000)); 
	    delayQueue.put(new DelayData("Task 3", 2000)); 
	
	   // Print all elements of the queue
	    System.out.println("Initial DelayQueue: \n" + delayQueue);
	    
	    
	    while (!delayQueue.isEmpty()) {
	    	DelayData element = delayQueue.take();
	        System.out.println("Processing element : " + element);
	        // Processing time
	        Thread.sleep(1000); 
	    }
	    
	    System.out.println("All elements processed");
	    
	}

}
