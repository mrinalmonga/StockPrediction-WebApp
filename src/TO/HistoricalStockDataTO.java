package TO;

import java.sql.Date;

public class HistoricalStockDataTO {
	private Date date;
	private String stockName;
	private String stockAcronym;
	private double price;
	private double high;
	private double low;
	private double open;
	private double close;
	private double volume;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
