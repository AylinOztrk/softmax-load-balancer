package simulation;

public class SimulationResult {

    private final double totalLatency;
    private final double averageLatency;

    public SimulationResult(double totalLatency,
                            double averageLatency) {
        this.totalLatency = totalLatency;
        this.averageLatency = averageLatency;
    }

    public double getTotalLatency() {
        return totalLatency;
    }

    public double getAverageLatency() {
        return averageLatency;
    }
}