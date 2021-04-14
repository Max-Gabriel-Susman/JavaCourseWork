import static java.util.TimeZone.getDefault;

public class JulianDate extends Date {

    //public String monthName;

    public int month;

    public int year;

    public int dayOfMonth;

    JulianDate() {
        /*
        setMonth(1);
        setDayOfMonth(1);
        setYear(1970);

        int days = (((int)(System.currentTimeMillis()) - getDefault().getRawOffset()) / 3600000);

        addDays(days);

         */
    }

    JulianDate(int year, int month, int day) {

        setDayOfMonth(day);
        setMonth(month);
        setYear(year);

    }


    public void addDays(int days) {
        int addedDays = getDayOfMonth();
        int addedMonths = getMonth();
        int addedYear = getYear();

        for (int i = 0; i < days; i ++) {
            addedDays ++;

            if(addedDays > getNumberOfDaysInMonth(addedYear, addedMonths)) {
                addedDays = 1;
                addedMonths ++;

                if(addedMonths > 12) {
                    addedMonths = 1;
                    addedYear ++;
                }
            }

        }

        setDayOfMonth(addedDays);
        setMonth(addedMonths);
        setYear(addedYear);
    }

    public void subtractDays(int days) {
        int addedDays = getDayOfMonth();
        int addedMonths = getMonth();
        int addedYear = getYear();

        for (int i = days; i > 0; i --) {
            addedDays --;

            if(addedDays < 1) {
                addedMonths --;
                addedDays = getNumberOfDaysInMonth(addedYear, addedMonths);


                if(addedMonths < 1) {
                    addedMonths = 12;
                    addedYear --;
                }
            }

        }

        setDayOfMonth(addedDays);
        setMonth(addedMonths);
        setYear(addedYear);
    }

    public boolean isLeapYear() {

        boolean leap = false;

        if(isLeapYear(getYear())) {
            leap = true;
        }

        return leap;
    }

    public void printShortDate() {
        System.out.println(getMonth() + "/" + getDayOfMonth() + "/" + getYear());
    }

    public void printLongDate() {
        System.out.println(getMonthName() + " " + getDayOfMonth() + ", " + getYear());
    }

    public String getMonthName() {

        return getMonthName(getMonth());
    }

    public int getMonth() {

        return this.month;
    }

    public int getYear() {

        return this.year;
    }

    public int getDayOfMonth() {

        return this.dayOfMonth;
    }

    public void setMonth(int month) {

        this.month = month;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public void setDayOfMonth(int dayOfMonth) {

        this.dayOfMonth = dayOfMonth;
    }

    public boolean isLeapYear(int year) {

        boolean leap = false;

        if(year % 4 == 0) {
            leap = true;
        }

        return leap;
    }

    private int getNumberOfDaysInMonth(int year, int month) {

        int numberOfDays = 31;

        switch (month) {
            case 4:
                numberOfDays = 30;
                break;
            case 6:
                numberOfDays = 30;
                break;
            case 9:
                numberOfDays = 30;
                break;
            case 11:
                numberOfDays = 30;
                break;
            case 2:
                if(isLeapYear())
                {
                    numberOfDays = 28;
                    break;
                }
                else
                {
                    numberOfDays = 28;
                    break;
                }
        }

        return numberOfDays;
    }

    private int getNumberOfDaysInYear(int year) {

        int numberOfDays = 365;

        if(isLeapYear()) {
            numberOfDays = 366;
        }

        return numberOfDays;
    }


    private String getMonthName(int month) {

        String monthName = "January";

        switch(month) {
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }

        return monthName;
    }
}