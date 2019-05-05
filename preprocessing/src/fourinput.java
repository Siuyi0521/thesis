import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fourinput{
	public void fourinput() throws IOException{
		for(int m = 1 ; m < 5754 ; m++) {
			String line;
			String[] tempArray = new String[16];
			FileReader fr = new FileReader("Geolife_second_category_sequence_Input/all/"+m+".txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter category = new FileWriter("Geolife_second_category_sequence_Input/category/"+m+".txt");
			FileWriter timezone = new FileWriter("Geolife_second_category_sequence_Input/timezone/"+m+".txt");
			FileWriter staytime = new FileWriter("Geolife_second_category_sequence_Input/staytime/"+m+".txt");
			FileWriter passtime = new FileWriter("Geolife_second_category_sequence_Input/passtime/"+m+".txt");
			while((line = br.readLine()) != null) {
				tempArray = line.split(" ");
				category.write(tempArray[0]+" ");
				category.write(tempArray[4]+" ");
				category.write(tempArray[8]+" ");
				category.write(tempArray[12]+" ");
				timezone.write(tempArray[1]+" ");
				timezone.write(tempArray[5]+" ");
				timezone.write(tempArray[9]+" ");
				timezone.write(tempArray[13]+" ");
				staytime.write(tempArray[2]+" ");
				staytime.write(tempArray[6]+" ");
				staytime.write(tempArray[10]+" ");
				staytime.write(tempArray[14]+" ");
				passtime.write(tempArray[3]+" ");
				passtime.write(tempArray[7]+" ");
				passtime.write(tempArray[11]+" ");
				passtime.write(tempArray[15]+" ");
			}
			category.close();
			timezone.close();
			staytime.close();
			passtime.close();
		}
	}
}