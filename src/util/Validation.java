package util;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Validation {

    private static final Scanner SC = new Scanner(System.in);

    public static int inputInt(String mess) {
        int result = 0;
        try {
            System.out.print(mess);
            result = Integer.parseInt(SC.nextLine());
        } catch (Exception e) {
            result = 0;
            System.out.println("Has something wrong");
        }
        return result;
    }

    public static int inputInt(String mess, int defaultValue) {
        int result = 0;
        try {
            System.out.print(mess);
            result = Integer.parseInt(SC.nextLine());
        } catch (Exception e) {
            result = defaultValue;
        }
        return result;
    }

    public static float inputFloat(String mess) {
        float result = 0;
        try {
            System.out.print(mess);
            result = Float.parseFloat(SC.nextLine());
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return result;
    }
    
    public static float inputFloat(String mess, float defaultValue) {
        float result = 0;
        try {
            System.out.print(mess);
            result = Float.parseFloat(SC.nextLine());
        } catch (Exception e) {
            result = defaultValue;
        }
        return result;
    }

    public static double inputDouble(String mess) {
        double result = 0;
        try {
            System.out.print(mess);

            String input = SC.nextLine();
            if (input.contains(".")) {
                result = Double.parseDouble(input);
            } else {
                result = Double.parseDouble(input + ".0");
            }
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return result;
    }

    public static int inputWithRange(String mess, int a, int b) {
        int max = 0;
        int min = 0;
        int result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        try {
            do {
                System.out.print(mess);
                result = Integer.parseInt(SC.nextLine());
                if (result < min || result > max) {
                    System.out.println("Not meet the conditions");
                } else {
                    break;
                }
            } while (result < min || result > max);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static float inputWithRange(String mess, float a, float b) {
        float max = 0;
        float min = 0;
        float result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        try {
            do {
                System.out.print(mess);
                result = Float.parseFloat(SC.nextLine());
                if (result < min || result > max) {
                    System.out.println("Not meet the conditions");
                } else {
                    break;
                }
            } while (result < min || result > max);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static double inputWithRange(String mess, double a, double b) {
        double max = 0;
        double min = 0;
        double result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        try {
            do {
                System.out.print(mess);
                result = Double.parseDouble(SC.nextLine());
                if (result < min || result > max) {
                    System.out.println("Not meet the conditions");
                } else {
                    break;
                }
            } while (result < min || result > max);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static float inputWithMin(String mess, float min) {
        float result = 0;
        try {
            do {
                System.out.print(mess);
                result = Float.parseFloat(SC.nextLine());
                if (result > min) {
                    break;
                } else {
                    System.out.println("Number more than " + min);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static int inputWithMin(String mess, int min) {
        int result = 0;
        try {
            do {
                System.out.print(mess);
                result = Integer.parseInt(SC.nextLine());
                if (result > min) {
                    break;
                } else {
                    System.out.println("Number more than " + min);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return result;
    }

    public static double inputWithMin(String mess, double min) {
        double result = 0;
        try {
            do {
                System.out.print(mess);
                result = Double.parseDouble(SC.nextLine());
                if (result > min) {
                    break;
                } else {
                    System.out.println("Number more than " + min);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return result;
    }

    public static String inputString(String mess) {
        String result = "";
        try {
            System.out.print(mess);
            result = SC.nextLine();
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static String inputString(String mess, String defaultValue) {
        String result = "";
        try {
            System.out.print(mess);
            result = SC.nextLine();
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        if (result.isBlank() || result.isEmpty()) {
            return defaultValue;
        }
        return result;
    }

    public static String inputStringWithLength(String mess, int length) {
        String result = "";
        try {
            do {
                System.out.print(mess);
                result = SC.nextLine();
                if (result.length() <= length && result.length() > 0) {
                    break;
                } else {
                    System.out.println("String has length is not valid");
                }
            } while (result.length() > length || result.length() == 0);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static String inputStringNonBlank(String mess) {
        String result = "";
        try {
            do {
                System.out.print(mess);
                result = SC.nextLine();
                if (result.length() > 0) {
                    break;
                } else {
                    System.out.println("String has length is not valid");
                }
            } while (result.length() == 0);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static String inputStringWithFormat(String mess, String pattern) {
        String result = "";
        try {
            while (true) {
                System.out.print(mess);
                result = SC.nextLine();
                boolean isMatch = Pattern.matches(pattern, result.trim());
                if (isMatch) {
                    break;
                } else {
                    System.out.println("String is wrong format");
                }
            }
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static Boolean inputYesNo(String mess) {
        boolean result = false;
        try {
            System.out.print(mess);
            String input = SC.nextLine();

            if (input.contains("y") || input.contains("Y")) {
                result = true;
            } else if (input.contains("n") || input.contains("N")) {
                result = false;
            } else {
                System.out.println("Yes no question should input yes no");
                inputYesNo(mess);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Has some thing wrong");
        }
        return result;
    }

    public static Boolean inputYesNo(String mess, boolean defaultValue) {
        boolean result = false;
        try {
            System.out.print(mess);
            String input = SC.nextLine();

            if (input.contains("y") || input.contains("Y")) {
                result = true;
            } else if (input.contains("n") || input.contains("N")) {
                result = false;
            } else if (input.isBlank() || input.isEmpty()) {
                return defaultValue;
            } else {
                System.out.println("Yes no question should input yes no");
                inputYesNo(mess);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Has some thing wrong");
        }
        return result;
    }

    //sử dụng để kiểm tra chuỗi đó có thể convert sang date không và trả về 1 Date 
    // dd/MM/yyyy 
    public static Date isFormatDate(String strDate, String dateFormat) throws ParseException {
        final String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        boolean statusFormat = Pattern.matches(regex, strDate);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        try {
            while (!statusFormat) {
                System.out.println("Wrong format Date!!!");
                strDate = Validation.inputStringWithFormat("String of Date", regex);
                break;
            }
            if (statusFormat) {
                date = formatter.parse(strDate);
            }
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return date;
    }

    // sử dụng để convert String to Date với format dd-MM-yyyy HH:mm:ss
    public static Date isFormatDateHasTime(String strDate) throws ParseException {
        final String regexDay = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        final String regexTime = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        String[] dayAndTime = strDate.split(" ");
        boolean statusFormatDay = Pattern.matches(regexDay, dayAndTime[0].trim());
        boolean statusFormatTime = Pattern.matches(regexTime, dayAndTime[1].trim());
        boolean statusFormat = false;
        if (statusFormatTime && statusFormatDay) {
            statusFormat = true;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        try {
            if (!statusFormat) {
                System.out.println("String can not convert to Date");
            } else {
                date = formatter.parse(strDate);
            }
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return date;
    }

    public static boolean checkYearValid(int year) {
        //get current year, month, day
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (year > currentYear || year < 1900) {
            return false;
        }
        return true;
    }

    public static boolean checkMonthValid(int month) {
        if (month > 12 || month < 1) {
            return false;
        }
        return true;
    }

    public static boolean IsNamNhuan(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDayValid(int year, int month, int day) {

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            // day 31
            if (day > 31 || day <= 0) {
                return false;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            //day 30
            if (day > 30 || day <= 0) {
                return false;
            }
        } else if (month == 2) {

            if (IsNamNhuan(year)) {
                if (day > 29 || day <= 0) {
                    return false;
                }
            } else {
                if (day > 28 | day <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Date inputDate() {

        int day, month, year;
        String dateFormat = "\\d{2}-\\d{2}-\\d{4}";
        String datePattern = "dd-MM-yyyy";
        Scanner sc = new Scanner(System.in);
        Date date = null;
        String data = inputString("Input date(dd-MM-yyyy): ");
        if (data.matches(dateFormat)) {
            try {
                //cắt chuỗi 06-10-2021 theo dấu - , có thể thay đổi bằng dấu / (tùy theo format)
                StringTokenizer st = new StringTokenizer(data, "-");
                day = Integer.parseInt(st.nextToken());
                month = Integer.parseInt(st.nextToken());
                year = Integer.parseInt(st.nextToken());
                if (checkDayValid(year, month, day) == true) {
                    date = isFormatDate(data, datePattern);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("DateFormat invalid.");
            return inputDate();
        }
        return date;
    }

    //input date with default value
    public static Date inputDate(Date defaultDate) {
        String datePattern = "dd-MM-yyyy";
        int day, month, year;
        String dateFormat = "\\d{2}-\\d{2}-\\d{4}";
        Scanner sc = new Scanner(System.in);
        Date date = null;
        String data = inputString("Input date(" + datePattern + "): ");
        if (data.matches(dateFormat)) {
            try {
                //cắt chuỗi 06-10-2021 theo dấu - , có thể thay đổi bằng dấu / (tùy theo format)
                StringTokenizer st = new StringTokenizer(data, "-");
                day = Integer.parseInt(st.nextToken());
                month = Integer.parseInt(st.nextToken());
                year = Integer.parseInt(st.nextToken());
                if (checkDayValid(year, month, day) == true) {
                    date = isFormatDate(data, datePattern);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            date = defaultDate;
        }
        return date;
    }
}

// updated: 13/4/2022
