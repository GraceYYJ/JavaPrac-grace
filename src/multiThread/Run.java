package multiThread;

public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			System.out.println("Thread.currentThread()="+Thread.currentThread().getName());

			//Thread.currentThread().interrupt();
			System.out.println("是否停止="+thread.interrupted());
			System.out.println("是否停止="+thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}

