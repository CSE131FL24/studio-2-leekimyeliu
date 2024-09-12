package studio2;

public class Ruin {

	public static void main(String[] args) {
		double startAmount = 2;
		double winChance = 0.7;
		double winLimit = 10;
		int trial = 0;
		int trialNum = 0;
		int totalSim = 500;
		double ruinRate = 0;
		double expectedRuin;
		
		for (int simNum=1;simNum<=totalSim;simNum++) {
			while (startAmount < winLimit && startAmount>0) {
				trial = (int)(Math.random()*100);
				trialNum++;
				if (trial<(winChance*100)) {
					startAmount++;
				}
				else {
					startAmount--;
				}
			}
			System.out.print("Simulation "+simNum+": ");
			System.out.print(trialNum);
			if (startAmount == winLimit) {
				System.out.println(" Win");
			}
			else {
				System.out.println(" Lose");
				ruinRate++;
			}
			startAmount = 2;
			trialNum = 0;
		}
		System.out.println("Losses: "+ruinRate+" Simulations: "+totalSim);
		System.out.print("Ruin Rate from Simulation: "+(ruinRate/totalSim));
		
		//Calculations
		double a = (1-winChance)/winChance;
		if (winChance == 0.5) {
			expectedRuin = 1-((double)startAmount/winLimit);
		}
		else {
			expectedRuin = ((Math.pow(a,startAmount))-(Math.pow(a,winLimit)))/(1-(Math.pow(a,winLimit)));
		}
		
		System.out.println(" Expected Ruin Rate: "+ expectedRuin);
	}
}