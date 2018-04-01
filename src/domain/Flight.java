package domain;

public class Flight {
	// `Fid` varchar(255) NOT NULL,
	// `Fname` varchar(255) DEFAULT NULL,
	// `start` varchar(255) DEFAULT NULL,
	// `destination` varchar(255) DEFAULT NULL,
	// `Fgrade` varchar(255) DEFAULT NULL,
	// `price` double(10,2) DEFAULT NULL,
	// `discount` double(10,2) DEFAULT NULL,
	// `Mid` varchar(255) DEFAULT NULL,
	// `begin` varchar(255) DEFAULT NULL,
	// `end` varchar(255) DEFAULT NULL,
	private String Fid;
	private String Fname;
	@Override
	public String toString() {
		return "Flight [Fid=" + Fid + ", Fname=" + Fname + ", start=" + start + ", destination=" + destination
				+ ", Fgrade=" + Fgrade + ", price=" + price + ", discount=" + discount + ", Mid=" + Mid + ", begin="
				+ begin + ", end=" + end + "]";
	}

	private String start;
	private String destination;
	private String Fgrade;
	private String price;
	private String discount;
	private String Mid;
	private String begin;
	private String end;

	public String getFid() {
		return Fid;
	}

	public void setFid(String fid) {
		Fid = fid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFgrade() {
		return Fgrade;
	}

	public void setFgrade(String fgrade) {
		Fgrade = fgrade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getMid() {
		return Mid;
	}

	public void setMid(String mid) {
		Mid = mid;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
