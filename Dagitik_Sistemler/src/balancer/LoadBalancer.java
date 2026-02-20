package balancer;

public interface LoadBalancer {
        int selectServer();
        void update(int serverIndex, double latency);

}
