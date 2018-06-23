package by.alex.itcourses.run;

import java.util.Set;

import by.alex.itcourses.entity.Client;
import by.alex.itcourses.entity.Prediction;
import by.alex.itcourses.entity.Predictor;

public class RunCollection {

	public static void main(String[] args) {
		Predictor predictor = new Predictor();
		predictor.loadPrediction();

		for (int i = 0; i < 10; i++) {

			predictor.getInLine(new Client("Client " + i));
		}
		int countClient = 0;
		while (countClient <= 100) {
			Client client = predictor.nextClient();
			Set<Prediction> setPrediction = predictor.getSetPrediction();
			Prediction prediction = client.choosePrediction(setPrediction);
			client.askPredictor(prediction, predictor);
			predictor.addRandomClient();
			System.out.println();
			System.out.println(client.getNameClient() + " How much times: " + client.getCountHowMore());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countClient++;
		}
		System.out.println();
		System.out.println("WaitList");
		predictor.displayWaitList();

	}

}
