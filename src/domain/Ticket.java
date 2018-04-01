package domain;

public class Ticket {
//	 `Tid` varchar(255) DEFAULT NULL,
//	  `Ftid` varchar(255) DEFAULT NULL,
	
	private String Tid;
	private String Ftid;
	private String Ctid;
	private String payment;
	private String rebook;
	
	public String getCtid() {
		return Ctid;
	}
	public void setCtid(String ctid) {
		Ctid = ctid;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRebook() {
		return rebook;
	}
	public void setRebook(String rebook) {
		this.rebook = rebook;
	}
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getFtid() {
		return Ftid;
	}
	public void setFtid(String ftid) {
		Ftid = ftid;
	}
	
}
