package app;

import mpi.MPI;

public class App {
    public static void main(String[] args) {
        MPI.Init(args);
        System.out.println("Hello from Gradle!");
        MPI.Finalize();
    }
}
