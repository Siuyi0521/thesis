import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class accuracyOSM{
	public void accuracyOSM() throws IOException{
		/*FileReader fr = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/result/OSM/ours/GRU_SL=9.txt");
		BufferedReader br = new BufferedReader(fr);
		String[][] acc = new String[15][5];
		String[] tempArray = new String[5];
		String line;
		int i = 0;
		double global_top1_macro,global_top2_macro,global_top3_macro,global_top4_macro,global_top5_macro;
		double global_top1_micro,global_top2_micro,global_top3_micro,global_top4_micro,global_top5_micro;
		
		double group_top1_macro,group_top2_macro,group_top3_macro,group_top4_macro,group_top5_macro;
		double group_top1_micro,group_top2_micro,group_top3_micro,group_top4_micro,group_top5_micro;
		
		double att_top1_macro,att_top2_macro,att_top3_macro,att_top4_macro,att_top5_macro;
		double att_top1_micro,att_top2_micro,att_top3_micro,att_top4_micro,att_top5_micro;
		
		double TL_top1_macro,TL_top2_macro,TL_top3_macro,TL_top4_macro,TL_top5_macro;
		double TL_top1_micro,TL_top2_micro,TL_top3_micro,TL_top4_micro,TL_top5_micro;
		
		while ((line = br.readLine())!= null) {
			line = line.replace("[", "");
			line = line.replace(",", "");
			line = line.replace("]", "");
			tempArray = line.split(" ");
			for (int a = 0 ; a < 5 ; a++) {
				acc[i][a] = tempArray[a];
			}
			i++;
		}
		double group1 = 6738;
		double group2 = 520;
		double group3 = 6745;
		//double group4 = 384;
		for(int l = 0 ; l < 5 ; l++) {
			global_top1_micro = (Double.parseDouble(acc[l][0])*group1 + Double.parseDouble(acc[l+5][0])*group2 + Double.parseDouble(acc[l+10][0])*group3)/(group1+group2+group3);
			global_top2_micro = (Double.parseDouble(acc[l][1])*group1 + Double.parseDouble(acc[l+5][1])*group2 + Double.parseDouble(acc[l+10][1])*group3)/(group1+group2+group3);
			global_top3_micro = (Double.parseDouble(acc[l][2])*group1 + Double.parseDouble(acc[l+5][2])*group2 + Double.parseDouble(acc[l+10][2])*group3)/(group1+group2+group3);
			global_top4_micro = (Double.parseDouble(acc[l][3])*group1 + Double.parseDouble(acc[l+5][3])*group2 + Double.parseDouble(acc[l+10][3])*group3)/(group1+group2+group3);
			global_top5_micro = (Double.parseDouble(acc[l][4])*group1 + Double.parseDouble(acc[l+5][4])*group2 + Double.parseDouble(acc[l+10][4])*group3)/(group1+group2+group3);
			System.out.println(global_top1_micro+"	"+global_top2_micro+"	"+global_top3_micro+"	"+global_top4_micro+"	"+global_top5_micro);
			
//			global_top1_macro = (Double.parseDouble(acc[l][0])+ Double.parseDouble(acc[l+5][0]) + Double.parseDouble(acc[l+10][0]))/3;
//			global_top2_macro = (Double.parseDouble(acc[l][1])+ Double.parseDouble(acc[l+5][1]) + Double.parseDouble(acc[l+10][1]))/3;
//			global_top3_macro = (Double.parseDouble(acc[l][2])+ Double.parseDouble(acc[l+5][2]) + Double.parseDouble(acc[l+10][2]))/3;
//			global_top4_macro = (Double.parseDouble(acc[l][3])+ Double.parseDouble(acc[l+5][3]) + Double.parseDouble(acc[l+10][3]))/3;
//			global_top5_macro = (Double.parseDouble(acc[l][4])+ Double.parseDouble(acc[l+5][4]) + Double.parseDouble(acc[l+10][4]))/3;
//			System.out.println(global_top1_macro+"	"+global_top2_macro+"	"+global_top3_macro+"	"+global_top4_macro+"	"+global_top5_macro);
		}*/
		
		
		FileReader fr = new FileReader("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/result/OSM/ours/GRU_group3.txt");
		BufferedReader br = new BufferedReader(fr);
		String[][] acc = new String[20][5];
		String[] tempArray = new String[5];
		String line;
		int i = 0;
		double baseline_global_top1_macro,baseline_global_top2_macro,baseline_global_top3_macro,baseline_global_top4_macro,baseline_global_top5_macro;
		double baseline_global_top1_micro,baseline_global_top2_micro,baseline_global_top3_micro,baseline_global_top4_micro,baseline_global_top5_micro;
		
		double baseline_group_top1_macro,baseline_group_top2_macro,baseline_group_top3_macro,baseline_group_top4_macro,baseline_group_top5_macro;
		double baseline_group_top1_micro,baseline_group_top2_micro,baseline_group_top3_micro,baseline_group_top4_micro,baseline_group_top5_micro;
		
		double ours_global_top1_macro,ours_global_top2_macro,ours_global_top3_macro,ours_global_top4_macro,ours_global_top5_macro;
		double ours_global_top1_micro,ours_global_top2_micro,ours_global_top3_micro,ours_global_top4_micro,ours_global_top5_micro;
		
		double ours_group_top1_macro,ours_group_top2_macro,ours_group_top3_macro,ours_group_top4_macro,ours_group_top5_macro;
		double ours_group_top1_micro,ours_group_top2_micro,ours_group_top3_micro,ours_group_top4_micro,ours_group_top5_micro;
		
		double GRU_att_top1_macro,GRU_att_top2_macro,GRU_att_top3_macro,GRU_att_top4_macro,GRU_att_top5_macro;
		double GRU_att_top1_micro,GRU_att_top2_micro,GRU_att_top3_micro,GRU_att_top4_micro,GRU_att_top5_micro;
		
		double LSTM_att_top1_macro,LSTM_att_top2_macro,LSTM_att_top3_macro,LSTM_att_top4_macro,LSTM_att_top5_macro;
		double LSTM_att_top1_micro,LSTM_att_top2_micro,LSTM_att_top3_micro,LSTM_att_top4_micro,LSTM_att_top5_micro;
		
		double TL_top1_macro,TL_top2_macro,TL_top3_macro,TL_top4_macro,TL_top5_macro;
		double TL_top1_micro,TL_top2_micro,TL_top3_micro,TL_top4_micro,TL_top5_micro;
		
		while ((line = br.readLine())!= null) {
			//line = line.replace("[", "");
			//line = line.replace(",", "");
			//line = line.replace("]", "");
			tempArray = line.split("	");
			for (int a = 0 ; a < 5 ; a++) {
				acc[i][a] = tempArray[a];
			}
			i++;
		}
		double group1 = 8277+893+8383;
		double group2 = 7600+732+7626;
		double group3 = 7114+618+7131;
		double group4 = 6738+520+6745;
		for(int l = 0 ; l < 5 ; l++) {
			baseline_global_top1_macro = (Double.parseDouble(acc[l][0])*group1 + Double.parseDouble(acc[l+5][0])*group2 + Double.parseDouble(acc[l+10][0])*group3 + Double.parseDouble(acc[l+15][0])*group4)/(group1+group2+group3+group4);
			baseline_global_top2_macro = (Double.parseDouble(acc[l][1])*group1 + Double.parseDouble(acc[l+5][1])*group2 + Double.parseDouble(acc[l+10][1])*group3 + Double.parseDouble(acc[l+15][1])*group4)/(group1+group2+group3+group4);
			baseline_global_top3_macro = (Double.parseDouble(acc[l][2])*group1 + Double.parseDouble(acc[l+5][2])*group2 + Double.parseDouble(acc[l+10][2])*group3 + Double.parseDouble(acc[l+15][2])*group4)/(group1+group2+group3+group4);
			baseline_global_top4_macro = (Double.parseDouble(acc[l][3])*group1 + Double.parseDouble(acc[l+5][3])*group2 + Double.parseDouble(acc[l+10][3])*group3 + Double.parseDouble(acc[l+15][3])*group4)/(group1+group2+group3+group4);
			baseline_global_top5_macro = (Double.parseDouble(acc[l][4])*group1 + Double.parseDouble(acc[l+5][4])*group2 + Double.parseDouble(acc[l+10][4])*group3 + Double.parseDouble(acc[l+15][4])*group4)/(group1+group2+group3+group4);
			System.out.println(baseline_global_top1_macro+"	"+baseline_global_top2_macro+"	"+baseline_global_top3_macro+"	"+baseline_global_top4_macro+"	"+baseline_global_top5_macro);
//			baseline_global_top1_micro = (Double.parseDouble(acc[l][0])+ Double.parseDouble(acc[l+5][0]) + Double.parseDouble(acc[l+10][0]) + Double.parseDouble(acc[l+15][0]))/4;
//			baseline_global_top2_micro = (Double.parseDouble(acc[l][1])+ Double.parseDouble(acc[l+5][1]) + Double.parseDouble(acc[l+10][1]) + Double.parseDouble(acc[l+15][1]))/4;
//			baseline_global_top3_micro = (Double.parseDouble(acc[l][2])+ Double.parseDouble(acc[l+5][2]) + Double.parseDouble(acc[l+10][2]) + Double.parseDouble(acc[l+15][2]))/4;
//			baseline_global_top4_micro = (Double.parseDouble(acc[l][3])+ Double.parseDouble(acc[l+5][3]) + Double.parseDouble(acc[l+10][3]) + Double.parseDouble(acc[l+15][3]))/4;
//			baseline_global_top5_micro = (Double.parseDouble(acc[l][4])+ Double.parseDouble(acc[l+5][4]) + Double.parseDouble(acc[l+10][4]) + Double.parseDouble(acc[l+15][4]))/4;
//			System.out.println(baseline_global_top1_micro+"	"+baseline_global_top2_micro+"	"+baseline_global_top3_micro+"	"+baseline_global_top4_micro+"	"+baseline_global_top5_micro);
		}
	}
}