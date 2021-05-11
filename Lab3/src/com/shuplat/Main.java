package com.shuplat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int QUANTITY_OF_WORKERS = 6;
    private static final int VARIETY_OF_BEERS = 3;
    private static final String INPUT_STRING = "NNY YNN YNY NYY NYY NYN";


    public static void main(String[] args) {
        List<List<Integer>> data = convertInputData(INPUT_STRING);
        WorkerTree workerTree = new WorkerTree();
        for (List<Integer> worker: data) {
            workerTree.setWorker(worker);
        }
        for (List<WorkerTree.Node> worker: workerTree.workers) {
                System.out.println(worker);
        }

        System.out.println("The most reasonable quantity of beers is " + workerTree.findTheSmallestVarietyOfBeers());
    }

    public static List<List<Integer>> convertInputData(String input) {
        String[] inputArr = input.split(" ");
        List<List<Integer>> workers = new ArrayList<>();
        for (int i = 0; i < QUANTITY_OF_WORKERS; i++) {
            char[] beers = inputArr[i].toCharArray();
            List<Integer> workerBeers = new ArrayList<>();
            for (int k = 0; k < VARIETY_OF_BEERS; k++) {
                if (beers[k] == 'Y') {
                    workerBeers.add(k + 1);
                }
            }
            workers.add(workerBeers);
        }

        return workers;
    }
}
