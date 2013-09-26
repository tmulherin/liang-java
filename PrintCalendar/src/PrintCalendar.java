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

		String daypad = "    ";
		String day = "";
		int dayCount = 0;
		int startDay = getFirstDayInMonth(year, month);
		int days = getNumberOfDaysInMonth(year, month);
		String monthOut = "";

		System.out.print(" Sun Mon Tue Wed Thu Fri Sat \n");
		System.out.print(" --- --- --- --- --- --- --- \n");	
		// -----------------------------
        //         August 2050         
        //-----------------------------
        // Sun Mon Tue Wed Thu Fri Sat 
        // --- --- --- --- --- --- ---
		//   1   2   3   4   5   6   7
		//   8   9  10  11  12  13  14
		//  15  16  17  18  19  20  21
		//  22  23  24  25  26  27  28
		//  29  30  31
		//System.out.print("startDay = " + startDay + "\n");
		
		for(int i = (1 - startDay); i < (days + 1); i++){
			if(i > 0){
				day = daypad + i;
				monthOut += day.substring(day.length() - 4);
			}
			else
				monthOut += daypad;
			
			dayCount++;
			if(dayCount % 7 == 0)
				monthOut += "\n";
		}
		
		System.out.print(monthOut + "\n" + dashes);
		
		//System.out.print("The first day of " + getMonthName(month) + ", " + year + " is " + getDayName(startDay) + ".");*/
	}
	
    public static void printMonthTitle(int year, int month){
		
		String monthName = getMonthName(month);
		int pad = (24 - monthName.length())/2;

		System.out.println(dashes);
		for(int i = 0; i < pad; i++) {
			   System.out.print(" ");
			}
		System.out.print(monthName + " " + year);
    	System.out.print("\n");
		System.out.println(dashes);
	}
	
    public static String getDayName(int day){
    	String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    	
    	return dayNames[day - 1];
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
	
	public static int getFirstDayInMonth(int year, int month){
        int firstDayOfYear = getFirstDayInYear(year, month);
        int days = 0;
        
        for(int i=0; i < month; i++){
        	days += getNumberOfDaysInMonth(year, i);
        }
    
        int firstDayOfMonth = firstDayOfYear + (days % 7);

        if(firstDayOfMonth > 6)
        	firstDayOfMonth -= 7;
		
        return firstDayOfMonth;
	}
	
	public static int getNumberOfDaysInMonth(int year, int month){
		int days = 0;
		switch (month){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31; break;
			case 4: case 6: case 9: case 11: days = 30; break;
			case 2: if(isLeapYear(year))
                        days = 29;
		            else
                        days = 28;  
		}
		
		return days;
	}
	
	public static int getFirstDayInYear(int year, int month){
        
		int[] firstDayYear0 = {7, 1, 2, 3, 5, 6, 7, 1, 3, 4, 5, 6};
		
		int yearMod84 = year % 84;
        int dayPos = yearMod84 % 12;
		int yearsOffset = (int)(yearMod84 / 12);
		
		if (dayPos == 0){
				dayPos = 12;
				yearsOffset--;
				if(yearsOffset == -1)
					yearsOffset = 6;
			}
	

        int firstDayOfYear = firstDayYear0[dayPos - 1] + yearsOffset;
        if (firstDayOfYear > 7)
        	firstDayOfYear = firstDayOfYear - 7;
               
        return firstDayOfYear;
		
	}
	
	public static boolean isLeapYear(int year){
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}
	

}
