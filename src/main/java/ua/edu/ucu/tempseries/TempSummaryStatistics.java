package ua.edu.ucu.tempseries;

/**
 * Immutable class for saving the information
 * anout temperature series.
 *
 * @author  Khrystyna Kokolus
 * @version 1.0
 */

final public class TempSummaryStatistics {
    final private double avgTemp;
    final private double devTemp;
    final private double minTemp;
    final private double maxTemp;

    /**
     * Creates a new object of the immutable
     * TempSummaryStatistics class.
     */
    public TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    /**
     * Gets the average temperature
     * from the temperature series.
     *
     * @return average temperature
     */
    public double getAvgTemp(){
        return avgTemp;
    }

    /**
     * Gets the deviation of the temperatures
     * from the temperature series.
     *
     * @return deviation of the temperatures
     */
    public double getDevTemp(){
        return devTemp;
    }

    /**
     * Gets the min temperature
     * from the temperature series.
     *
     * @return min temperature
     */
    public double getMinTemp(){
        return minTemp;
    }

    /**
     * Gets the max temperature
     * from the temperature series.
     *
     * @return max temperature
     */
    public double getMaxTemp(){
        return maxTemp;
    }
}
