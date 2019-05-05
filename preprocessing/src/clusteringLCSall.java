import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class clusteringLCSall{
	public void clusteringLCSall() throws IOException{
		//double[][] LCSSimilarity = new double[2000][2000];
		for(int a = 2001 ; a < 14150 ; a++) {
			FileReader sequence = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+a+".txt");
			FileReader sequence_output = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+a+".txt");
			BufferedReader br5 = new BufferedReader(sequence_output);
			String line1, line2, line3, line4, line5;
			line5 = br5.readLine();
			String[] tempArray1 = new String[24];
			String[] tempArray2 = new String[24];
			
			String[] sequence1 = new String[9];
			String[] sequence2 = new String[9];
			
			BufferedReader br1 = new BufferedReader(sequence);
			line1 = br1.readLine();
			
			tempArray1 = line1.split(" ");
			for(int i = 1 ; i < 9 ; i++) {
				sequence1[i] = tempArray1[3*(i-1)];
				//sequence2[i] = tempArray2[3*(i-1)];
			}
			
			File sequence_a = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/1");
			String[] sa = sequence_a.list();
			File sequence_b = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/2");
			String[] sb = sequence_b.list();
			File sequence_c = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/3");
			String[] sc = sequence_c.list();
			double group1 = 0;
			double group2 = 0;
			double group3 = 0;
			for(int b = 1 ; b < 1482 ; b++) {
				FileReader se_a = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+sa[b]);
				BufferedReader br2 = new BufferedReader(se_a);
				line2 = br2.readLine();
				tempArray2 = line1.split(" ");
				for(int i = 1 ; i < 9 ; i++) {
					sequence2[i] = tempArray2[3*(i-1)];
					//sequence2[i] = tempArray2[3*(i-1)];
				}
				double [][] similarity = new double[9][9];
				for(int m = 0 ; m < 9 ; m++) {
					similarity[m][0] = 0;
				}
				for(int n = 0 ; n < 9 ; n++) {
					similarity[0][n] = 0;
				}
				for(int m = 1 ; m <= 8 ; m++) {
					for(int n = 1 ; n <= 8 ; n++) {
						if(sequence1[m].equals(sequence2[n])) {
							similarity[m][n] = similarity[m-1][n-1] + 1;
						}else {
							similarity[m][n] = Math.max(similarity[m-1][n],similarity[m][n-1]);
						}
					}
				}
				/*if(group1 <= similarity[8][8]) {
					group1 = similarity[8][8];
				}*/
				group1 += similarity[8][8];
			}
			for(int b = 1 ; b < 183 ; b++) {
				FileReader se_b = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+sb[b]);
				BufferedReader br3 = new BufferedReader(se_b);
				line3 = br3.readLine();
				tempArray2 = line1.split(" ");
				for(int i = 1 ; i < 9 ; i++) {
					sequence2[i] = tempArray2[3*(i-1)];
					//sequence2[i] = tempArray2[3*(i-1)];
				}
				double [][] similarity = new double[9][9];
				for(int m = 0 ; m < 9 ; m++) {
					similarity[m][0] = 0;
				}
				for(int n = 0 ; n < 9 ; n++) {
					similarity[0][n] = 0;
				}
				for(int m = 1 ; m <= 8 ; m++) {
					for(int n = 1 ; n <= 8 ; n++) {
						if(sequence1[m].equals(sequence2[n])) {
							similarity[m][n] = similarity[m-1][n-1] + 1;
						}else {
							similarity[m][n] = Math.max(similarity[m-1][n],similarity[m][n-1]);
						}
					}
				}
				/*if(group2 <= similarity[8][8]) {
					group2 = similarity[8][8];
				}*/
				group2 += similarity[8][8];
			}
			for(int b = 1 ; b < 312 ; b++) {
				FileReader se_c = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+sc[b]);
				BufferedReader br4 = new BufferedReader(se_c);
				line4 = br4.readLine();
				tempArray2 = line1.split(" ");
				for(int i = 1 ; i < 9 ; i++) {
					sequence2[i] = tempArray2[3*(i-1)];
					//sequence2[i] = tempArray2[3*(i-1)];
				}
				double [][] similarity = new double[9][9];
				for(int m = 0 ; m < 9 ; m++) {
					similarity[m][0] = 0;
				}
				for(int n = 0 ; n < 9 ; n++) {
					similarity[0][n] = 0;
				}
				for(int m = 1 ; m <= 8 ; m++) {
					for(int n = 1 ; n <= 8 ; n++) {
						if(sequence1[m].equals(sequence2[n])) {
							similarity[m][n] = similarity[m-1][n-1] + 1;
						}else {
							similarity[m][n] = Math.max(similarity[m-1][n],similarity[m][n-1]);
						}
					}
				}
				/*if(group3 <= similarity[8][8]) {
					group3 = similarity[8][8];
				}*/
				group3 += similarity[8][8];
			}
			int k;
			File Group1 = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/1");
			String[] G1 = sequence_a.list();
			File Group2 = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/2");
			String[] G2 = sequence_b.list();
			File Group3 = new File("OSM_sequence_Input/sequenceLength=9/sequence_groups/3");
			String[] G3 = sequence_c.list();
//			if(group3/G3.length > group2/G2.length && group3/G3.length > group1/G1.length) {
//				k=3;
//			}else if (group2/G2.length > group3/G3.length && group2/G2.length > group1/G1.length) {
//				k=2;
//			}else if (group1/G1.length > group3/G3.length && group1/G1.length > group2/G2.length){
//				k=1;
//			}else {
				if(a%3 == 0) {
					k=1;
				}else if(a%3 == 1) {
					k=2;
				}else {
					k=3;
				}
//			}
			FileWriter fw = new FileWriter("OSM_sequence_Input/sequenceLength=9/sequence_allgroups/"+k+"/"+a+".txt");
			fw.write(line1);
			fw.close();
			FileWriter fw1 = new FileWriter("OSM_sequence_Output/sequenceLength=9/sequence_allgroups/"+k+"/"+a+".txt");
			fw1.write(line5);
			fw1.close();
		}
	}
}