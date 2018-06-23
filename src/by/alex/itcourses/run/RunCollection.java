package by.alex.itcourses.run;


import by.alex.itcourses.entity.Client;
import by.alex.itcourses.entity.Predictor;

public class RunCollection {

	public static void main(String[] args) {
		Predictor predictor = new Predictor();
		predictor.loadPrediction();
		predictor.displayPredAndAnswers();
//		Client client = new Client("Serega");
//		Client client2 = new Client("Client2");
		for (int i = 0; i < 10; i++) {
			//Client client3 = new Client("Client"+i);
			predictor.getInLine(new Client("Client"+i));
		}
		predictor.displayClients();

	}

}
