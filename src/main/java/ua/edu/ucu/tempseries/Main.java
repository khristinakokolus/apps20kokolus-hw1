package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] temperatures = new double[] {25.0, 30.0};
        double[] temperatures1 = new double[] {40.0};
        TemperatureSeriesAnalysis tempSeries = new TemperatureSeriesAnalysis(temperatures);
        System.out.println("tempSeries average: " + tempSeries.average());
        System.out.println("tempSeries deviation: " + tempSeries.deviation());
        System.out.println("tempSeries min: " + tempSeries.min());
        System.out.println("tempSeries max: " + tempSeries.max());
        System.out.println("closest pair to 0 " + tempSeries.findTempClosestToZero());
        System.out.println("tempSeries with values less than " + Arrays.toString(tempSeries.findTempsLessThen(50)));
        System.out.println("tempSeries with values greater than " + Arrays.toString(tempSeries.findTempsGreaterThen(5)));
        System.out.println("added new items to the series(amount) " + tempSeries.addTemps(temperatures1));
        System.out.println(Arrays.toString(tempSeries.getTemperatureSeries()));
    }
}
