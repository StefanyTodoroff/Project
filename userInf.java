package demo;

public class userInf {

	private int weight;

	
	userInf(){
	}
	
	public userInf(int weight){

		this.weight = weight;

		
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int calculateWater(){
		int litres = (int) Math.round((weight / 10) * 0.4);
		
		
		return litres;
	}
}
