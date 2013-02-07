Capital_API
===========
作者：Philipz(philipzheng@gmail.com)<br/>
Blog：http://server.everfine.com.tw/blog/<br/>
感謝Lucas(jenru.tw@gmail.com)提供JNA+SWT來接C語言Callback的程式碼

使用Java JNA和SWT去界接群益報價API的範例

1.使用必要條件<br/>
　a.需有群益帳戶<br/>
　b.有開通報價API，並下載那API相關DLL檔<br/>

2.使用方法<br/>
　a.將群益帳號密碼輸入到SKQuoteLib_SWT_Example的身分證字號和密碼。<br/>
　b.將那SKQuoteLib.dll複製到這專案目錄下。<br/>
　c.如果那SKQuoteLib.dll為32位元，請用32位元版的SWT和JDK，若64位元，則用64位元版的SWT和JDK。<br/>
　　目前是使用32位元。<br/>
　d.執行那SKQuoteLib_SWT_Example.java，就會登入並取得Server端時間，按下接收報價就會取得台指期跟領先指的報價。<br/>
　e.要結束請先按結束連線再關閉。<br/>

目前TradingBot - 程式交易機器人，就是使用群益報價API<br/>
歡迎大家加入討論程式交易，http://www.facebook.com/tradingbot<br/><br/>
<img alt="capital_api.png" src="http://server.everfine.com.tw/blog/capital_api.png" width="475" height="270">
