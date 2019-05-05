import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class clusteringLCS{
	public void clusteringLCS() throws IOException{
		FileReader fr = new FileReader("hierachicalCliustering_LCS.txt");
		//FileReader fr = new FileReader("hierachicalCliustering.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		int userid;
		String path = "OSM_sequence_Input/sequenceLength=9/all/";
		String fwpath = "OSM_sequence_Input/sequenceLength=9/sequence_groups/3/";
		String ID;
		String[] group = new String[312];
		line = br.readLine();
		line = br.readLine();
		line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		//line = br.readLine();
		line = line.replace("[", "");
		line = line.replaceAll(",", "");
		line = line.replace("]", "");
		group = line.split(" ");
		//File old_userid = new File(path);
		//String[] old_id = old_userid.list();
		int k = 1;
		for(int i = 0 ; i < 312; i++) {
			//File IDD = new File("Geolife_second_category_sequence_Output/group/1/"+i);
			//IDD.mkdirs();
			File sequenceID = new File(path+group[i]);
			//System.out.print(old_id[Integer.parseInt(group[i])]+" ");
			String[] s = sequenceID.list();
			for(int a = 0 ; a < 312 ; a++) {
				FileReader fr2 = new FileReader(path+group[a]+".txt");
				BufferedReader br2 = new BufferedReader(fr2);
				FileWriter fw = new FileWriter(fwpath+group[a]+".txt");
				k++;
				while((line = br2.readLine())!=null) {
					fw.write(line);
				}
				fw.close();
			}
		}
		
	}
}