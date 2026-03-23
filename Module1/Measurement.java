package Module1;
public class Measurement {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s    %-10s%-10s\n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("----------------------------------------------------------");

        double foot = 1;
        double meter = 20;

        for (int i = 1; i <= 10; i++) {
            double metersFromFeet = footToMeter(foot);
            double feetFromMeters = meterToFoot(meter);

            System.out.printf("%-10.1f%-10.3f    %-10.1f%-10.3f\n", 
                               foot, metersFromFeet, meter, feetFromMeters);

            foot += 1;
            meter += 5;
        }
    }
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }
}
