package maven;

public class GoldNuggetCalc {
	
	int dumptruck = 50000;
	int goudgewicht = 19;
	int prijsperkg = 52250;

	public static void main(String[] args) {
		GoldNuggetCalc gnc = new GoldNuggetCalc();
		gnc.vatberekenen(20, 110);
		gnc.GoldNuggetPrijs(19,52250);
		gnc.goldnuggetspervat(19);
		gnc.dumptruckvaten(50000);
		gnc.prijsnuggetspervat();
		gnc.prijsDumptruckNuggets();
	}
	
	public double vatberekenen(double straal, double hoogte) {
		double volumevat = straal*straal*3.14*hoogte/1000*19;
		System.out.println(volumevat);
		return volumevat;
	}
	public double GoldNuggetPrijs(double goldnuggetgewicht ,double prijsperkg) {
		double goud = goldnuggetgewicht*prijsperkg;
		System.out.println(goud);
		return goud;
	}
	
	public double goldnuggetspervat (double goldnuggetgewicht) {
		double goldnuggetspervat = vatberekenen(20, 110) / goldnuggetgewicht;
		System.out.println(goldnuggetspervat);
		return goldnuggetspervat;
	}
	
	public double prijsnuggetspervat() {
		double prijsnuggetspervat = GoldNuggetPrijs(19,52250) * goldnuggetspervat(19);
		System.out.println(prijsnuggetspervat);
		return prijsnuggetspervat;
	}
	public double dumptruckvaten(int dumptruckgewicht) {
		double dumptruckvaten = dumptruckgewicht / vatberekenen(20, 110);
		System.out.println(dumptruckvaten);
		return dumptruckvaten;
	}
	
	public double prijsDumptruckNuggets() {
		double prijsDumptruckNuggets = dumptruckvaten(50000) * prijsnuggetspervat();
		System.out.println(prijsDumptruckNuggets);
		return prijsDumptruckNuggets;
	}
}
