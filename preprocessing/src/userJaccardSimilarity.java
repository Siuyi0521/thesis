import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class userJaccardSimilarity{
	public void userJaccardSimilarity() throws IOException{
		float[][] UserSimilarity = new float[386][386];
		FileWriter fw = new FileWriter("OSM_User_Jaccard_Similarity/User_Jaccard_Similarity_SL=9.txt");
		/*for (int a = 0 ; a < 91 ; a++) {
			for (int b = 0; b < 91 ; b++) {
				FileReader user_a = new FileReader("Geolife_User_transitionPattern/2times/"+a+".txt");
				BufferedReader br1 = new BufferedReader(user_a);
				FileReader user_b = new FileReader("Geolife_User_transitionPattern/2times/"+b+".txt");
				BufferedReader br2 = new BufferedReader(user_b);
				ArrayList<String> Match = new ArrayList<String>();
				ArrayList<String> All = new ArrayList<String>();
				String line1;
				String line2;
				while((line1 = br1.readLine())!=null) {
					All.add(line1);
				}
				while((line2 = br2.readLine())!=null) {
					if(All.contains(line2)) {
						Match.add(line2);
					}else {
						All.add(line2);
					}
				}
				float Matchf = Match.size();
				float Allf = All.size();
				float Similarity = Matchf/Allf;
				UserSimilarity[a][b] =  Similarity;
			}
		}*/
		/*for (int a = 0 ; a < 112 ; a++) {
			for (int b = 0; b < 112 ; b++) {
				FileReader user_a = new FileReader("Geolife_User_transitionPattern/sequenceLength=3/"+a+".txt");
				BufferedReader br1 = new BufferedReader(user_a);
				FileReader user_b = new FileReader("Geolife_User_transitionPattern/sequenceLength=3/"+b+".txt");
				BufferedReader br2 = new BufferedReader(user_b);
				ArrayList<String> Match = new ArrayList<String>();
				ArrayList<String> All = new ArrayList<String>();
				ArrayList<String> All2 = new ArrayList<String>();
				String line1;
				String line2;
				while((line1 = br1.readLine())!=null) {
					All.add(line1);
					All2.add(line1);
				}
				while((line2 = br2.readLine())!=null) {
					All2.add(line2);
					for(int i = 0 ; i < All.size() ; i++) {
						if(All.get(i).equals(line2)) {
							Match.add(line2);
							All.remove(i);
							break;
						}
					}
				}
				float Matchf = Match.size();
				float Allf = All.size();
				float All2f = All2.size();
				float Similarity = Matchf/All2f;
				UserSimilarity[a][b] =  Similarity;
			}
		}
		for(int i = 0 ; i < 112 ; i++) {
			for(int j = 0 ; j < 112 ; j++) {
				//String UserSimilarityS = String.valueOf(UserSimilarity[i][j]);
				fw.write(String.valueOf(UserSimilarity[i][j])+", ");
			}
			fw.write("\r\n");
		}
		fw.close();*/
		for (int a = 0 ; a < 386 ; a++) {
			for (int b = 0; b < 386 ; b++) {
				FileReader user_a = new FileReader("OSM_User_transitionPattern/sequenceLength=9/"+a+".txt");
				BufferedReader br1 = new BufferedReader(user_a);
				FileReader user_b = new FileReader("OSM_User_transitionPattern/sequenceLength=9/"+b+".txt");
				BufferedReader br2 = new BufferedReader(user_b);
				ArrayList<String> Match = new ArrayList<String>();
				ArrayList<String> All = new ArrayList<String>();
				ArrayList<String> All2 = new ArrayList<String>();
				String line1;
				String line2;
				while((line1 = br1.readLine())!=null) {
					All.add(line1);
					All2.add(line1);
				}
				while((line2 = br2.readLine())!=null) {
					All.add(line2);
					for(int i = 0 ; i < All2.size() ; i++) {
						if(All2.get(i).equals(line2)) {
							Match.add(line2);
							All2.remove(i);
							break;
						}
					}
				}
				for (int c = 0 ; c < Match.size() ; c++) {
					for(int d = 0 ; d < All.size(); d++) {
						if(All.get(d).equals(Match.get(c))) {
							All.remove(d);
							break;
						}
					}
				}
				float Matchf = Match.size();
				float Allf = All.size();
				float All2f = All2.size();
				float Similarity = Matchf/Allf;
				UserSimilarity[a][b] =  Similarity;
			}
		}
		for(int i = 0 ; i < 386 ; i++) {
			for(int j = 0 ; j < 386 ; j++) {
				//String UserSimilarityS = String.valueOf(UserSimilarity[i][j]);
				fw.write(String.valueOf(UserSimilarity[i][j])+", ");
			}
			fw.write("\r\n");
		}
		fw.close();
	}	
}