package utils;

import mpi.MPI;

public class MPJUtils {
    public static boolean isMaster() {
        return MPI.COMM_WORLD.Rank() == 0;
    }
    public static int Rank() {
        return MPI.COMM_WORLD.Rank();
    }
    public static int Master() {
        return 0;
    }
    public static int Size() {
        return MPI.COMM_WORLD.Size();
    }
}
