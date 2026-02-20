package balancer;

import java.util.Arrays;
import java.util.Random;

public class SoftmaxBalancer implements LoadBalancer {

    private final double[] qValues;
    private final double tau;
    private final double alpha;
    private final Random random;

    public SoftmaxBalancer(int k, double tau, double alpha, long seed) {
        if (tau <= 0) throw new IllegalArgumentException("Tau must be > 0");
        this.qValues = new double[k];
        this.tau = tau;
        this.alpha = alpha;
        this.random = new Random(seed);
        Arrays.fill(qValues, 0.0);
    }

    @Override
    public int selectServer() {

        double maxQ = Arrays.stream(qValues).max().orElse(0.0);

        double[] expValues = new double[qValues.length];
        double sum = 0;

        for (int i = 0; i < qValues.length; i++) {
            expValues[i] = Math.exp((qValues[i] - maxQ) / tau);
            sum += expValues[i];
        }

        double r = random.nextDouble();
        double cumulative = 0;

        for (int i = 0; i < expValues.length; i++) {
            cumulative += expValues[i] / sum;
            if (r <= cumulative) return i;
        }

        return expValues.length - 1;
    }

    @Override
    public void update(int serverIndex, double latency) {

        double reward = -latency; // stable reward

        qValues[serverIndex] +=
                alpha * (reward - qValues[serverIndex]);
    }
}
