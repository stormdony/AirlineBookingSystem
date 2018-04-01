package domain;

public class Book {
	// `Cid` varchar(255) NOT NULL,
	// `Fid` varchar(255) DEFAULT NULL
	private String Cid;
	private String Fid;

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getFid() {
		return Fid;
	}

	public void setFid(String fid) {
		Fid = fid;
	}

}
