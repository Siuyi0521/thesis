import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class clustering{
	public void clustering() throws IOException{
		FileReader fr = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/AgglomerativeClustering/OSM/User_Jaccard_11groups_index_SL=9.txt");
		//FileReader fr = new FileReader("hierachicalCliustering.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		int userid;
		String path = "OSM_sequence_Output/sequenceLength=9/user/";
		String fwpath = "OSM_sequence_Output/sequenceLength=9/user_groups/3/";
		String ID;
		String[] group = new String[164];
		line = br.readLine();
		line = br.readLine();
		line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		//line = line.replace("[", "");
		//line = line.replaceAll(",", "");
		//line = line.replace("]", "");
		group = line.split(" ");
		//File old_userid = new File(path);
		//String[] old_id = old_userid.list();
		int k = 1;
		for(int i = 0 ; i < 164; i++) {
			//File IDD = new File("Geolife_second_category_sequence_Output/group/1/"+i);
			//IDD.mkdirs();
			File sequenceID = new File(path+group[i]);
			//System.out.print(old_id[Integer.parseInt(group[i])]+" ");
			String[] s = sequenceID.list();
			for(int a = 0 ; a < s.length ; a++) {
				FileReader fr2 = new FileReader(path+group[i]+"/"+s[a]);
				BufferedReader br2 = new BufferedReader(fr2);
				FileWriter fw = new FileWriter(fwpath+k+".txt");
				k++;
				while((line = br2.readLine())!=null) {
					fw.write(line);
				}
				fw.close();
			}
		}
		
	}
}