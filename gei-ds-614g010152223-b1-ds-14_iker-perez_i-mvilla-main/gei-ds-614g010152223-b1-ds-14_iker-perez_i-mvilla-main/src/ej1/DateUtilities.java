package ej1;

public class DateUtilities {
    /**
     * Indicates whether a year is a leap year . A leap year is divisible by 4,
     * unless it is divisible by 100 , in which case it must be divisible by 400
     * in order to be considered a leap year (e.g., 1900 is not a leap year ,
     * but 2000 is) = > See the JUnit seminar for an example .
     *
     * @param year the given year
     * @return True if the given year is a leap year , false otherwise .
     */
    public static boolean isLeap(int year) {
        boolean leap;
        if(year % 4 == 0){
            if (year % 100 == 0){
                leap = year % 400 == 0;
            }else {
                leap = true;
            }
        } else{
            leap = false;
        }
        return leap;
    }

    /**
     * Indicates the number of days of a given month . As the number of days in
     * the month of February depends on the year , it is also necessary to pass
     * the year as an argument .
     *
     * @param month The given month
     * @param year  The given year
     * @return The number of days of that month in that year .
     * @throws IllegalArgumentException if the month is not valid .
     */
    public static int numberOfDays(int month, int year) {
        int numDays;
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                numDays = 31;
                break;
            case 2:
                if (isLeap(year)){
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            case 4, 6, 9, 11:
                numDays = 30;
                break;
            default:
                throw new IllegalArgumentException("month is not valid");
        }
        return numDays;
    }

    /**
     * The ISO date format is a standard format that displays the dates
     * starting with the year , followed by the month and the day , i.e. ,
     * "YYYY -MM -DD ". For example , in that format the text " July 28 , 2006"
     * would be represented as "2006 -07 -28".
     * The " convertToISO " method converts a date in the " Month DD , AAAA "
     * format to its ISO representation . For simplicity , let us assume that
     * the values are correctly formatted even if the date is invalid
     * (e.g., " February 31 , 2006" is correctly formatted but it is not a valid date )
     *
     * @param dateText Date in textual format ( USA style ).
     * @return A string with the given date in ISO format .
     */
    public static String convertToISODate(String dateText) {
        String month, dayWith, day, year, numMonth, isoDate;
        String[] parts = dateText.split(" ");
        month = parts[0];
        dayWith = parts[1];
        year = parts[2];
        String[]partDay = dayWith.split(",");
        day = partDay[0];
        numMonth = switch (month) {
            case "January" -> "01";
            case "February" -> "02";
            case "March" -> "03";
            case "April" -> "04";
            case "May" -> "05";
            case "June" -> "06";
            case "July" -> "07";
            case "August" -> "08";
            case "September" -> "09";
            case "October" -> "10";
            case "November" -> "11";
            case "December" -> "12";
            default -> throw new IllegalArgumentException();
        };
        isoDate = year+"-"+numMonth+"-"+day;
        return isoDate;
    }

    /**
     * Given a String representing an ISO - formatted date , the methods checks
     * its validity . This includes checking for non - valid characters , erroneous
     * string lengths , and the validity of the date itself (i.e. , checking the
     * number of days of the month ).
     *
     * @param ISODate A date in ISO format
     * @return True if the ISO - formatted date is a valid date , False otherwise .
     */
    public static boolean checkISODate(String ISODate) {
        String[] parts = ISODate.split("-");
        String year = parts[0];
        String month = parts[1];
        String days = parts[2];
        int numYear = Integer.parseInt(year);
        int numMonth = Integer.parseInt(month);
        int numDays = Integer.parseInt(days);

        switch (numMonth){
            case 1, 3, 5, 7, 8, 10, 12:
                return numDays <= 31;
            case 2:
                if (isLeap(numYear)){
                    return numDays <= 29;
                } else {
                    return numDays <= 28;
                }
            case 4, 6, 9, 11:
                return numDays <=30;
            default:
                return false;
        }
    }
}