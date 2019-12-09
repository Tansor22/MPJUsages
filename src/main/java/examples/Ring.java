package examples;

import mpi.MPI;

import static utils.MPJUtils.*;

public class Ring {
    public static void main(String[] args) {
        MPI.Init(args);
        int[] token = new int[1];
        if (!isMaster()) {
            MPI.COMM_WORLD.Recv(token, 0,1, MPI.INT, Rank() - 1, 0);
            System.out.printf("Process %d received token %d from process %d\n", Rank(), token[0], Rank() - 1);
        } else {
            // master sets value
            token[0] = -1;
        }
        MPI.COMM_WORLD.Send(token, 0,1, MPI.INT, (Rank() + 1) % Size(), 0);
        if (isMaster()) {
            MPI.COMM_WORLD.Recv(token, 0, 1, MPI.INT, Size() - 1, 0);
            System.out.printf("Process %d received token %d from process %d\n", Rank(), token[0], Size() - 1);
        }
        MPI.Finalize();

    }
}
