
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeatureProcessorTest {

    @Test
    void processesFeaturesUsingMinMaxStrategy() {
        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        double[] result = processor.process(
                new double[]{2, 4, 6});

        assertArrayEquals(
                new double[]{0, 0.5, 1},
                result,
                0.0001);
    }

    @Test
    void processesFeaturesUsingMeanCenteringStrategy() {
        FeatureProcessor processor =
                new FeatureProcessor(new MeanCenteringNormalization());

        double[] result = processor.process(
                new double[]{1, 2, 3});

        assertArrayEquals(
                new double[]{-1, 0, 1},
                result,
                0.0001);
    }

    @Test
    void differentStrategiesCanBeUsedWithoutChangingProcessor() {
        double[] features = {2, 4, 6};

        FeatureProcessor minMax =
                new FeatureProcessor(new MinMaxNormalization());

        FeatureProcessor meanCentering =
                new FeatureProcessor(new MeanCenteringNormalization());

        assertArrayEquals(
                new double[]{0, 0.5, 1},
                minMax.process(features),
                0.0001);

        assertArrayEquals(
                new double[]{-2, 0, 2},
                meanCentering.process(features),
                0.0001);
    }

    @Test
    void doesNotModifyInputArray() {
        double[] features = {2, 4, 6};

        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        processor.process(features);

        assertArrayEquals(
                new double[]{2, 4, 6},
                features);
    }

    @Test
    void rejectsNullStrategy() {
        assertThrows(IllegalArgumentException.class,
                () -> new FeatureProcessor(null));
    }

    @Test
    void rejectsNullInput() {
        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        assertThrows(IllegalArgumentException.class,
                () -> processor.process(null));
    }
}
