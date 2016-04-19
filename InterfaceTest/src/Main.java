import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	
	public static void main(String[] args) {
		// 1. 기존의 방법
		LGCDPlayer lgcdPlayer = new LGCDPlayer();
		
		lgcdPlayer.play();
		lgcdPlayer.stop();
		lgcdPlayer.prev();
		lgcdPlayer.next();
		
		System.out.println("");
		
		// 2. IS A 관계를 이용한 방법
		// 관계의 정의
		// Sub Class is a Super class
		// LGCDPlayer is a CDPlayer
		CDPlayer lgPlayer = new LGCDPlayer();
		lgPlayer.play();
		lgPlayer.stop();
		lgPlayer.prev();
		lgPlayer.supple();
		System.out.println("");
		
		CDPlayer samsungPlayer = new SamsungCDPlayer();
		samsungPlayer.play();
		samsungPlayer.stop();
		samsungPlayer.prev();
		samsungPlayer.next();
		System.out.println("");
		
	}

}
