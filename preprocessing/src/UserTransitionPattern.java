import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserTransitionPattern{
	public void UserTransitionPattern() throws IOException{
		String line;
		File user = new File("OSM_token_new/sequenceLength=9");
		String[] s = user.list();
		for(int i = 0 ; i < 386 ; i++) {
			//File U = new File("Geolife_User_transitionPattern/"+i);
			//U.mkdir();
			FileWriter fw = new FileWriter("OSM_User_transitionPattern/sequenceLength=9/"+i+".txt");
			FileReader fr = new FileReader("OSM_token_new/sequenceLength=9/"+s[i]);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> transitionPattern = new ArrayList<String>();
			ArrayList<String> transitionPattern1 = new ArrayList<String>();
			ArrayList<String> transitionPattern2 = new ArrayList<String>();
			ArrayList<String> transitionPattern3 = new ArrayList<String>();
			//ArrayList<String> transitionPattern4 = new ArrayList<String>();
			//ArrayList<String> transitionPattern5 = new ArrayList<String>();
			String[] tempArray = new String[3];
			ArrayList<String> categorySequence = new ArrayList<String>();
			while ((line = br.readLine())!=null) {
				tempArray = line.split(" ");
				categorySequence.add(tempArray[0]);
			}
			for(int a = 0 ; a < categorySequence.size()-1 ; a++) {
				String transition = categorySequence.get(a) + categorySequence.get(a+1);
				transitionPattern.add(transition);
				if (transitionPattern1.contains(transition)) {
					if(transitionPattern2.contains(transition)){
						if(transitionPattern3.contains(transition)){
						}else {
							transitionPattern3.add(transition);
						}
					}else {
						transitionPattern2.add(transition);
					}
				}else {
					transitionPattern1.add(transition);
				}
			}
			for(int m = 0 ; m < transitionPattern.size() ; m++ ) {
				fw.write(transitionPattern.get(m));
				fw.write("\r\n");
			}
			fw.close();
			//System.out.print(transitionPattern3);
		}
	}
}