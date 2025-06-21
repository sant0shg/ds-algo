/**
Find all sundays between two dates
Conditions
- Dont use date functions
**/

public class Main {
    public static void main(String[] args) {
        (new Main()).run();
    }

    private void run() {
        int countOfSunday = 0;
        int tracker = 1;
        for(int y=2024;y<=2025;y++) {
            for(int m=0;m<=11;m++) {
                if(y==2024 && m == 0) {
                    tracker = 1;
                }else {
                    tracker = tracker + getRemainingDays(y,m) - 1;
                    if (tracker > 6) {
                        tracker = tracker%7;
                    }
                }
                if (tracker == 0) {
                    System.out.println(y + " " + m);
                    countOfSunday++;
                }

            }
        }
        System.out.println(countOfSunday);
    }

    private int getRemainingDays(int year, int month) {
        return getDaysInMonth(year, month)%7;
    }

    private int getDaysInMonth(int year, int month) {
        if(month == 0 || month == 2 || month == 4 || month == 6
        || month == 7 || month == 9 || month == 11) {
            return 31;
        } else if(month == 3 || month == 5 || month == 8
        || month == 10 ) {
            return 30;
        } else if(year%4 == 0 && month == 1) {
            return 29;
        } else if(year%4 != 0 && month == 1)  {
            return 28;
        }
        throw new RuntimeException("Error");
        
    }
}

