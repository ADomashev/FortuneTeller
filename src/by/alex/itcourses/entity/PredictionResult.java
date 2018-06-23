package by.alex.itcourses.entity;

public class PredictionResult {

	private Prediction prediction;
	private Answer answer;

	public PredictionResult() {

	}

	public PredictionResult(Prediction prediction, Answer anwer) {
		this.prediction = prediction;
		this.answer = anwer;
	}

	public Prediction getPrediction() {
		return prediction;
	}

	public void setPrediction(Prediction prediction) {
		this.prediction = prediction;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnwer(Answer anwer) {
		this.answer = anwer;
	}

	@Override
	public String toString() {
		return "PredictionResult [prediction: " + prediction + ", anwer: " + answer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
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
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (prediction == null) {
			if (other.prediction != null)
				return false;
		} else if (!prediction.equals(other.prediction))
			return false;
		return true;
	}

}
