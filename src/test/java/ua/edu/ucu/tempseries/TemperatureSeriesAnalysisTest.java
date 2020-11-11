package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.InputMismatchException;


/**
 * Tests for all methods for
 * TemperatureSeriesAnalysis
 * class.
 *
 * @author  Khrystyna Kokolus
 * @version 1.0
 */
public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis tempSeriesWithOneElement;
    private TemperatureSeriesAnalysis tempSeriesEmpty;
    private TemperatureSeriesAnalysis tempSeriesSameElements;
    private TemperatureSeriesAnalysis tempSeriesNormal;
    private TemperatureSeriesAnalysis tempSeriesSecondNormal;
    private TemperatureSeriesAnalysis tempSeriesOppositeValues;

    /**
     * Initialising needed variables.
     */
    @Before
    public void setUp(){
        double[] temperatureSeriesOne = {-1.0};
        double[] temperatureSeriesEmpty = {};
        double[] temperatureSeriesSameElements = {25.0, 25.0, 25.0};
        double[] temperatureSeriesNormal = {3.0, -5.0, 1.0, 5.0};
        double[] temperatureSeriesSecondNormal = {25.0, 30.0};
        double[] temperatureSeriesOpposite = {10.0, -1.0, 1.0, 12.0, 25.0, -10.0};
        this.tempSeriesWithOneElement = new TemperatureSeriesAnalysis(temperatureSeriesOne);
        this.tempSeriesEmpty = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        this.tempSeriesSameElements = new TemperatureSeriesAnalysis(temperatureSeriesSameElements);
        this.tempSeriesNormal = new TemperatureSeriesAnalysis(temperatureSeriesNormal);
        this.tempSeriesSecondNormal = new TemperatureSeriesAnalysis(temperatureSeriesSecondNormal);
        this.tempSeriesOppositeValues = new TemperatureSeriesAnalysis(temperatureSeriesOpposite);
    }

    /**
     * Tests for average method.
     */
    @Test
    public void testAverageWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = tempSeriesWithOneElement.average();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {

        // expect exception here
        tempSeriesEmpty.average();
    }

    @Test
    public void testAverageWithSameTemperatures() {
        double expResult = 25.0;
        double actualResult = tempSeriesSameElements.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;
        double actualResult = tempSeriesNormal.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for deviation method.
     */
    @Test
    public void testDeviationWithOneElementArray() {
        double expResult = 0.0;
        double actualResult = tempSeriesWithOneElement.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        // expect exception here
        tempSeriesEmpty.deviation();
    }

    @Test
    public void testDeviationWithSameTemperatures() {
        double expResult = 0.0;
        double actualResult = tempSeriesSameElements.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double expResult = 2.5;
        double actualResult = tempSeriesSecondNormal.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for min method.
     */
    @Test
    public void testMinWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = tempSeriesWithOneElement.min();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        // expect exception here
        tempSeriesEmpty.min();
    }

    @Test
    public void testMinWithSameTemperatures() {
        double expResult = 25.0;
        double actualResult = tempSeriesSameElements.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double expResult = -5.0;
        double actualResult = tempSeriesNormal.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for max method.
     */
    @Test
    public void testMaxWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = tempSeriesWithOneElement.max();


        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        // expect exception here
        tempSeriesEmpty.max();
    }

    @Test
    public void testMaxWithSameTemperatures() {
        double expResult = 25.0;
        double actualResult = tempSeriesSameElements.max();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testMax() {
        double expResult = 5.0;
        double actualResult = tempSeriesNormal.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for findTempClosestToZero method.
     */
    @Test
    public void testFindTempClosestToZeroElementArray() {
        double expResult = -1.0;
        double actualResult = tempSeriesWithOneElement.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        // expect exception here
        tempSeriesEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroWithSameTemperatures() {
        double expResult = 25.0;
        double actualResult = tempSeriesSameElements.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithSameDistanceValuesOppositeSigns(){
        double expResult = 1.0;
        double actualResult = tempSeriesOppositeValues.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        double expResult = 1.0;
        double actualResult = tempSeriesNormal.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for findTempClosestToValue method.
     */
    @Test
    public void testFindTempClosestToValueElementArray() {
        double expResult = -1.0;
        double actualResult = tempSeriesWithOneElement.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        // expect exception here
        tempSeriesEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValueWithSameTemperatures() {
        double expResult = 25.0;
        double actualResult = tempSeriesSameElements.findTempClosestToValue(100.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithSameDistanceValuesOppositeSigns(){
        double expResult = 10.0;
        double actualResult = tempSeriesOppositeValues.findTempClosestToValue(10.5);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double expResult = 5.0;
        double actualResult = tempSeriesNormal.findTempClosestToValue(100.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for findTempsLessThen method.
     */
    @Test
    public void testFindTempsLessThenElementArray() {
        double[] expResult = {-1.0};
        double[] actualResult = tempSeriesWithOneElement.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testFindTempsLessThenWithSameTemperatures() {
        double[] expResult = {25.0, 25.0, 25.0};
        double[] actualResult = tempSeriesSameElements.findTempsLessThen(100.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenEmpty() {
        double[] expResult = {0.0, 0.0, 0.0, 0.0};
        double[] actualResult = tempSeriesNormal.findTempsLessThen(-15.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] expResult = {-5.0, 1.0, 0.0, 0.0};
        double[] actualResult = tempSeriesNormal.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for findTempsGreaterThen method.
     */
    @Test
    public void testFindTempsGreaterThenElementArray() {
        double[] expResult = {-1.0};
        double[] actualResult = tempSeriesWithOneElement.findTempsGreaterThen(-3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithSameTemperatures() {
        double[] expResult = {25.0, 25.0, 25.0};
        double[] actualResult = tempSeriesSameElements.findTempsGreaterThen(15.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenEmpty() {
        double[] expResult = {0.0, 0.0, 0.0, 0.0};
        double[] actualResult = tempSeriesNormal.findTempsGreaterThen(15.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenThen() {
        double[] expResult = {3.0, 5.0, 0.0, 0.0};
        double[] actualResult = tempSeriesNormal.findTempsGreaterThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Tests for SummaryStatistics method.
     */
    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(-1.0, 0.0,
                -1.0, -1.0);
        TempSummaryStatistics actualResult = tempSeriesWithOneElement.summaryStatistics();


        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        // expect exception here
        tempSeriesEmpty.summaryStatistics();
    }

    @Test
    public void testSummaryStatisticsWithSameTemperatures() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(25.0, 0.0,
                25.0, 25.0);
        TempSummaryStatistics actualResult = tempSeriesSameElements.summaryStatistics();

        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }


    @Test
    public void testSummaryStatistics() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(27.5, 2.5,
                25.0, 30.0);
        TempSummaryStatistics actualResult = tempSeriesSecondNormal.summaryStatistics();

        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }

    /**
     * Tests for addTemps method.
     */
    @Test
    public void testAddTempsWithOneElementArray() {
        double expResult = 2;
        double actualResult = tempSeriesWithOneElement.addTemps(-1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithWrongValues() {
        // expect exception here
        tempSeriesEmpty.addTemps(-330.0, 100.0, -299.0);
    }

    @Test
    public void testAddTempsWithSameTemperatures() {
        double expResult = 5;
        double actualResult = tempSeriesSameElements.addTemps(25.0, 25.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double expResult = 7;
        double actualResult = tempSeriesNormal.addTemps(44.0, 99.7, 32.9);

        assertEquals(expResult, actualResult, 0.00001);
    }
}
