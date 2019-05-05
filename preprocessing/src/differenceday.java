import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class differenceday{
	/*public static void main(String[] args) 
    {
        String dateStr = "20080101";
        String dateStr2 = "20100102";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
        try 
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);
            
            //System.out.println("两个日期的差距：" + differentDays(date,date2));
            System.out.println("两个日期的差距：" + differentDaysByMillisecond(date,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/
	
	 public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
}