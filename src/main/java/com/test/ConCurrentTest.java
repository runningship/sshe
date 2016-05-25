package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConCurrentTest {

	public static class Task implements Callable<String> {
		private String id;
		
		public Task(String id ){
			this.id = id;
		}
        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", id);
            return id;
        }
    }
 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<10;i++){
        	results.add(es.submit(new Task(String.valueOf(i))));
        	System.out.println("运行第"+i+"个线程");
        }
 
        for(Future<String> res : results){
        	System.out.println(res.get());
        }
        
        
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
	         public void run() {  
	          System.out.println(Thread.currentThread().getName()+" delay 1 seconds, and excute every 3 seconds");  
	         }  
        }, 1, 3, TimeUnit.SECONDS);
        
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
	         public void run() {  
	          System.out.println(Thread.currentThread().getName()+" delay 1 seconds, and excute every 2 seconds");  
	         }  
       }, 1, 2, TimeUnit.SECONDS);
    }
}
