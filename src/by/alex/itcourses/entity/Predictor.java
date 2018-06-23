package by.alex.itcourses.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Predictor {

	private Map<Prediction, PriorityQueue<Answer>> predAnsw;
	private Queue<Client> clientQueue;
	private Map<Date, Client> accountingClient;
	private List<Client> waitList;
	
	private List<Client> randomClients;

	private int predictionCount = 0;

	public Predictor() {
		predAnsw = loadPrediction();
		clientQueue = new PriorityQueue<>();
		accountingClient = new HashMap<>();
		waitList = new ArrayList<Client>();
		
		randomClients= new ArrayList<Client>();
	}

	public void getInLine(Client client) {
		clientQueue.add(client);
		
		randomClients.add(client);
	}

	private void addClientToWaitList(Client client) {
		if(!waitList.contains(client))
		waitList.add(client);
	}

	private boolean isPossible(Client client) {
		if (client.isToBeOrNotToBe() && predictionCount <= 10) {
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
	
	public void addRandomClient() {
		Client client = null;
		int randomCount = new Random().nextInt(10);
		//System.out.println(randomCount);
		client = randomClients.get(randomCount);
		
		clientQueue.add(client);
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

	public Map<Prediction, PriorityQueue<Answer>> loadPrediction() {
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
//	TODO complete the exit from the program if predictionCount equal ten
	public Answer predicting(Prediction prediction, Client client) {
		if(predictionCount<10) {
			return pred(prediction,client);
			
		}else {System.exit(0);
		return new Answer("enough");}
	}

	public Answer pred (Prediction prediction, Client client){
		if (isPossible(client)) {
			accountingPrediction(client);
			predictionCount++;
			return randomAnswer(getListAnswers(prediction));
		} else {
			predictionCount++;
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

	public void displayWaitList() {
		Iterator<Client> itr = waitList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
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
	

	public int getPredictionCount() {
		return predictionCount;
	}

	public void setPredictionCount(int predictionCount) {
		this.predictionCount = predictionCount;
	}

	// public LinkedHashMap<Prediction, Queue<Answer>> getPredAnsw() {
	// return predAnsw;
	// }

	public Queue<Client> getClientQueue() {
		return clientQueue;
	}

	public Map<Date, Client> getClientPred() {
		return accountingClient;
	}

}
