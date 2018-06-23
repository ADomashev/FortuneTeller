package by.alex.itcourses.run;


import java.util.Set;

import by.alex.itcourses.entity.Client;
import by.alex.itcourses.entity.Prediction;
import by.alex.itcourses.entity.Predictor;

public class RunCollection {

	public static void main(String[] args) {
		Predictor predictor = new Predictor();
		predictor.loadPrediction();
		
//		predictor.displayPredAndAnswers();
//		Client client = new Client("Serega");
//		Client client2 = new Client("Client2");
		for (int i = 0; i < 10; i++) {
			//Client client3 = new Client("Client"+i);
			predictor.getInLine(new Client("Client "+i));
		}
//		predictor.displayClients();
		int countClient = 0;
		while(countClient<= 100) {
			Client client = predictor.nextClient();
			Set<Prediction> setPrediction = predictor.getSetPrediction();
			//System.out.println(setPrediction);
			Prediction prediction = client.choosePrediction(setPrediction);
			client.askPredictor(prediction, predictor);
			predictor.addRandomClient();
			System.out.println();
			System.out.println(client.getNameClient() +" How much times: "+client.getCountHowMore());
			
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
		
//		
//		Client client = predictor.nextClient();
//		System.out.println(client);
//		Set<Prediction> setPrediction = predictor.getSetPrediction();
//		//System.out.println(setPrediction);
//		Prediction prediction = client.choosePrediction(setPrediction);
//		//System.out.println(prediction);
//		client.askPredictor(prediction, predictor);
//		
//		Prediction prediction1 = client.choosePrediction(setPrediction);
//		client.askPredictor(prediction1, predictor);
//		System.out.println(client);
//		System.out.println();
//		System.out.println("WaitList");
//		predictor.displayWaitList();
	}

}
