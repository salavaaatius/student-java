
package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSampleTest {

    @Test
    void createsValidDataSample() {
        double[] features = {1.0, 2.0, 3.0};

        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.NEW,
                features
        );

        assertEquals("sample-1", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertArrayEquals(features, sample.getFeatures());
    }

    @Test
    void rejectsNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        null, "cat", SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "", "cat", SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "   ", "cat", SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsNullLabel() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", null, SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsEmptyLabel() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "", SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsBlankLabel() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "   ", SampleStatus.NEW,
                        new double[]{1.0}));
    }

    @Test
    void rejectsNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "cat", null,
                        new double[]{1.0}));
    }

    @Test
    void rejectsNullFeatures() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "cat", SampleStatus.NEW,
                        null));
    }

    @Test
    void rejectsEmptyFeatures() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "cat", SampleStatus.NEW,
                        new double[]{}));
    }

    @Test
    void rejectsNaNFeature() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "cat", SampleStatus.NEW,
                        new double[]{1.0, Double.NaN}));
    }

    @Test
    void rejectsInfiniteFeature() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "sample-1", "cat", SampleStatus.NEW,
                        new double[]{Double.POSITIVE_INFINITY}));
    }

    @Test
    void copiesFeaturesInConstructor() {
        double[] features = {1.0, 2.0, 3.0};

        DataSample sample = new DataSample(
                "sample-1", "cat", SampleStatus.NEW, features);

        features[0] = 100.0;

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0},
                sample.getFeatures());
    }

    @Test
    void returnsCopyOfFeatures() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.NEW,
                new double[]{1.0, 2.0, 3.0}
        );

        double[] returnedFeatures = sample.getFeatures();

        returnedFeatures[0] = 100.0;

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0},
                sample.getFeatures());
    }

    @Test
    void changesStatus() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.NEW,
                new double[]{1.0, 2.0}
        );

        sample.changeStatus(SampleStatus.LABELED);

        assertEquals(SampleStatus.LABELED, sample.getStatus());
    }

    @Test
    void rejectsNullNewStatus() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.NEW,
                new double[]{1.0}
        );

        assertThrows(IllegalArgumentException.class,
                () -> sample.changeStatus(null));
    }

    @Test
    void returnsFalseWhenSampleIsNotReady() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.NEW,
                new double[]{1.0}
        );

        assertFalse(sample.isReady());
    }

    @Test
    void returnsTrueWhenSampleIsReady() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.READY,
                new double[]{1.0}
        );

        assertTrue(sample.isReady());
    }

    @Test
    void calculatesAverageOfFeatures() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.READY,
                new double[]{2.0, 4.0, 6.0}
        );

        assertEquals(4.0, sample.averageFeatures(), 0.0001);
    }

    @Test
    void calculatesAverageOfNegativeFeatures() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.READY,
                new double[]{-2.0, -4.0, -6.0}
        );

        assertEquals(-4.0, sample.averageFeatures(), 0.0001);
    }
}
