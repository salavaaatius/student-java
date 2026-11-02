package edu.course.lab03;

import java.util.Arrays;

public class FeatureProcessor {

    private final NormalizationStrategy strategy;

    public FeatureProcessor(NormalizationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Normalization strategy cannot be null");
        }

        this.strategy = strategy;
    }

    public double[] process(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(
                    "Values cannot be null or empty");
        }

        return strategy.normalize(
                Arrays.copyOf(values, values.length));
    }
}
