package by.alex.itcourses.entity;

public class PredictionResult {
	private Prediction prediction;
	private Answer anwer;
	
	
	public PredictionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PredictionResult(Prediction prediction, Answer anwer) {
		super();
		this.prediction = prediction;
		this.anwer = anwer;
	}
	public Prediction getPrediction() {
		return prediction;
	}
	public void setPrediction(Prediction prediction) {
		this.prediction = prediction;
	}
	public Answer getAnwer() {
		return anwer;
	}
	public void setAnwer(Answer anwer) {
		this.anwer = anwer;
	}
	@Override
	public String toString() {
		return "PredictionResult [prediction=" + prediction + ", anwer=" + anwer + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anwer == null) ? 0 : anwer.hashCode());
		result = prime * result + ((prediction == null) ? 0 : prediction.hashCode());
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
		PredictionResult other = (PredictionResult) obj;
		if (anwer == null) {
			if (other.anwer != null)
				return false;
		} else if (!anwer.equals(other.anwer))
			return false;
		if (prediction == null) {
			if (other.prediction != null)
				return false;
		} else if (!prediction.equals(other.prediction))
			return false;
		return true;
	}
	
}
