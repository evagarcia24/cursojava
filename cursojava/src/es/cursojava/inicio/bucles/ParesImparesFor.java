package es.cursojava.inicio.bucles;

public class ParesImparesFor {

	public static void main(String[] args) {
		int i=2;
		int j=99;
		 
		for(i=2; i<=100; i+=2) {
			System.out.println(i +" - "+j);
			j-=2;
		}
		
		//OTRA FORMA:
		//for(int i=2, j=99; i<=100; i+=2, j-=2) {
		//	System.out.println(i+"-"+j);
	}

}

