import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sequence{
	public void Sequence() throws IOException{
		String file;
		FileWriter fw1 = new FileWriter("time.txt",false);
		FileWriter fw2 = new FileWriter("stayTime.txt",false);
		for(int m = 0 ; m < 182 ; m++){
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			FileReader fr = new FileReader ("token\\"+file+"token.txt");
			BufferedReader br = new BufferedReader(fr);
			//ArrayList<String> myList = new ArrayList<String>();
			String line;
			String[] tempArray = new String[3];
			//String[] tempArray2 = new String[3];
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					fw1.write("\r\n");
					fw2.write("\r\n");
				}else {
					tempArray = line.split(" ");
					//tempArray2 = tempArray1[6].split(":");
					fw1.write(tempArray[1]+" ");
					fw2.write(tempArray[2]+" ");
					//System.out.println(tempArray2[1]);
					//myList.add(tempArray2[1]);
				}
			}
			fw1.write("\r\n");
			fw2.write("\r\n");
			fw1.flush();
			fw2.flush();
		}
		fw1.close();
		fw2.close();
		
		FileWriter fw3 = new FileWriter("timeSequence.txt",false);
		FileWriter fw4 = new FileWriter("stayTimeSequence.txt",false);
		FileReader fr2 = new FileReader ("time.txt");
		FileReader fr3 = new FileReader ("stayTime.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		BufferedReader br3 = new BufferedReader(fr3);
		String line;
		while((line = br2.readLine()) != null) {
			if(line.contains(" ")) {
				fw3.write(line);
				fw3.write("\r\n");
			}
		}
		while((line = br3.readLine()) != null) {
			if(line.contains(" ")) {
				fw4.write(line);
				fw4.write("\r\n");
			}
		}
		fw3.close();
		fw4.close();
	}
}