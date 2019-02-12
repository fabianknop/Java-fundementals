package gameOfLife;

public class LifeApplication {

	public static void main(String[] args) {
		LifeModel lifemodel = new LifeModel();
		while(true){
			lifemodel.toon();
			lifemodel.volgendeGeneratie();
		}
	}

}
