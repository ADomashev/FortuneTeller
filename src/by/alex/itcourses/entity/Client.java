package by.alex.itcourses.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Client implements Comparable<Client> {

	private String nameClient;
	private boolean toBeOrNotToBe = true;
	private TreeMap<Date, PredictionResult> predRes;

	public Client() {
		predRes = new TreeMap<Date, PredictionResult>();
	}

	public Client(String name) {
		this.nameClient = name;
		predRes = new TreeMap<Date, PredictionResult>();
	}

	public void displayPrediction(LinkedHashMap<Prediction, PriorityQueue<Answer>> map) {
		Iterator<Prediction> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}

	// change received parameter to this and add parameter predictor
	public void askPredictor(Prediction prediction, Predictor predictor) {
		Answer answer = predictor.predicting(prediction, this);
		System.out.println(answer);
		setPredictionResult(prediction, answer);
		setToBeOrNotToBe(false);

	}

	public Prediction choosePrediction(Set<Prediction> set) {
		Prediction predict = null;
		int numberAnsw = new Random().nextInt(5);
		// System.out.println(numberAnsw);
		Iterator<Prediction> iter = set.iterator();
		while (numberAnsw >= 0) {
			predict = iter.next();
			numberAnsw--;
		}
		return predict;
	}

	private void setPredictionResult(Prediction prediction, Answer answer) {
		Date date = Calendar.getInstance().getTime();
		PredictionResult predictionResult = new PredictionResult(prediction, answer);
		predRes.put(date, predictionResult);
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public boolean isToBeOrNotToBe() {
		return toBeOrNotToBe;
	}

	public void setToBeOrNotToBe(boolean toBeOrNotToBe) {
		this.toBeOrNotToBe = toBeOrNotToBe;
	}

	@Override
	public String toString() {
		return "Client: name = " + nameClient + ", toBeOrNotToBe = " + toBeOrNotToBe + "," + "\n" + "predRes = "
				+ predRes + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameClient == null) ? 0 : nameClient.hashCode());
		result = prime * result + ((predRes == null) ? 0 : predRes.hashCode());
		return result;
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
		if (nameClient == null) {
			if (other.nameClient != null)
				return false;
		} else if (!nameClient.equals(other.nameClient))
			return false;
		if (predRes == null) {
			if (other.predRes != null)
				return false;
		} else if (!predRes.equals(other.predRes))
			return false;

		return true;
	}

	@Override
	public int compareTo(Client o) {
		return nameClient.compareTo(o.nameClient);
	}

}
