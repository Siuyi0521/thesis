import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class userSimilarity{
	public void userSimilarity() throws IOException{
		float[][] UserSimilarity = new float[91][91];
		FileWriter fw = new FileWriter("UserSimilarity.txt");
		for (int a = 0 ; a < 91 ; a++) {
			for (int b = 0; b < 91 ; b++) {
				File user_a = new File("Geolife_first_category_word2vec_input/user_onehot/"+a);
				String []a_list = user_a.list();
				File user_b = new File("Geolife_first_category_word2vec_input/user_onehot/"+b);
				String []b_list = user_b.list();
				String line1;
				String line2;
				String[] tempArray1 = new String[72];
				String[] tempArray2 = new String[72];
				int[] A = new int[72];
				int[] B = new int[72];
				float SequenceSimilarity = 0;
				
				for (int m = 0 ; m < a_list.length ; m++) {
					for(int n = 0 ; n <b_list.length ; n++) {
						
						FileReader fr1 = new FileReader("Geolife_first_category_word2vec_input/user_onehot/"+a+"/"+a_list[m]);
						BufferedReader br1 = new BufferedReader(fr1);
						FileReader fr2 = new FileReader("Geolife_first_category_word2vec_input/user_onehot/"+b+"/"+b_list[n]);
						BufferedReader br2 = new BufferedReader(fr2);
						line1 = br1.readLine();
						tempArray1 = line1.split(" ");
						line2 = br2.readLine();
						tempArray2 = line2.split(" ");
						for (int c = 0 ; c < 72 ; c++) {
							A[c] = Integer.parseInt(tempArray1[c]);
							B[c] = Integer.parseInt(tempArray2[c]);
						}
						SequenceSimilarity += cosineSimilarity(A , B);
						//System.out.println(cosineSimilarity(A , B));
					}
				}
				UserSimilarity[a][b] = SequenceSimilarity / (a_list.length * b_list.length);
				SequenceSimilarity = 0;
				System.out.println(UserSimilarity[a][b]);
			}
		}
		for(int i = 0 ; i < 91 ; i++) {
			for(int j = 0 ; j < 91 ; j++) {
				//String UserSimilarityS = String.valueOf(UserSimilarity[i][j]);
				fw.write(String.valueOf(UserSimilarity[i][j])+", ");
			}
			fw.write("\r\n");
		}
		fw.close();
		//System.out.print(UserSimilarity);
	}
	public float cosineSimilarity(int[] A, int[] B) {
    	if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
    		return 2;
    	}

    	float sumProduct = 0;
    	float sumASq = 16;
    	float sumBSq = 16;
    	for (int i = 0; i < A.length; i++) {
    		sumProduct += A[i]*B[i];
    		//sumASq = 16;
    		//sumBSq = 16;
    	}
    	if (sumASq == 0 && sumBSq == 0) {
    		return 2;
    	}
    	return (float) (sumProduct / (Math.sqrt(sumASq) * Math.sqrt(sumBSq)));
    }
}