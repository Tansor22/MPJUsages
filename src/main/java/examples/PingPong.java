package examples;

import mpi.MPI;
import mpi.Status;

import static utils.MPJUtils.*;

public class PingPong {
    private static final int PING_PONG_LIMIT = 100;
    public static void main(String[] args) {
        MPI.Init(args);
        int[] pingPongCount = {0};
        int partnerRank = (Rank() + 1) % 2;
        while (pingPongCount[0] < PING_PONG_LIMIT) {
            if (Rank() == pingPongCount[0] % 2) {
                pingPongCount[0]++;
                // sending pingPongCount var to partnerRank with tag 0
                MPI.COMM_WORLD.Send(pingPongCount, 0, 1, MPI.INT, partnerRank, 0);
                System.out.printf("%d sent and incremented pingPongCount %d to %d\n", Rank(), pingPongCount[0], partnerRank);
            } else {
                MPI.COMM_WORLD.Recv(pingPongCount, 0, 1, MPI.INT, partnerRank, 0);
                System.out.printf("%d received pingPongCount %d from %d\n", Rank(), pingPongCount[0], partnerRank);
            }
        }
        MPI.Finalize();
    }
}
