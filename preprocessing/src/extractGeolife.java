import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class extractGeolife{
	public void extract() throws IOException{
		String file;
		for(int m = 0 ; m < 182 ; m ++){
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			File userid = new File("Data\\"+file+"\\Trajectory");
			ArrayList<String> flieList = new ArrayList<String>();
			if (userid.isDirectory()){
				File createfile = new File("extractGeolife\\" + file );
				createfile.mkdir();
				//FileWriter extract = new FileWriter("")
				String []s = userid.list();
				for(int a = 0 ; a < s.length ; a++){
					flieList.add(s[a]);
					FileReader fr = new FileReader("Data\\"+file+"\\Trajectory\\"+s[a]);
					BufferedReader br = new BufferedReader(fr);
					FileWriter fw = new FileWriter("extractGeolife\\" + file+"\\"+s[a]+".txt",false);
					//FileWriter fw = new FileWriter("extract\\"+file+"\\"+s[a]+".txt",false);
					
					ArrayList<String> myList = new ArrayList<String>();
					String[] tempArray = new String[7];
					String line;
					int n = 7;          //�q��7��}�lŪ
					while( n -- > 1) {
						br.readLine();
					}
					int i = 0;
					while((line = br.readLine()) != null){
						line = line.replaceAll("-","");
						tempArray = line.split(",");
						myList.add(tempArray[0]);
						fw.write(myList.get(i)+ " ");
						myList.add(tempArray[1]);
						fw.write(myList.get(i+1)+ " ");
						myList.add(tempArray[4]);
						fw.write(myList.get(i+2)+ " ");
						//tempArray[5].replaceAll("-","");
						myList.add(tempArray[5]);
						fw.write(myList.get(i+3)+ " ");
						myList.add(tempArray[6]);
						fw.write(myList.get(i+4)+ " ");
						fw.write("\r\n");
						i += 5;
					}
					fw.close();
				}
			}	
		}
	}
}