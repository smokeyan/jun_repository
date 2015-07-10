package junutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TPoolThread {

	
	public String  tt(){
		ExecutorService  poolThread=Executors.newSingleThreadExecutor();
		poolThread.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(111);
			}
		});
		poolThread.shutdown();
		System.out.println(2);
		return "123";
	}
	public static void main(String[] args) {

		System.out.println(new TPoolThread().tt());
	}
}

