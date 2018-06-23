package by.alex.itcourses.entity;

public class Answer implements Comparable<Answer> {
	private String answer;

	public Answer() {

	}

	public Answer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer: " + answer + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
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
		Answer other = (Answer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		return true;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int compareTo(Answer o) {
		return answer.compareTo(o.answer);
	}

}
