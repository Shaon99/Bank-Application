import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IDGENARATOR {
    static int serial_no;
    static Calendar currentMonth;
    private static String numberFormat(int num){
        String result = "";
        int strLength = Integer.toString(num).length();
        for(int i=0; i<5-strLength; i++){
            result += "0";
        }
        result += num;
        return result;
    }
    public static String generate(){
        Calendar month = Calendar.getInstance();
        if (month.get(Calendar.MONTH) > currentMonth.get(Calendar.MONTH)){
            serial_no = 0;
            currentMonth = Calendar.getInstance();
        }
        serial_no++;
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-"+numberFormat(serial_no));
        return ft.format(now);
    }
}
