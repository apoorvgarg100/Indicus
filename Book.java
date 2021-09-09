public class Book {
	private int bid;
	private String bname;
	private Date pdate;
	private String genre;
	private float rating;
	private int authid;
	
	public Book(int bid,String bname,Date pdate,String genre,float rating,int authid) {
		this.bid = bid;
		this.bname = bname;
		this.pdate = pdate;
		this.genre = genre;
		this.rating = rating;
		this.authid = authid;
	}
	
	public int getBid(){
		return bid;
	}
	public String getBname() {
		return bname;
	}
	public Date getPdate(){
		return pdate;
	}
	public String getGenre() {
		return genre;
	}
	public float getRating(){
		return rating;
	}
	public int getAuthid() {
		return authid;
	}
}