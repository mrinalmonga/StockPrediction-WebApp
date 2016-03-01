package TO;

public class RealTimeStockDataTO {
	
	private String stockName;
	private String stockAcronym;
	private double ask;
	private double bid;
	private double bookPrice;
	private double volume;
	private String LastTradeTime;
	private double LastTradePrice;

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}


	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockAcronym() {
		return stockAcronym;
	}

	public void setStockAcronym(String stockAcronym) {
		this.stockAcronym = stockAcronym;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double d) {
		this.volume = d;
	}

	public String getLastTradeTime() {
		return LastTradeTime;
	}

	public void setLastTradeTime(String lastTradeTime) {
		LastTradeTime = lastTradeTime;
	}

	/**
	 * @return the lastTradePrice
	 */
	public double getLastTradePrice() {
		return LastTradePrice;
	}

	/**
	 * @param lastTradePrice the lastTradePrice to set
	 */
	public void setLastTradePrice(double lastTradePrice) {
		LastTradePrice = lastTradePrice;
	}
}