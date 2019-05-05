import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LCSSimilarity{
	public void LCSSimilarity() throws IOException{
		double[][] LCSSimilarity = new double[14149][14149];
		for(int a = 1 ; a < 14149 ; a++) {
			for(int b = 1 ; b < 14149 ; b++) {
				FileReader sequence_a = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+a+".txt");
				BufferedReader br1 = new BufferedReader(sequence_a);
				FileReader sequence_b = new FileReader("OSM_sequence_Input/sequenceLength=9/all/"+b+".txt");
				BufferedReader br2 = new BufferedReader(sequence_b);
				String line1, line2;
				String[] tempArray1 = new String[24];
				String[] tempArray2 = new String[24];
				
				String[] sequence1 = new String[9];
				String[] sequence2 = new String[9];
				line1 = br1.readLine();
				line2 = br2.readLine();
				
				tempArray1 = line1.split(" ");
				tempArray2 = line2.split(" ");
				sequence1[0] = "0";
				sequence2[0] = "0";
				for(int i = 1 ; i < 9 ; i++) {
					sequence1[i] = tempArray1[3*(i-1)];
					sequence2[i] = tempArray2[3*(i-1)];
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
				LCSSimilarity[a-1][b-1] = similarity[8][8]/8;
				System.out.println(LCSSimilarity[a-1][b-1]);
			}
		}
		FileWriter fw = new FileWriter("LCSSimilarity.txt");
		for(int i = 0 ; i < 14149 ; i++) {
			for(int j = 0 ; j < 14149 ; j++) {
				//String UserSimilarityS = String.valueOf(UserSimilarity[i][j]);
				fw.write(String.valueOf(LCSSimilarity[i][j])+", ");
			}
			fw.write("\r\n");
		}
		fw.close();
	}
}