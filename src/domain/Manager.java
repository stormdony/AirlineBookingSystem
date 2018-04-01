package domain;

public class Manager {
	private String Mid;
	private String Mpassword;
	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		Mid = mid;
	}
	public String getMpassword() {
		return Mpassword;
	}
	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}
	@Override
	public String toString() {
		return "Manager [Mid=" + Mid + ", Mpassword=" + Mpassword + "]";
	}
	
	

}
