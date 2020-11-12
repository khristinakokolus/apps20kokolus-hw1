package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

/**
 * TemperatureSeriesAnalysis program implements
 * a program that analyses the temperature
 * series.
 *
 * @author  Khrystyna Kokolus
 * @version 1.0
 */

public class TemperatureSeriesAnalysis {
    private final int capacity = 50;
    private final int maxMinValue = -273;
    private double[] temperatureSeries;
    private int amountOfTemperatures;

    /**
     * Creates a new default object of the
     * TemperatureSeriesAnalysis class.
     */

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[capacity];
        this.amountOfTemperatures = 0;
    }

    /**
     * Creates a new object of the
     * TemperatureSeriesAnalysis class.
     *
     * @param temperatureSeries series of the temperatures
     */

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temp : temperatureSeries) {
            if (temp < maxMinValue) {
                this.temperatureSeries = new double[capacity];
                this.amountOfTemperatures = 0;
                throw new InputMismatchException("Wrong values in series!");
            }
        }
        this.temperatureSeries = temperatureSeries;
        this.amountOfTemperatures = temperatureSeries.length;
    }

    /**
     * Calculates and returns average value of the
     * temperature series;
     *
     * @return average value of the temperature series
     */

    public double average() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        double averageTemp;
        double temperatures = 0;
        int counter = 0;
        for (double temp : temperatureSeries) {
            if (counter == amountOfTemperatures) {
                break;
            }
            temperatures += temp;
            counter++;
        }
        averageTemp = temperatures / amountOfTemperatures;
        return averageTemp;
    }

    /**
     * Calculates and returns deviation value of the
     * temperature series;
     *
     * @return deviation value of the temperature series
     */

    public double deviation() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        double deviation;
        double averageTemp = this.average();
        double variance = 0;
        int counter = 0;
        for (double temp : temperatureSeries) {
            if (counter == amountOfTemperatures) {
                break;
            }
            double diff = temp - averageTemp;
            double tempValue = Math.pow(diff, 2);
            variance += tempValue;
            counter++;
        }
        deviation = Math.sqrt((variance / amountOfTemperatures));
        return deviation;
    }

    /**
     * Helpful method for min and max functions that
     * finds and returns min or max value of the
     * temperature series due to the parameter.
     *
     * @param value a value we need to find min or max
     * @return min or max value of the temperature series
     */

    public double helpfulMinMax(String value) {
        double minOrMax = temperatureSeries[0];
        int counter = 0;
        for (double temp : temperatureSeries) {
            if (counter == amountOfTemperatures) {
                break;
            }
            if (temp < minOrMax && value.equals("min")) {
                minOrMax = temp;
            }
            else if (temp > minOrMax && value.equals("max")) {
                minOrMax = temp;
            }
        }
        return minOrMax;
    }

    /**
     * Finds and returns min value of the
     * temperature series;
     *
     * @return min value of the temperature series
     */

    public double min() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        double min;
        min = this.helpfulMinMax("min");
        return min;
    }

    /**
     * Finds and returns max value of the
     * temperature series.
     *
     * @return max value of the temperature series
     */

    public double max() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        double max;
        max = this.helpfulMinMax("max");
        return max;
    }

    /**
     * Finds and returns closest value to the zero
     * from the temperature series.
     *
     * @return closest value to zero
     */

    public double findTempClosestToZero() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        return findTempClosestToValue(0);
    }

    /**
     * Finds and returns closest value to the certain one
     * from the temperature series.
     *
     * @param tempValue a certain value
     * @return closest value from temperature series to the certain one
     */

    public double findTempClosestToValue(double tempValue) {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        double closest = temperatureSeries[0];
        double difference = Double.POSITIVE_INFINITY;
        for (double temp : temperatureSeries) {
            double tempDifference = Math.abs(tempValue - temp);
            if (tempDifference <= difference) {
                difference = tempDifference;
                if (Math.abs(tempValue - temp) == Math.abs(tempValue - closest)
                        && closest < temp) {
                    closest = temp;
                }
                else {
                    closest = temp;
                }
            }
        }
        return closest;
    }

    /**
     * Helpful method for findTempsLessThen and
     * findTempsGreaterThen functions that
     * finds and returns the amount of elements
     * greater or less than certain value.
     *
     * It is needed for the capacity of those
     * arrays.
     *
     * @param type a value that characterises the type of array
     * @param tempValue a certain value
     * @return amount of elements
     */

    public int countAmountOfElements(String type, double tempValue) {
        int temporaryCounter = 0;
        int counterTemp = 0;
        for (double temp : temperatureSeries) {
            if (counterTemp == amountOfTemperatures) {
                break;
            }
            if (temp < tempValue && type.equals("less")) {
                temporaryCounter += 1;
            }
            else if (temp >= tempValue && type.equals("greater")) {
                temporaryCounter += 1;
            }
            counterTemp++;
        }
        return temporaryCounter;
    }

    /**
     * Helpful method for findTempsLessThen and
     * findTempsGreaterThen functions that
     * finds and returns an array of such values of the
     * temperature series due to the parameter and needed value.
     *
     * @param value a value that characterises which array is needed to be found
     * @param tempValue a certain value
     * @return array with temperature values greater or less than given one
     */

    public double[] helpfulFind(String value, double tempValue) {

        int tempSeriesLength;
        if (value.equals("less")) {
            tempSeriesLength = this.countAmountOfElements(
                    "less", tempValue);
        }
        else {
            tempSeriesLength = this.countAmountOfElements(
                    "greater", tempValue);
        }
        double[] tempSeriesLessOrGreaterThen = new double[tempSeriesLength];
        int counter = 0;
        int counterTemp = 0;
        for (double temp : temperatureSeries) {
            if (counterTemp == amountOfTemperatures) {
                break;
            }
            if (temp < tempValue && value.equals("less")) {
                tempSeriesLessOrGreaterThen[counter] = temp;
                counter += 1;
            }
            else if (temp >= tempValue && value.equals("greater")) {
                tempSeriesLessOrGreaterThen[counter] = temp;
                counter += 1;
            }
            counterTemp++;
        }
        return tempSeriesLessOrGreaterThen;
    }

    /**
     * Finds and returns the array of temperatures
     * that are less than a certain value.
     *
     * @param tempValue a certain value
     * @return array of temperatures less then given one
     */

    public double[] findTempsLessThen(double tempValue) {
        double[] tempSeriesLess;
        tempSeriesLess = this.helpfulFind("less", tempValue);
        return tempSeriesLess;
    }

    /**
     * Finds and returns the array of temperatures
     * that are greater than a certain value.
     *
     * @param tempValue a certain value
     * @return array of temperatures greater then given one
     */

    public double[] findTempsGreaterThen(double tempValue) {
        double[] tempSeriesGreater;
        tempSeriesGreater = this.helpfulFind("greater", tempValue);
        return tempSeriesGreater;
    }

    /**
     * Creates and returns summary statistics of the analysis
     * of the temperatures.
     *
     * @return summary statistics of the analysis
     */

    public TempSummaryStatistics summaryStatistics() {
        if (amountOfTemperatures == 0) {
            throw new IllegalArgumentException("TempSeries is empty!");
        }
        TempSummaryStatistics statistics;
        statistics = new TempSummaryStatistics(this.average(),
                this.deviation(), this.min(), this.max());

        return statistics;
    }

    /**
     * Adds new values of the temperatures to the existing series and
     * adds all of them.
     *
     * @return the total sum of the temperatures in the series.
     */

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < maxMinValue) {
                throw new InputMismatchException("Wrong values in series!");
            }
        }
        int totalAmount;
        int amountTemps = temps.length;
        int index = amountOfTemperatures;
        int difference = temperatureSeries.length - amountOfTemperatures;
        if (difference < amountTemps) {
            double[] copy = new double[2*temperatureSeries.length];
            int length = temperatureSeries.length;
            System.arraycopy(temperatureSeries, 0, copy, 0, length);
            temperatureSeries = copy;
        }
        for (double temp : temps) {
            temperatureSeries[index] = temp;
            index++;
        }
        totalAmount = amountOfTemperatures + amountTemps;
        return totalAmount;
    }
}
