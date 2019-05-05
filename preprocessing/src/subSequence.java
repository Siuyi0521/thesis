import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class subSequence{
	public void subSequence() throws IOException{
		String file;
		int n = 1;
		for(int m = 0 ; m < 1560 ; m++) {
			if( m < 10){
				file = "00" + m;
			}else if (m >= 10 && m <100){
				file = "0" + m;
			}else{
				file = "" + m;
			}
			String line;
			FileReader fr = new FileReader("OSM_token_new/all/"+file+"token.txt.txt");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> sequence = new ArrayList<String>();
			while((line = br.readLine()) != null) {
				sequence.add(line);
			}
			String NO;
			
			if(sequence.size() >= 9) {
				for (int i = 0; i < sequence.size()-8 ; i++) {
					
					File a = new File("OSM_sequence_Input/sequenceLength=9/user/"+file);
					a.mkdir();
					File b = new File("OSM_sequence_Output/sequenceLength=9/user/"+file);
					b.mkdir();
					FileWriter allinput = new FileWriter("OSM_sequence_Input/sequenceLength=9/all/"+n+".txt");
					FileWriter alloutput = new FileWriter("OSM_sequence_Output/sequenceLength=9/all/"+n+".txt");
					FileWriter userinput = new FileWriter("OSM_sequence_Input/sequenceLength=9/user/"+file+"/"+i+".txt");
					FileWriter useroutput = new FileWriter("OSM_sequence_Output/sequenceLength=9/user/"+file+"/"+i+".txt");
					allinput.write(sequence.get(i)+" ");
					allinput.write(sequence.get(i+1)+" ");
					allinput.write(sequence.get(i+2)+" ");
					allinput.write(sequence.get(i+3)+" ");
					allinput.write(sequence.get(i+4)+" ");
					allinput.write(sequence.get(i+5)+" ");
					allinput.write(sequence.get(i+6)+" ");
					allinput.write(sequence.get(i+7)+" ");
					alloutput.write(sequence.get(i+8)+" ");
					userinput.write(sequence.get(i)+" ");
					userinput.write(sequence.get(i+1)+" ");
					userinput.write(sequence.get(i+2)+" ");
					userinput.write(sequence.get(i+3)+" ");
					userinput.write(sequence.get(i+4)+" ");
					userinput.write(sequence.get(i+5)+" ");
					userinput.write(sequence.get(i+6)+" ");
					userinput.write(sequence.get(i+7)+" ");
					useroutput.write(sequence.get(i+8)+" ");
					allinput.flush();
					alloutput.flush();
					userinput.flush();
					useroutput.flush();
					allinput.close();
					alloutput.close();
					userinput.close();
					useroutput.close();
					n++;
				}	 
			}	
		}
	}
}