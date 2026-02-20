package balancer;

public class RoundRobinBalancer implements LoadBalancer {

    private final int k;
    private int pointer = 0;

    public RoundRobinBalancer(int k) {
        this.k = k;
    }

    @Override
    public int selectServer() {
        int selected = pointer;
        pointer = (pointer + 1) % k;
        return selected;
    }

    @Override
    public void update(int serverIndex, double latency) {
        // no learning
    }
}
