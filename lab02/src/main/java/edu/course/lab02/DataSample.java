
package edu.course.lab02;

import java.util.Arrays;

public class DataSample {

    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;

    public DataSample(
            String id,
            String label,
            SampleStatus status,
            double[] features) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID cannot be null or empty");
        }

        if (label == null || label.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Label cannot be null or empty");
        }

        if (status == null) {
            throw new IllegalArgumentException(
                    "Status cannot be null");
        }

        if (features == null || features.length == 0) {
            throw new IllegalArgumentException(
                    "Features cannot be null or empty");
        }

        for (double feature : features) {
            if (!Double.isFinite(feature)) {
                throw new IllegalArgumentException(
                        "Features must contain finite values");
            }
        }

        this.id = id;
        this.label = label;
        this.status = status;
        this.features = Arrays.copyOf(features, features.length);
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public double[] getFeatures() {
        return Arrays.copyOf(features, features.length);
    }

    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException(
                    "Status cannot be null");
        }

        this.status = newStatus;
    }

    public boolean isReady() {
        return status == SampleStatus.READY;
    }

    public double averageFeatures() {
        double sum = 0;

        for (double feature : features) {
            sum += feature;
        }

        return sum / features.length;
    }
}
