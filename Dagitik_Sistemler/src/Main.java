import balancer.*;
import environment.Server;
import simulation.Simulator;
import simulation.SimulationResult;
import simulation.*;

public class Main {

    public static void main(String[] args) {

        int K = 5;
        int totalRequests = 10000;
        int runs = 30;

        double softmaxAvg = 0;
        double rrAvg = 0;
        double randomAvg = 0;

        for (int r = 0; r < runs; r++) {

            Server[] s1 = createServers(K, r);
            Server[] s2 = createServers(K, r);
            Server[] s3 = createServers(K, r);

            LoadBalancer softmax =
                    new SoftmaxBalancer(K, 0.5, 0.1, r);

            LoadBalancer rr =
                    new RoundRobinBalancer(K);

            LoadBalancer random =
                    new RandomBalancer(K, r);

            softmaxAvg +=
                    Simulator.run(s1, softmax, totalRequests)
                            .getAverageLatency();

            rrAvg +=
                    Simulator.run(s2, rr, totalRequests)
                            .getAverageLatency();

            randomAvg +=
                    Simulator.run(s3, random, totalRequests)
                            .getAverageLatency();
        }

        System.out.println("===== FINAL RESULTS =====");
        System.out.println("Softmax Avg Latency: " + softmaxAvg / runs);
        System.out.println("RoundRobin Avg Latency: " + rrAvg / runs);
        System.out.println("Random Avg Latency: " + randomAvg / runs);
    }

    private static Server[] createServers(int K, int seed) {
        Server[] servers = new Server[K];
        for (int i = 0; i < K; i++) {
            servers[i] =
                    new Server(20 + i * 10,
                            seed + i,
                            0.3,
                            2.0);
        }
        return servers;
    }
}