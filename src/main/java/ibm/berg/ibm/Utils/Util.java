package ibm.berg.ibm.Utils;

public final class Util {
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void SendMessage(String message) throws InterruptedException {
		Util.ClearScreen();
		System.out.println(message);
		Thread.sleep(1300);
	}

    public static void SendMessage(String message, long time) throws InterruptedException {
		Util.ClearScreen();
		System.out.println(message);
		Thread.sleep(time);
	}
}
