package by.alex.itcourses.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


public class Client implements Comparable<Client>{
	
	private String name;
	private boolean toBeOrNotToBe = true;
	private Predictor predictor = new Predictor();
	private TreeMap <Date, PredictionResult>  predRes = new TreeMap();
	
	

	public void displayPrediction(LinkedHashMap<Prediction, PriorityQueue<Answer>> map) {
		Set set = map.keySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	
	private void setPredictionResult(Prediction prediction, Answer answer) {
		Calendar calendar =Calendar.getInstance();
		Date date = calendar.getTime();
		PredictionResult predictionResult = new PredictionResult(prediction,answer);
		predRes.put(date,predictionResult);
	}
	
	public void askPredictor(Prediction prediction,Client client) {
		Answer answer = predictor.predicting(prediction,client);
		System.out.println(answer);
		setPredictionResult(prediction, answer);
		setToBeOrNotToBe(false);
		
	}
	public Prediction choosePrediction(Set<Prediction> set) {
		Prediction predict = null;
		Random rand = new Random();
		int numberAnsw = rand.nextInt(5);
		System.out.println(numberAnsw);
		Iterator iter = set.iterator();
		while(numberAnsw>=0) {
			predict = (Prediction) iter.next();
			numberAnsw--;
		}
		return predict;
	}


	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((predRes == null) ? 0 : predRes.hashCode());
		return result;
	}

	public boolean isToBeOrNotToBe() {
		return toBeOrNotToBe;
	}

	public void setToBeOrNotToBe(boolean toBeOrNotToBe) {
		this.toBeOrNotToBe = toBeOrNotToBe;
	}

	


	@Override
	public String toString() {
		return "Client [name=" + name + ", toBeOrNotToBe=" + toBeOrNotToBe + ", predictor=" + predictor + ", predRes="
				+ predRes + "]";
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (predRes == null) {
			if (other.predRes != null)
				return false;
		} else if (!predRes.equals(other.predRes))
			return false;
		
		return true;
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}
	
	
	
}
