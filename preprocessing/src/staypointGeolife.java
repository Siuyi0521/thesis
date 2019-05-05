import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class staypointGeolife{
	public void staypoint() throws IOException{
		String file;
		int r = 0;
		for(int m = 0 ; m < 182 ; m++){
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			File userid = new File("extractGeolife\\" + file );
			ArrayList<String> flieList = new ArrayList<String>();
			if (userid.isDirectory()){
				//File createfile = new File("staypointGeolife\\" + file );
				//createfile.mkdir();
				FileWriter fw = new FileWriter("staypointGeolife\\"+file+"staypoint.txt",false);
				String []s = userid.list();
				for(int a = 0 ; a < s.length ; a++){
					flieList.add(s[a]);
					FileReader fr = new FileReader("extractGeolife\\"+file+"\\"+s[a]);
					BufferedReader br = new BufferedReader(fr);
					ArrayList<String> myList = new ArrayList<String>();
					String[] tempArray1 = new String[5];
					String[] tempArray2 = new String[3];
					String line;
					while((line = br.readLine()) != null){
						tempArray1 = line.split(" ");
						tempArray2 = tempArray1[4].split(":");
						myList.add(tempArray1[0]);
						myList.add(tempArray1[1]);
						myList.add(tempArray1[2]);
						myList.add(tempArray1[3]);
						//myList.add(tempArray1[4]);
						myList.add(tempArray2[0]);
						myList.add(tempArray2[1]);
						myList.add(tempArray2[2]);
					}
					int k = myList.size()/7;
					int count = 0;
					double[][] trans_array = new double[k][7];
			
					for(int x = 0 ; x < myList.size()/7 ; x++) {
						for(int y = 0 ; y < 7 ; y++) {
							trans_array[x][y] = Double.parseDouble((String)myList.get(count));
							count++;
						}
					}
					
					ArrayList<Double> StayPoint = new ArrayList<Double>();
					int i = 0,o = 0;
					while(i < k) {
						int j = i + 1;
						while(j < k) {
							int p = 1;
							double lat = trans_array[i][0];
							double lng = trans_array[i][1];
							double lat1 = trans_array[i][0];
							double lng1 = trans_array[i][1];
							double lat2 = trans_array[j][0];
							double lng2 = trans_array[j][1];
					
							distance dis = new distance();
							double Distance = dis.GetDistance(lat1,lng1,lat2,lng2);
							if(Distance > 20) {
								double dTime =  trans_array[j-1][5] - trans_array[i][5];
								if (dTime < 0){
									dTime = trans_array[j-1][5] - trans_array[i][5] + 60;
								}
								if (dTime > 10) {
									/*Double Atimeh = trans_array[i][3];
									Double Atimem = trans_array[i][4];
									Double Atimes = trans_array[i][5];
									Double Ltimeh = trans_array[j-1][3];
									Double Ltimem = trans_array[j-1][4];
									Double Ltimes = trans_array[j-1][5];*/
									lat = lat / p;
									lng = lng / p;
									
									StayPoint.add(lat);
									StayPoint.add(lng);
									/*StayPoint.add(Atimeh);
									StayPoint.add(Atimem);
									StayPoint.add(Atimes);
									StayPoint.add(Ltimeh);
									StayPoint.add(Ltimem);
									StayPoint.add(Ltimes);*/
									fw.write(StayPoint.get(o) + " ");
									fw.write(StayPoint.get(o+1) + " ");
									fw.write((int)trans_array[i][3] + " ");
									fw.write((int)trans_array[i][4] + ":");
									fw.write((int)trans_array[i][5] + ":");
									fw.write((int)trans_array[i][6] + " ");
									fw.write((int)trans_array[j-1][4] + ":");
									fw.write((int)trans_array[j-1][5] + ":");
									fw.write((int)trans_array[j-1][6] + " ");
									fw.write("\r\n");
									o += 2;
									r++;
									break;
								}
								else {
									break;
								}
							}
							else {
								lat = lat + lat2;
								lng = lng + lng2;
								j = j+1;
								p++;
							}
						}
						i = j;
					}
					/*for(i = 0 ; i < StayPoint.size() ; i+=8) {
						fw.write(StayPoint.get(i) + " ");
						fw.write(StayPoint.get(i+1) + " ");
						fw.write((int)trans_array[i][3] + " ");
						fw.write((int)trans_array[i][4] + " ");
						fw.write((int)trans_array[i][5] + " ");
						fw.write((int)trans_array[j-1][3] + " ");
						fw.write((int)trans_array[j-1][3] + " ");
						fw.write((int)trans_array[j-1][3] + " ");
						fw.write("\r\n");
					}*/
				}
				fw.close();
			}
		}
		System.out.print(r);
	}
}