package CSV.writeread;

public class Employee {
	private String businessname;
	private int mid;
	private String amount;
	private String cardnumber;
	private String invoiceid;
	private String dateandtime;
	private String date;
	private String settletype ;
	private String mdramt ;
	private String cardbrand ;
	private String cardcurr ;
	private String cardtype ;
	private String settlementdate ;
	private String midd;
	
	

public String getMidd() {
		return midd;
	}

	public void setMidd(String midd) {
		this.midd = midd;
	}

public String getSettlementdate() {
		return settlementdate;
	}

	public void setSettlementdate(String settlementdate) {
		this.settlementdate = settlementdate;
	}

public String getCardbrand() {
		return cardbrand;
	}

	public void setCardbrand(String cardbrand) {
		this.cardbrand = cardbrand;
	}

	public String getCardcurr() {
		return cardcurr;
	}

	public void setCardcurr(String cardcurr) {
		this.cardcurr = cardcurr;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

@Override
	public String toString() {
		return "Employee [businessname=" + businessname + ", mid=" + mid + ", amount=" + amount + ", cardnumber="
				+ cardnumber + ", invoiceid=" + invoiceid + ", dateandtime=" + dateandtime + "]";
	}
//		private int empno;
//	private String empname;
//	private String position;
//	public int getEmpno() {
//		return empno;
//	}
//	public void setEmpno(int empno) {
//		this.empno = empno;
//	}
//	public String getEmpname() {
//		return empname;
//	}
//	public void setEmpname(String empname) {
//		this.empname = empname;
//	}
//	public String getPosition() {
//		return position;
//	}
//	public void setPosition(String position) {
//		this.position = position;
//	}
//	@Override
//	public String toString() {
//		return "Student [empno=" + empno + ", empname=" + empname + ", position=" + position + "]";
//	}
	
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}
	public String getSettletype() {
		return settletype;
	}

	public void setSettletype(String settletype) {
		this.settletype = settletype;
	}

public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

public String getMdramt() {
		return mdramt;
	}

	public void setMdramt(String mdramt) {
		this.mdramt = mdramt;
	}

	

}
