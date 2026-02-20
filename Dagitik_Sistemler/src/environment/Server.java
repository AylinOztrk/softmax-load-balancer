package environment;

import java.util.Random;

public class Server {
    private double meanLatency;
    private final Random random;

    private final double driftStd;
    private final double noiseStd;

    public Server(double initialMean, long seed,
                  double driftStd, double noiseStd) {
        this.meanLatency = initialMean;
        this.random = new Random(seed);
        this.driftStd = driftStd;
        this.noiseStd = noiseStd;
    }

    public double handleRequest() {
        // Random walk drift (non-stationary)
        meanLatency += random.nextGaussian() * driftStd;
        meanLatency = Math.max(5, meanLatency);

        double latency = meanLatency + random.nextGaussian() * noiseStd;
        return Math.max(1, latency);
    }

    public double getMeanLatency() {
        return meanLatency;
    }
}