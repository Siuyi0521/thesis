import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class token{
	public void token() throws IOException{
		String file;
		
		ArrayList<String> Category = new ArrayList<String>();
		File userid = new File("labelGeolifesubSequence1day");
		String s[] = userid.list();
		for(int m = 0 ; m < s.length ; m++) {
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			FileReader fr = new FileReader("labelGeolifesubSequence1day/"+s[m]);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("Geolife_token_second_category/"+file+"token.txt"); 
			ArrayList<String> date = new ArrayList<String>();
			
			String line;
			int stayTime;
			String[] tempArray = new String[7];
			String[] time = new String[3];
			String[] category = new String[2];
			int i = 0;
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					//fw.write("\r\n");
				}else {
					tempArray = line.split(" ");
					time = tempArray[3].split(":");
					category = tempArray[6].split(":");
					stayTime = Integer.parseInt(tempArray[5]);
					date.add(tempArray[2]);
					if(i > 0) {
						differenceday differenceday = new differenceday();
						//int days = differenceday.differentDaysByMillisecond(date1,date2);
						String datestr1 = date.get(i-1);
						String datestr2 = date.get(i);
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
						try 
				        {
				            Date date2 = format.parse(datestr2);
				            Date date1 = format.parse(datestr1);
				            
				            //System.out.println("两个日期的差距：" + differentDays(date,date2));
				            int days = differenceday.differentDaysByMillisecond(date1,date2);
				            if(days == 0) {
								fw.write("0day ");
							}else if (days == 1) {
								fw.write("1day ");
							}else if (days == 2) {
								fw.write("2day ");
							}else if (days == 3) {
								fw.write("3day ");
							}else if (days == 4) {
								fw.write("4day ");
							}else if (days == 5) {
								fw.write("5day ");
							}else if (days == 6) {
								fw.write("6day ");
							}else if (days == 7) {
								fw.write("7day ");
							}else {
								fw.write("up7day ");
							}
				            fw.write("\r\n");
				        } catch (ParseException e) {
				            e.printStackTrace();
				        }
					}
					i++;
					
					fw.write(category[1]+" ");
					if(Category.contains(category[1])) {
					}else {
						Category.add(category[1]);
					}
					fw.write(time[0]+" ");
					if(stayTime > 0 && stayTime <= 30) {
						fw.write("t1 ");
					}else if (stayTime > 30 && stayTime <= 60) {
						fw.write("t2 ");
					}else if (stayTime > 60 && stayTime <= 90) {
						fw.write("t3 ");
					}else if (stayTime > 90 && stayTime <= 120) {
						fw.write("t4 ");
					}else if (stayTime > 120 && stayTime <= 180) {
						fw.write("t5 ");
					}else {
						fw.write("t6 ");
					}
					
				}
			}fw.close();	
		}
		FileWriter fullcategory = new FileWriter("Geolife_second_category_Overview.txt");
		for(int a = 0 ; a < Category.size() ; a++) {
			fullcategory.write(Category.get(a));
			fullcategory.write("\r\n");
		}
		fullcategory.close();
	}
}