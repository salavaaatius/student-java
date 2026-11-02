
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeanCenteringNormalizationTest {

    private final MeanCenteringNormalization normalization =
            new MeanCenteringNormalization();

    @Test
    void subtractsMeanFromValues() {
        double[] result = normalization.normalize(
                new double[]{1, 2, 3});

        assertArrayEquals(
                new double[]{-1, 0, 1},
                result,
                0.0001);
    }

    @Test
    void worksWithNegativeValues() {
        double[] result = normalization.normalize(
                new double[]{-2, 0, 2});

        assertArrayEquals(
                new double[]{-2, 0, 2},
                result,
                0.0001);
    }

    @Test
    void doesNotModifyOriginalArray() {
        double[] values = {2, 4, 6};

        normalization.normalize(values);

        assertArrayEquals(
                new double[]{2, 4, 6},
                values);
    }

    @Test
    void rejectsNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> normalization.normalize(null));
    }

    @Test
    void rejectsEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> normalization.normalize(new double[]{}));
    }
}
