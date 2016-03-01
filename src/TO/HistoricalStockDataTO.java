package TO;

import java.sql.Date;

public class HistoricalStockDataTO {
	private String date;
	private String stockAcronym;
	private double Adj;
	private double high;
	private double low;
	private double open;
	private double close;
	private double volume;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStockAcronym() {
		return stockAcronym;
	}

	public void setStockAcronym(String stockAcronym) {
		this.stockAcronym = stockAcronym;
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

	public double getAdj() {
		return Adj;
	}

	public void setAdj(double adj) {
		Adj = adj;
	}

}
