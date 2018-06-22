package by.alex.itcourses.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


public class Client {
	
	private String name;
	private int time;
	private boolean toBeOrNotToBe = true;
	private Predictor predictor = new Predictor();
	private TreeMap <Date, PredictionResult>  predRes = new TreeMap();
	
	
	public void displayPrediction(LinkedHashMap<Prediction, Queue<Answer>> map) {
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


	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((predRes == null) ? 0 : predRes.hashCode());
		result = prime * result + time;
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
		return "Client [name=" + name + ", time=" + time + ", predRes=" + predRes + "]";
	}

	public Client(String name, int time, TreeMap<Date, PredictionResult> predRes) {
		super();
		this.name = name;
		this.time = time;
		this.predRes = predRes;
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
		if (time != other.time)
			return false;
		return true;
	}
	
	
	
}
