package by.alex.itcourses.entity;

public class Prediction {
	
	private String namePrediction;

	public Prediction() {

	}

	public Prediction(String namePred) {
		this.namePrediction = namePred;
	}

	@Override
	public String toString() {
		return  namePrediction + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namePrediction == null) ? 0 : namePrediction.hashCode());
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
		Prediction other = (Prediction) obj;
		if (namePrediction == null) {
			if (other.namePrediction != null)
				return false;
		} else if (!namePrediction.equals(other.namePrediction))
			return false;
		return true;
	}

	public String getNamePred() {
		return namePrediction;
	}

	public void setNamePred(String namePred) {
		this.namePrediction = namePred;
	}

}
