package balancer;

import java.util.Random;

public class RandomBalancer implements LoadBalancer {

    private final Random random;
    private final int k;

    public RandomBalancer(int k, long seed) {
        this.k = k;
        this.random = new Random(seed);
    }

    @Override
    public int selectServer() {
        return random.nextInt(k);
    }

    @Override
    public void update(int serverIndex, double latency) {
        // no learning
    }
}
