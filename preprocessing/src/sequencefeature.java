import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class sequencefeature{
	public void sequencefeature() throws IOException{
		FileReader fr = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/_sequenceLength=9/Geolife_second_group1_onehot_Input_SP=9.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/_sequenceLength=9/Geolife_second_group1_onehot_CTS_Input_SP=9.txt");
		
		String line;
		String[] tempArray = new String[157*8];
		while((line = br.readLine())!=null) {
			tempArray = line.split(" ");
			for(int i = 0 ; i < 8 ; i++) {
				int b = 157*i;
				for(int a = b ; a < b+148 ; a++) {
					fw.write(tempArray[a]+" ");
				}
			}
			fw.write("\r\n");
		}
		fw.close();
	}
}