import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class onehot{
	public void onehot() throws IOException{
		String line;
		String path = "OSM_sequence_Output/sequenceLength=3/user_groups/1/";
		FileReader fr1 = new FileReader("Geolife_first_category_Overview.txt");
		BufferedReader br1 = new BufferedReader(fr1);
		FileReader fr2 = new FileReader("Geolife_second_timezone_Overview.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		FileReader fr3 = new FileReader("Geolife_second_staytime_Overview.txt");
		BufferedReader br3 = new BufferedReader(fr3);
		//FileReader fr4 = new FileReader("Geolife_second_passtime_Overview.txt");
		//BufferedReader br4 = new BufferedReader(fr4);
		ArrayList<String> category = new ArrayList<String>();
		ArrayList<String> timezone = new ArrayList<String>();
		ArrayList<String> staytime = new ArrayList<String>();
		//ArrayList<String> passtime = new ArrayList<String>();
		while((line=br1.readLine())!=null){
			category.add(line);
		}
		while((line=br2.readLine())!=null){
			timezone.add(line);
		}
		while((line=br3.readLine())!=null){
			staytime.add(line);
		}
		//while((line=br4.readLine())!=null){
		//	passtime.add(line);
		//}
		FileWriter fw = new FileWriter(path+"OSM_group1_time_Output_SP=3.txt");
		//File Path = new File(path+"3");
		//String s[] = Path.list();
		for(int m = 1 ; m < 8278 ; m++) {
			FileReader fr5 = new FileReader(path+m+".txt");
			BufferedReader br5 = new BufferedReader(fr5);
			String[] tempArray = new String[3];
			while((line = br5.readLine()) != null) {
				tempArray = line.split(" ");
				for(int count = 0 ; count < 1 ; count+=3) {
					/*for(int a = 0 ; a < 18 ; a++) {
						if(category.get(a).equals(tempArray[count])) {
							fw.write("1 ");
						}else {
							fw.write("0 ");
						}	
					}*/
					for(int a = 0 ; a < 24 ; a++) {
						if(timezone.get(a).equals(tempArray[count+1])) {
							fw.write("1 ");
						}else {
							fw.write("0 ");
						}	
					}
					/*for(int a = 0 ; a < 6 ; a++) {
						if(staytime.get(a).equals(tempArray[count+2])) {
							fw.write("1 ");
						}else {
							fw.write("0 ");
						}	
					}*/
					/*for(int a = 0 ; a < 9 ; a++) {
						if(passtime.get(a).equals(tempArray[count+3])) {
							fw.write("1 ");
						}else {
							fw.write("0 ");
						}	
					}*/
				}
			}
			fw.write("\r\n");
		}
		fw.close();
		/*File user = new File("Geolife_first_category_word2vec_input/user");
		String []s = user.list();
		for(int i = 0 ; i < 91 ; i++) {
			File sequence = new File("Geolife_first_category_word2vec_input/user/"+s[i]);
			String []se = sequence.list();
			File createfile = new File("Geolife_first_category_word2vec_input/user_onehot/" + i);
			createfile.mkdir(); 
			for (int m = 0 ; m < se.length ; m++) {
				FileReader fr5 = new FileReader("Geolife_first_category_word2vec_input/user/"+s[i]+"/"+se[m]);
				BufferedReader br5 = new BufferedReader(fr5);
				FileWriter fw5 = new FileWriter("Geolife_first_category_word2vec_input/user_onehot/"+i+"/"+m+".txt");
				String[] tempArray = new String[4];
				while ((line = br5.readLine()) != null) {
					tempArray = line.split(" ");
					for (int k = 0 ; k < 4 ; k++) {
						for(int a = 0 ; a < 18 ; a++) {
							if(category.get(a).equals(tempArray[k])) {
								fw5.write("1 ");
							}else {
								fw5.write("0 ");
							}	
						}
					}	
				}
				fw5.close();
			}
		}*/
	}
}