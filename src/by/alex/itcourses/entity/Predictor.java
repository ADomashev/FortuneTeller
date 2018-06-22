package by.alex.itcourses.entity;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.sun.jmx.remote.internal.ArrayQueue;

public class Predictor {
	
	private LinkedHashMap<Prediction, Queue<Answer>>  predAnsw = new LinkedHashMap();
	
	private PriorityQueue<Client> clientQueue = new PriorityQueue<>();
	
	private HashMap<Date, Client> u4et = new HashMap<>();
	
	private List<Client> waitList = new ArrayList();
	
	private int predictionCount = 0;
	
	public void getInLine(Client client) {
		clientQueue.add(client);
	}
	
	private void accountingClient() {
		
	}
	private boolean isPossible(Client client) {
		if(client.isToBeOrNotToBe() & predictionCount<=10) {
			return true;
		}else return false;
	}
	
	public void loadPrediction() {
		//predAnsw.put(new Prediction ("Love"), new ArrayQueue(5).add(new Answer("never")));
	}
	
	public Answer predicting(Prediction prediction,Client client) {
		if(isPossible(client)) {
		Date date = Calendar.getInstance().getTime();
		u4et.put(date, client);
		Queue<Answer> answer = predAnsw.get(prediction);
		predictionCount++;
		return randomAnswer(answer);}
		else {
			waitList.add(client);
			return new Answer("It's not possible");
		}
	}
	
	private Answer randomAnswer(Queue<Answer> answer) {
		Answer ans = null;
		Random rand = new Random();
		int numberAnsw = rand.nextInt(5);
		Iterator iter = answer.iterator();
		while(numberAnsw>0) {
			ans = (Answer) iter.next();
		}
		return ans;
	}
	
	public void displayClients() {
		Iterator iter = clientQueue.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public void delClient(int number) {
		Client client=null;
		Iterator iter = clientQueue.iterator();
		while(number>0) {
			client = (Client) iter.next();
		}
		clientQueue.remove(client);
	}
	
	
	
	
	
	
	
	
	
	
	

	public int getPredictionCount() {
		return predictionCount;
	}

	public void setPredictionCount(int predictionCount) {
		this.predictionCount = predictionCount;
	}

	public LinkedHashMap<Prediction, Queue<Answer>> getPredAnsw() {
		return predAnsw;
	}

	public PriorityQueue<Client> getClientQueue() {
		return clientQueue;
	}

	public HashMap<Date, Client> getClientPred() {
		return u4et;
	}
	
	
	
}
