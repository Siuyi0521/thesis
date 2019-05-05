import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class POIlabelsubSequence{
	public void POIlabelsubSequence() throws IOException{
		String file;
		for(int m = 1591; m < 1876 ; m++) {
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			FileReader fr = new FileReader("OSMPOIcategory/"+file+"POIcategory.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("OSMPOIcategory1day/"+file+"POIlabel.txt"); 
			ArrayList<String> date = new ArrayList<String>();
			//ArrayList<String> datadata = new ArrayList<String>();
			int Stime;
			int Stimeh; 
			int Stimem;
			int i = 0;
			int distance;
			String line;
			String[] tempArray = new String[7];
			String[] Atime = new String[3];
			String[] Ltime = new String[3];
			while((line = br.readLine()) != null) {
				line = line.replaceAll("\\[" , "");
				line = line.replaceAll("\\]" , "");
				line = line.replaceAll("\\'" , "");
				tempArray = line.split(", ");
				distance = Integer.parseInt(tempArray[6]);
				if(distance <= 200) {
					date.add(tempArray[2]);
					if(i > 0) {
						/*double pastTime = Double.parseDouble(date.get(i))-Double.parseDouble(date.get(i-1));
						if( (pastTime >=0 && pastTime <=7) || (pastTime >= 71 && pastTime <=78) ) {
						}else {
							fw.write("\r\n");
						}*/
						if(date.get(i).equals(date.get(i-1))) {						
						}else {
							fw.write("\r\n");
						}
					}
					i++;
					
					Atime = tempArray[3].split(":");
					Ltime = tempArray[4].split(":");
					if(Integer.parseInt(Ltime[1])-Integer.parseInt(Atime[1]) >= 0){
						Stimem = Integer.parseInt(Ltime[1])-Integer.parseInt(Atime[1]); 
						Stimeh = Integer.parseInt(Ltime[0]);
					}else {
						Stimem = Integer.parseInt(Atime[1])-Integer.parseInt(Ltime[1]) + 60;
						Stimeh = Integer.parseInt(Ltime[0])-1;
					}
					if(Stimeh - Integer.parseInt(Atime[0]) >= 0) {
						Stimeh = Stimeh - Integer.parseInt(Atime[0]);
					}else {
						Stimeh = Integer.parseInt(Atime[0]) - Stimeh + 24;
					}
					Stime = Stimeh*60 + Stimem;
					
					tempArray[5] = tempArray[5].replaceAll(" ", "");
					
					fw.write(tempArray[0] + "  ");
					fw.write(tempArray[1] + "  ");
					fw.write(tempArray[2] + "  ");
					fw.write(tempArray[3] + "  ");
					fw.write(tempArray[4] + "  ");
					fw.write(Stime + "  ");
					fw.write(tempArray[5]);
					fw.write("\r\n");
				}				
			}fw.close();	
		}
	}
}