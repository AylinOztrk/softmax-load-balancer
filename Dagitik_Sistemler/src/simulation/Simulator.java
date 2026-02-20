package simulation;

import balancer.LoadBalancer;
import environment.Server;

public class Simulator {

    public static SimulationResult run(
            Server[] servers,
            LoadBalancer balancer,
            int totalRequests) {

        double totalLatency = 0;

        for (int t = 0; t < totalRequests; t++) {

            int idx = balancer.selectServer();
            double latency = servers[idx].handleRequest();
            balancer.update(idx, latency);

            totalLatency += latency;
        }

        return new SimulationResult(
                totalLatency,
                totalLatency / totalRequests);
    }
}
