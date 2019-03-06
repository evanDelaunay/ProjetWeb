package compteur;

public class Compteur {
	private int nboccurence;

	public Compteur() {
		super();
		this.nboccurence = 0;
	}

	public int getNboccurence() {
		return nboccurence;
	}

	public void setNboccurence(int nboccurence) {
		this.nboccurence = nboccurence;
	}

	public void increment() {
		this.nboccurence = this.nboccurence+1;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compteur other = (Compteur) obj;
		if (nboccurence != other.nboccurence)
			return false;
		return true;
	}
	
	

}
