import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class test{
	public void test() throws IOException{
//		FileReader fr = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/AgglomerativeClustering/OSM/User_Jaccard_11groups_index_SL=3.txt");
//		BufferedReader br = new BufferedReader(fr);
//		//FileWriter fw = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/test/User_Jaccard_4groups_index_SL=5.txt");
//		String line = null;
//		String path = "OSM_sequence_Input/sequenceLength=9/user/";
//		//String fwpath = "Geolife_second_category_sequence_Output/sequenceLength=5/user_groups/1/";
//		String ID;
//		String[] group = new String[24];
//		ArrayList<String> groupp = new ArrayList<String>();
//		int count = 0;
//		for (int m = 0 ; m < 6 ; m++) {
//			line = br.readLine();
//		}
//		//line = line.replace("[", "");
//		//line = line.replaceAll(",", "");
//		//line = line.replace("]", "");
//		group = line.split(" ");
//		File old_userid = new File(path);
//		String[] old_id = old_userid.list();
//		int k = 1;
//		for(int i = 0 ; i < 24 ; i++) {
//			groupp.add(group[i]);
//		}
//		for(int a = 0 ; a < 386 ; a++) {
//			if(groupp.contains(old_id[a])) {
//				System.out.print(old_id[a]+" ");
//				count++;
//			}
//		}
//		System.out.println();
//		System.out.println(count);
		FileReader fr1 = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/OSM_group1_onehot_CTS_Input_SP=9.txt");
		BufferedReader br1 = new BufferedReader(fr1);
		
		FileReader fr2 = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/OSM_group1_onehot_Output_SP=9.txt");
		BufferedReader br2 = new BufferedReader(fr2);
	
		FileReader fr3 = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/OSM_group3_onehot_CTS_Input_SP=9.txt");
		BufferedReader br3 = new BufferedReader(fr3);
		
		FileReader fr4 = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/OSM_group3_onehot_Output_SP=9.txt");
		BufferedReader br4 = new BufferedReader(fr4);
		
//		FileWriter fw1 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group1_CTS_Input_SP=9.txt");
//		FileWriter fw2 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group2_CTS_Input_SP=9.txt");
//		FileWriter fw3 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group3_CTS_Input_SP=9.txt");
		FileWriter fw4 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group4_CTS_Input_SP=9.txt");
		FileWriter fw5 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group5_CTS_Input_SP=9.txt");
		FileWriter fw6 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group6_CTS_Input_SP=9.txt");
		
//		FileWriter fw11 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group1_CTS_Output_SP=9.txt");
//		FileWriter fw22 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group2_CTS_Output_SP=9.txt");
//		FileWriter fw33 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group3_CTS_Output_SP=9.txt");
		FileWriter fw44 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group4_CTS_Output_SP=9.txt");
		FileWriter fw55 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group5_CTS_Output_SP=9.txt");
		FileWriter fw66 = new FileWriter("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group6_CTS_Output_SP=9.txt");
		
		String line1,line2;
		for(int i = 0 ; i < 6745 ; i++) {
			line1 = br1.readLine();
			line2 = br2.readLine();
			
			Random k = new Random();
			int n = k.nextInt(3)+1;
			if(n == 1) {
				fw4.write(line1+" ");
				fw4.write("\r\n");
				fw44.write(line2+" ");
				fw44.write("\r\n");
			}else if (n == 2) {
				fw5.write(line1+" ");
				fw5.write("\r\n");
				fw55.write(line2+" ");
				fw55.write("\r\n");
			}else {
				fw6.write(line1+" ");
				fw6.write("\r\n");
				fw66.write(line2+" ");
				fw66.write("\r\n");
			}
		}
//		fw1.close();
//		fw2.close();
//		fw3.close();
		fw4.close();
		fw5.close();
		fw6.close();
//		fw11.close();
//		fw22.close();
//		fw33.close();
		fw44.close();
		fw55.close();
		fw66.close();
		
	}
}