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
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.sun.jmx.remote.internal.ArrayQueue;

public class Predictor {
	
	private LinkedHashMap<Prediction, PriorityQueue<Answer>>  predAnsw = loadPrediction();
	
	private PriorityQueue<Client> clientQueue = new PriorityQueue<>();
	
	private HashMap<Date, Client> u4et = new HashMap<>();
	
	private List<Client> waitList = new ArrayList<Client>();
	
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
	
	public void displayPrediction() {
		Set set = predAnsw.keySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	
	public Client nextClient () {
		return clientQueue.poll();
	}
	
	public void displayPredAndAnswers() {
		Set<Entry<Prediction, PriorityQueue<Answer>>> entrySet = predAnsw.entrySet();
		for (Entry<Prediction, PriorityQueue<Answer>> entry : entrySet) {
			System.out.println(entry);
		}
		
		
	}//LinkedHashMap<Prediction, Queue<Answer>>
	
	public Set<Prediction> getSetPrediction(){
		return predAnsw.keySet();
	}
	
	public LinkedHashMap<Prediction, PriorityQueue<Answer>> loadPrediction() {
		predAnsw = new LinkedHashMap<Prediction, PriorityQueue<Answer>>();
		for (int i = 0; i < 5; i++) {
			
			predAnsw.put(new Prediction("prediction"+i), loadAnswer());
		}
		return predAnsw;
	}
	private PriorityQueue<Answer> loadAnswer(){
		PriorityQueue<Answer> answ = new PriorityQueue<Answer>(10); // new ArrayQueue(5);
		for (int i = 0; i < 5; i++) {
			answ.add(new Answer("name"+i));
			//System.out.println(answ.toString());
			//answ.add(new Answer("name"+i));
		}
		return answ;
	}
	
	public Answer predicting(Prediction prediction,Client client) {
	//	System.out.println(prediction);
		if(isPossible(client)) {
		Date date = Calendar.getInstance().getTime();
		u4et.put(date, client);		
		PriorityQueue<Answer> answer = predAnsw.get(prediction);		
		predictionCount++;
		return randomAnswer(answer);}
		else {
			waitList.add(client);
			return new Answer("It's not possible");
		}
	}
	
	private Answer randomAnswer(PriorityQueue<Answer> answer) {
		Answer ans = null;
		Random rand = new Random();
		int numberAnsw = rand.nextInt(5);
		Iterator iter = answer.iterator();
		while(numberAnsw>=0) {
			ans = (Answer) iter.next();
			numberAnsw--;
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
	
//	public Client randomClient() {
//		
//		return 
//	}
//	
	
	
	
	
	
	
	
	

	public int getPredictionCount() {
		return predictionCount;
	}

	public void setPredictionCount(int predictionCount) {
		this.predictionCount = predictionCount;
	}

//	public LinkedHashMap<Prediction, Queue<Answer>> getPredAnsw() {
//		return predAnsw;
//	}

	public PriorityQueue<Client> getClientQueue() {
		return clientQueue;
	}

	public HashMap<Date, Client> getClientPred() {
		return u4et;
	}
	
	
	
}
