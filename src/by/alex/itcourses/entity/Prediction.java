package by.alex.itcourses.entity;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Prediction {
	private String namePred;

	public Prediction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prediction(String namePred) {
		super();
		this.namePred = namePred;
	}

	@Override
	public String toString() {
		return "Prediction [namePred=" + namePred + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namePred == null) ? 0 : namePred.hashCode());
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
		if (namePred == null) {
			if (other.namePred != null)
				return false;
		} else if (!namePred.equals(other.namePred))
			return false;
		return true;
	}

	public String getNamePred() {
		return namePred;
	}

	public void setNamePred(String namePred) {
		this.namePred = namePred;
	}
	
	
	
}
