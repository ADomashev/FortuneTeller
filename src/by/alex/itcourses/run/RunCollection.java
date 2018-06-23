package by.alex.itcourses.run;

import java.util.Set;

import by.alex.itcourses.entity.Client;
import by.alex.itcourses.entity.Prediction;
import by.alex.itcourses.entity.Predictor;

public class RunCollection {

	public static void main(String[] args) {
		Predictor predictor = new Predictor();
		predictor.loadPrediction();

		for (int i = 0; i < 15; i++) {
			predictor.getInLine(new Client("Client " + i));
		}

		int countClient = 0;
		while (countClient <= 15) {
			
			Client client = predictor.nextClient();
			
			Set<Prediction> setPrediction = predictor.getSetPrediction();
			
			Prediction prediction = client.choosePrediction(setPrediction);
			
			client.askPredictor(prediction, predictor);
			
			System.out.println();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			predictor.addRandomClient();
			countClient++;
		}
		System.out.println();
		System.out.println("WaitList");
		predictor.displayWaitList();

	}

}
