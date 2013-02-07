import java.util.Arrays;

import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnNotifyQuote implements StdCallCallback{
	private SKQuoteLib skquotelib=null;
	public FOnNotifyQuote(SKQuoteLib skquotelib){
		this.skquotelib=skquotelib;
	}
	public void callback(short Market, short Index) {
		int Status;
		SKQuoteLib.Stock stock = new SKQuoteLib.Stock();
		Status = skquotelib.SKQuoteLib_GetStockByIndex(Market, Index, stock);
		if (Status == 0) {
			String[] str = translation(stock);
			System.out.println(Arrays.toString(str));
		}
	}
	
	private String[] translation(SKQuoteLib.Stock stock) {
		double Dot = Math.pow(10, stock.m_sDecimal);
		String[] result = new String[14];
		result[0] = new String(stock.m_caStockNo).trim();
		result[1] = new String(stock.m_caName).trim();
		result[2] = (stock.m_nBid / Dot) + "";
		result[3] = stock.m_nBc + "";
		result[4] = (stock.m_nAsk / Dot) + "";
		result[5] = stock.m_nAc + "";
		result[6] = (stock.m_nClose / Dot) + "";
		result[7] = (stock.m_nClose / Dot) - (stock.m_nRef / Dot) + "";
		result[8] = ((stock.m_nClose / Dot) / (stock.m_nRef / Dot)) - 1  + "";
		result[9] = stock.m_nTickQty + "";
		result[10] = stock.m_nTQty + "";
		result[11] = (stock.m_nHigh / Dot) + "";
		result[12] = (stock.m_nLow / Dot) + "";
		result[13] = (stock.m_nRef / Dot) + "";
		return result;
		
	}
}
