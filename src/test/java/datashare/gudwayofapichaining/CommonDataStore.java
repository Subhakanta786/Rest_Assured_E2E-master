package datashare.gudwayofapichaining;

//this class is use to take variable which is common to all the testcases
public class CommonDataStore {
	
	private int bookingID;
	private static CommonDataStore cd;
	
	//singleton design pattern :- gud practice to write efficient code
	private CommonDataStore() {
		
	}
	
	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookID) {
		cd.bookingID = bookID;
	} 
	
	public static CommonDataStore getInstance() {
		cd=new CommonDataStore();
		return cd;
	}

}
