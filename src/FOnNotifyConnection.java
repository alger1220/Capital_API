import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public class FOnNotifyConnection implements StdCallCallback{
	public FOnNotifyConnection(SKQuoteLib skquotelib){
	}
	public void callback(int a,int b){
		System.out.println(this.getClass().getName()+" , "+a+" , "+b);
		if(a==100 && b==0) {
			System.out.println("報價伺服器登入成功!!");
		}
		else
			System.out.println("報價中斷!!");
	}
} 