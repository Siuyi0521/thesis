import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class label{
	public void labeldata() throws IOException{
		/*String file;
		for(int m = 1 ; m < 5754 ; m++) {
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			String line;
			String[] tempArray = new String[4];
			FileReader fr = new FileReader("Geolife_second_category_sequence_Output/all/"+m+".txt");
			BufferedReader br = new BufferedReader(fr);
			//ArrayList<String> sequence = new ArrayList<String>();
			while((line=br.readLine())!=null) {
				tempArray = line.split(" ");
				FileWriter fw = new FileWriter("Geolife_second_category_sequence_Output/allfinish/"+m+".txt");
				fw.write(tempArray[0]);
				
				fw.close();
			}
		}*/
		String line;
		String line2;
		String[] tempArray = new String[2];
		FileReader fr = new FileReader("OSM_category_Overview.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> old_category = new ArrayList<String>();
		ArrayList<String> new_category = new ArrayList<String>();
		while((line=br.readLine())!=null){
			tempArray = line.split(" ");
			old_category.add(tempArray[0]);
			new_category.add(tempArray[1]);
		}
		File userid = new File("OSM_token/all");
		String s[] = userid.list();
		//FileWriter fw = new FileWriter("Geolife_second_category_sequence_Output/Geolife_second_category_label.txt");
		//FileWriter fw = new FileWriter("Geolife_second_category_number.txt");
		for(int m = 0 ; m < 1560; m++) {
			String[] tempArray2 = new String[3];
			FileReader fr2 = new FileReader("OSM_token/all/"+s[m]);
			BufferedReader br2 = new BufferedReader(fr2);
			//FileWriter fw = new FileWriter("OSM_token_new/all/"+s[m]);
			ArrayList<String> token = new ArrayList<String>();
			//ArrayList<String> sequence = new ArrayList<String>();
			int count = 0 ;
			while((line2=br2.readLine())!=null) {
				tempArray2 = line2.split(" ");
				count++;
				for(int i = 0; i < 602 ; i++) {
					if(tempArray2[0].equals(old_category.get(i))) { 
						token.add(new_category.get(i));
						token.add(tempArray2[1]);
						token.add(tempArray2[2]);
						//fw.write(new_category.get(i)+" "+tempArray2[1]+" "+tempArray2[2]);
						//fw.write("\r\n");
						//break;
					}
				}
			}
			//System.out.println(token);
			if(count > 0) {
				FileWriter fw = new FileWriter("OSM_token_new/all/"+s[m]);
				for(int a = 0 ; a < token.size() ; a += 3) {
					fw.write(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					//fw.write(token.get(a));
					System.out.println(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					fw.write("\r\n");
				}
				fw.close();
			}
			if(count > 2) {
				FileWriter fw2 = new FileWriter("OSM_token_new/sequenceLength=3/"+s[m]);
				for(int a = 0 ; a < token.size() ; a += 3) {
					fw2.write(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					fw2.write("\r\n");
				}
				fw2.close();
			}
			if(count > 4) {
				FileWriter fw3 = new FileWriter("OSM_token_new/sequenceLength=5/"+s[m]);
				for(int a = 0 ; a < token.size() ; a += 3) {
					fw3.write(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					fw3.write("\r\n");
				}
				fw3.close();
			}
			if(count > 6) {
				FileWriter fw4 = new FileWriter("OSM_token_new/sequenceLength=7/"+s[m]);
				for(int a = 0 ; a < token.size() ; a += 3) {
					fw4.write(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					fw4.write("\r\n");
				}
				fw4.close();
			}
			if(count > 8) {
				FileWriter fw5 = new FileWriter("OSM_token_new/sequenceLength=9/"+s[m]);
				for(int a = 0 ; a < token.size() ; a += 3) {
					fw5.write(token.get(a)+" "+token.get(a+1)+" "+token.get(a+2));
					fw5.write("\r\n");
				}
				fw5.close();
			}
			//fw.close();
			fr2.close();
			br2.close();
		}
	}
}