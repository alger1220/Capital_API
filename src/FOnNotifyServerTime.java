import com.sun.jna.NativeLong;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnNotifyServerTime implements StdCallCallback {
	public FOnNotifyServerTime(SKQuoteLib skquotelib){
	}
	public void callback(short Hour, short Minute, short Second,
			NativeLong Total) {
		System.out.println(Hour + ":" + Minute + ":" + Second);
	}
}