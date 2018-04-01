package domain;

public class Customer {
	// `Cid` varchar(255) NOT NULL,
	// `Cpassword` varchar(255) DEFAULT NULL,
	// `Cname` varchar(255) DEFAULT NULL,
	// `phone` varchar(255) DEFAULT NULL,
	// `Cpaperwork` varchar(255) DEFAULT NULL,
	// `Tid` varchar(255) DEFAULT NULL,
	private String Cid;
	private String Cpassword;
	private String Cname;
	private String phone;
	private String Cpaperwork;
	private String Tid;

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getCpassword() {
		return Cpassword;
	}

	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpaperwork() {
		return Cpaperwork;
	}

	public void setCpaperwork(String cpaperwork) {
		Cpaperwork = cpaperwork;
	}


	public String getTid() {
		return Tid;
	}

	public void setTid(String tid) {
		Tid = tid;
	}

}
