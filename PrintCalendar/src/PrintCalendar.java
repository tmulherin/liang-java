import javax.swing.JOptionPane;


public class PrintCalendar {

	/**
	 * @param args
	 */
	
	static String dashes = "-----------------------------";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String yearString = JOptionPane.showInputDialog("Enter full year (e.g., 2001): "); 
		int year = Integer.parseInt(yearString);
		
		String monthString = JOptionPane.showInputDialog("Enter month's number (1 to 12): "); 
		int month = Integer.parseInt(monthString);
		
		printMonth(year, month);
	}
	
	public static void printMonth(int year, int month){
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}
	
	public static void printMonthBody(int year, int month){

		System.out.print(" Sun Mon Tue Wed Thu Fri Sat \n");
		System.out.print(" --- --- --- --- --- --- --- \n");		
		//   1   2   3   4   5   6   7
		//   8   9  10  11  12  13  14
		//  15  16  17  18  19  20  21
		//  22  23  24  25  26  27  28
		//  29  30
	}
	
    public static void printMonthTitle(int year, int month){
		
		String monthName = getMonthName(month);
		int prepad = (24 - monthName.length())/2;
		int postPad = (24 - monthName.length() - prepad);
		System.out.println(dashes);
		
		for(int i = 0; i < prepad; i++) {
			   System.out.print(" ");
			}
		System.out.print(monthName + " " + year);
		
		for(int i = 0; i < postPad; i++) {
			   System.out.print(" ");
			}
		System.out.print("\n");
		System.out.println(dashes);
	}
	
	public static String getMonthName(int month){
        String[] monthNames = {"January",
        		               "February",
        		               "March", 
        		               "April", 
        		               "May", 
        		               "June", 
        		               "July", 
        		               "August", 
        		               "September", 
        		               "October", 
        		               "November",
        		               "December"};
   
         return monthNames[month - 1];
	}
	
	public static int getStartDay(int year, int month){
		return 1;
	}
	
	public static int getNumberOfDaysInMonth(int year, int month){
		int days = 0;
		switch (month){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31; break;
			case 4: case 6: case 9: case 11: days = 30; break;
			case 2: if(isLeapYear(year)){days = 29;}
		            else{days = 28;}  
		}
		
		return days;
	}
	
	public static int getTotalNumberOfDays(int year, int month){
		return 100;
	}
	
	public static boolean isLeapYear(int year){
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}
	

}
