package main;

public class SMain {
	Skeleton skelton;

	private void run() {
		this.skelton = new Skeleton();
		this.skelton.process();
	}
	public static void main(String[] args) {
		SMain sMain = new SMain();
		sMain.run();
	}
}
