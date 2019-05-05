import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class poiAPI{
	public void poi() throws IOException{
		String file;
		for(int m = 140 ; m < 182 ; m++){
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			FileReader fr = new FileReader ("staypointGeolife\\"+file+"staypoint.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("labelGeolife\\"+file+"POIlabel.txt",false);
			String line;
			String[] tempArray = new String[5];
			ArrayList<String> myList = new ArrayList<String>();
			int i = 0;
			while((line = br.readLine()) != null) {		//Ū���ɮצs�Jmylist
				tempArray = line.split(" ");
				myList.add(tempArray[0]);			
				myList.add(tempArray[1]);			
				myList.add(tempArray[2]);			
				myList.add(tempArray[3]);
				myList.add(tempArray[4]);
								
				String url = "http://apis.map.qq.com/ws/geocoder/v1/?location="+myList.get(i)+","+myList.get(i+1)+"&key=OJHBZ-EKHCK-7BWJZ-AEUDT-3YQV6-P3F6T&get_poi=1";
				InputStream is = new URL(url).openStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is,"utf-8"));
				StringBuilder sb = new StringBuilder();
				int cp;
				while ((cp = rd.read()) != -1) {
					sb.append((char) cp);
				}
				JSONObject mainObj = null;
				JSONObject jObj = null;
				try {
					mainObj = new JSONObject(sb.toString());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			
				fw.write(myList.get(i) + " ");
				fw.write(myList.get(i+1) + " ");
				fw.write(myList.get(i+2) + " ");
				fw.write(myList.get(i+3) + " ");
				fw.write(myList.get(i+4) + " ");
				//fw.write("\r\n");
				i += 5;
		
				Object obj = null;
				Object title = null;
				Object category = null;
				Object lat = null;
				for(int p = 0 ; p <1; p++) {
					obj = mainObj.optJSONObject("result").optJSONArray("pois").optJSONObject(p);
					if(obj == null) {continue;}
					try {
						jObj = new JSONObject(obj.toString());
						title = jObj.opt("title");
						category = jObj.opt("category");
						lat = jObj.opt("location");
					} catch (JSONException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(results);
					fw.write(title + " ");
					fw.write(category + " ");
					fw.write("\r\n");
				}
				Thread thread = new Thread();
				thread.start();
				try {
					thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}fw.close();		
		}
		
	}
}