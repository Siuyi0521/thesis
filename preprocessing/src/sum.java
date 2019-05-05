import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class sum{
	public void sum() throws IOException{
		String line;
		FileReader fr = new FileReader("Geolife_first_category_Overview.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> category = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			category.add(line);
		}
		
		String file;
		String[] tempArray = new String[3];
		double categorycount[] = new double[18];
		for(int c = 0 ; c < 18 ; c++) {
			categorycount[c] = 0;
		}
		for (int m = 0 ; m < 1560 ; m++) {
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			FileReader fr2 = new FileReader("OSM_token_new/all/"+file+"token.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			while((line = br2.readLine()) != null) {
				tempArray = line.split(" ");
				for (int i = 0 ; i < 18 ; i++) {
					if(category.get(i).contains(tempArray[0])) {
						categorycount[i]++;
					}
				}
			}
		}
		FileWriter fw = new FileWriter("OSM_category_count.txt");
		for(int g = 0 ; g < 18 ; g++) {
			//fw.write(category.get(g)+":");
			//fw.write(categorycount[g]);
			//fw.write("\r\n");
			System.out.println(category.get(g)+"	"+(categorycount[g]/20688)*100);
		}
		fw.close();
	}
}