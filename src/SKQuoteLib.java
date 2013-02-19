import java.util.Arrays;
import java.util.List;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface SKQuoteLib extends StdCallLibrary{ 
	public int SKQuoteLib_AttachConnectionCallBack(FOnNotifyConnection d);
	public int SKQuoteLib_AttachQuoteCallBack(FOnNotifyQuote d);
	public int SKQuoteLib_AttchServerTimeCallBack(FOnNotifyServerTime d); 
	public int SKQuoteLib_AttachMarketHighLowCallBack(FOnNotifyMarketHighLow d);
	public int SKQuoteLib_AttachMarketBuySellCallBack(FOnNotifyMarketBuySell d);
	public int SKQuoteLib_AttachMarketTotCallBack(FOnNotifyMarketTot d);
	public int SKQuoteLib_AttachKLineDataCallBack(FOnNotifyKLineData d); 
	public int SKQuoteLib_AttachBest5GetCallBack(FOnNotifyBest5Get d);
	public int SKQuoteLib_AttachBest5CallBack(FOnNotifyBest5 d);
	public int SKQuoteLib_AttachTicksGetCallBack(FOnNotifyTicksGet d);
	public int SKQuoteLib_AttachTicksCallBack(FOnNotifyTicks d); 
	public int SKQuoteLib_AttachFutureTradeInfoCallBack(FOnNotifyFutureTradeInfo d);
 
	public int SKQuoteLib_GetQuoteRequest(int index,QUOTEITEM qitem); 
	public int SKQuoteLib_Initialize(String id,String pass);
	public int SKQuoteLib_EnterMonitor();
	public int SKQuoteLib_LeaveMonitor();
	public int SKQuoteLib_QuoteRequest();
	
	public int SKQuoteLib_GetServerTime(FORMAT05 Format05);
	public int SKQuoteLib_GetStockByIndex(short market,short index,Stock stock);		
	public int SKQuoteLib_GetStockByNo(String str,Stock stock);		//WString instead of tchar*
	public int SKQuoteLib_GetBest5(short sMarketNo,short sStockidx,BEST5 Best5);
	public int SKQuoteLib_GetKLine(String caStockNo,int KLineType );
	public int SKQuoteLib_GetMarketBuySell(int index,char cMarketNo ,short sPrt ,LongByReference lTime,
			LongByReference lBc,LongByReference lSc,LongByReference lBs,LongByReference lSs);
	public int SKQuoteLib_GetMarketHighLow(int index,char cMarketNo ,short sPrt ,LongByReference lTime,
			ShortByReference sUp,ShortByReference sDown,ShortByReference sHigh,ShortByReference sLow,ShortByReference sNoChange);
	public int SKQuoteLib_GetMarketTot(int index,byte cMarketNo ,short sPrt,LongByReference lTime,LongByReference lTotv,
			LongByReference lTots,LongByReference  lTotc); 
	
	public int SKQuoteLib_GetStrikePrices();
	public int SKQuoteLib_GetTick(short sMarketNo,short sStockidx,int nPtr,TICK tick); 
	public int SKQuoteLib_GetVersion(String lpszVersion,IntByReference pnSize);
	public int SKQuoteLib_RequestStocks(ShortByReference psPageNo, String pStockNos);
	public int SKQuoteLib_RequestTicks(ShortByReference psPageNo,String s);
	
	public int SKQuoteLib_RequestServerTime();
	
	public int SKQuoteLib_Rho(int nCallPut,double S,double K,double R,double T,double sigma ,DoubleByReference dRho);
	public int SKQuoteLib_Theta(int nCallPut,double S,double K,double R,double T,double sigma ,DoubleByReference dTheta);
	public int SKQuoteLib_Vega(double S,double K,double R,double T,double sigma ,DoubleByReference dVega);
	public int SKQuoteLib_Delta(int nCallPut,double S,double K,double R,double T,double sigma,DoubleByReference dDelta);
	public int SKQuoteLib_Gamma(double S,double K,double R,double T,double sigma ,DoubleByReference dGamma);
	
	 
	public ShortByReference sbr_tick=new ShortByReference((short)-1);
//java對應c的structure  主要在處理指標
	public static class QUOTEITEM extends Structure{
		public short m_sIndex;
		public int m_nStockidx;
		public int m_nHour;
		public int m_nMin;
		public int m_nSec;
		public int m_nMSec;
		public int m_nDuration; 
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_sIndex", "m_nStockidx", "m_nHour", "m_nMin", "m_nSec", "m_nMSec", "m_nDuration"});
		}
	}
	
	
	
//java對應c的structure  主要在處理指標	
	public static class FORMAT05 extends Structure{
		public short m_sHour;
		public short m_sMinute;
		public short m_sSecond;
		public NativeLong m_lTotal;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_sHour", "m_sMinute", "m_sSecond", "m_lTotal"});
		}
	}
//java對應c的structure  主要在處理指標
	public static class BEST5 extends Structure{
		public int m_nBid1;
		public int m_nBidQty1;
		public int m_nBid2;
		public int m_nBidQty2;
		public int m_nBid3;
		public int m_nBidQty3;
		public int m_nBid4;
		public int m_nBidQty4;
		public int m_nBid5;
		public int m_nBidQty5;
		public int m_nExtendBid;
		public int m_nExtendBidQty;
		public int m_nAsk1;
		public int m_nAskQty1;
		public int m_nAsk2;
		public int m_nAskQty2;
		public int m_nAsk3;
		public int m_nAskQty3;
		public int m_nAsk4;
		public int m_nAskQty4;
		public int m_nAsk5;
		public int m_nAskQty5;
		public int m_nExtendAsk;
		public int m_nExtendAskQty;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_nBid1", "m_nBidQty1", "m_nBid2", "m_nBidQty2", "m_nBid3", "m_nBidQty3", "m_nBid4", "m_nBidQty4", "m_nBid5", "m_nBidQty5", "m_nExtendBid", "m_nExtendBidQty", "m_nAsk1", "m_nAskQty1", "m_nAsk2", "m_nAskQty2", "m_nAsk3", "m_nAskQty3", "m_nAsk4", "m_nAskQty4", "m_nAsk5", "m_nAskQty5", "m_nExtendAsk", "m_nExtendAskQty"});
		}
	}
//java對應c的structure  主要在處理指標	
	public static class TICK extends Structure{
		public int m_nPtr;
		public int m_nTime;
		public int m_nBid;
		public int m_nAsk;
		public int m_nClose;
		public int m_nQty;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_nPtr", "m_nTime", "m_nBid", "m_nAsk", "m_nClose", "m_nQty"});
		}
	}
	
	public static class Stock extends Structure {
		public short m_sStockidx;
		public short m_sDecimal;
		public short m_sTypeNo;
		public byte m_cMarketNo;
		public byte[] m_caStockNo = new byte[20];
		public byte[] m_caName = new byte[10];
		public int m_nOpen;
		public int m_nHigh;
		public int m_nLow;
		public int m_nClose;
		public int m_nTickQty;
		public int m_nRef;
		public int m_nBid;
		public int m_nBc;
		public int m_nAsk;
		public int m_nAc;
		public int m_nTBc;
		public int m_nTAc;
		public int m_nFutureOI;
		public int m_nTQty;
		public int m_nYQty;
		public int m_nUp;
		public int m_nDown;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_sStockidx", "m_sDecimal", "m_sTypeNo", "m_cMarketNo", "m_caStockNo", "m_caName", "m_nOpen", "m_nHigh", "m_nLow", "m_nClose", "m_nTickQty", "m_nRef", "m_nBid", "m_nBc", "m_nAsk", "m_nAc", "m_nTBc", "m_nTAc", "m_nFutureOI", "m_nTQty", "m_nYQty", "m_nUp", "m_nDown"});
		};
	}
}



