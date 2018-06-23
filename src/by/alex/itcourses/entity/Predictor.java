package by.alex.itcourses.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


public class Predictor {

	private LinkedHashMap<Prediction, PriorityQueue<Answer>> predAnsw = loadPrediction();

	private PriorityQueue<Client> clientQueue = new PriorityQueue<>();

	private HashMap<Date, Client> accountingClient = new HashMap<>();

	private List<Client> waitList = new ArrayList<Client>();

	private int predictionCount = 0;

	public void getInLine(Client client) {
		clientQueue.add(client);
	}

	private void addClientToWaitList(Client client) {
		waitList.add(client);
	}

	private boolean isPossible(Client client) {
		if (client.isToBeOrNotToBe() & predictionCount <= 10) {
			return true;
		} else
			return false;
	}

	public void displayPrediction() {
		Iterator<Prediction> itr = predAnsw.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}

	public Client nextClient() {
		return clientQueue.poll();
	}

	public void displayPredAndAnswers() {
		Set<Entry<Prediction, PriorityQueue<Answer>>> entrySet = predAnsw.entrySet();
		for (Entry<Prediction, PriorityQueue<Answer>> entry : entrySet) {
			System.out.println(entry);
		}
	}

	public Set<Prediction> getSetPrediction() {
		return predAnsw.keySet();
	}

	public LinkedHashMap<Prediction, PriorityQueue<Answer>> loadPrediction() {
		predAnsw = new LinkedHashMap<Prediction, PriorityQueue<Answer>>();
		for (int i = 0; i < 5; i++) {
			predAnsw.put(new Prediction("prediction" + i), loadAnswer());
		}
		return predAnsw;
	}

	private PriorityQueue<Answer> loadAnswer() {
		PriorityQueue<Answer> answ = new PriorityQueue<Answer>(10);
		for (int i = 0; i < 5; i++) {
			answ.add(new Answer("name" + i));
		}
		return answ;
	}

	public Answer predicting(Prediction prediction, Client client) {
		if (isPossible(client)) {
			accountingPrediction(client);
			predictionCount++;
			return randomAnswer(getListAnswers(prediction));
		} else {
			addClientToWaitList(client);
			return new Answer("It's not possible");
		}
	}

	private PriorityQueue<Answer> getListAnswers(Prediction prediction) {
		return predAnsw.get(prediction);
	}

	private Answer randomAnswer(PriorityQueue<Answer> answers) {
		Answer answer = null;
		int numberAnsw = new Random().nextInt(5);
		Iterator<Answer> iter = answers.iterator();
		while (numberAnsw >= 0) {
			answer = iter.next();
			numberAnsw--;
		}
		return answer;
	}

	private void accountingPrediction(Client client) {
		Date date = Calendar.getInstance().getTime();
		accountingClient.put(date, client);
	}

	public void displayClients() {
		Iterator<Client> iter = clientQueue.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void delClient(int number) {
		Client client = null;
		Iterator<Client> iter = clientQueue.iterator();
		while (number >= 0) {
			client = iter.next();
			number--;
		}
		clientQueue.remove(client);
	}

	// public Client randomClient() {
	//
	// return
	// }

	public int getPredictionCount() {
		return predictionCount;
	}

	public void setPredictionCount(int predictionCount) {
		this.predictionCount = predictionCount;
	}

	// public LinkedHashMap<Prediction, Queue<Answer>> getPredAnsw() {
	// return predAnsw;
	// }

	public PriorityQueue<Client> getClientQueue() {
		return clientQueue;
	}

	public HashMap<Date, Client> getClientPred() {
		return accountingClient;
	}

}
