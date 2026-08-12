class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFromStart(date1) - daysFromStart(date2));
    }
    private int daysFromStart(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        int total = 0;
        for (int y = 1; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            total += days[m - 1];

            if (m == 2 && isLeapYear(year)) {
                total++;
            }
        }
        total += day;

        return total;
    }
    private boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
