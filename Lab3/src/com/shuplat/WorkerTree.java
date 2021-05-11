package com.shuplat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerTree {
    public List<List<Node>> workers;

    public WorkerTree() {
        this.workers = new ArrayList<>();
    }

    public void setWorker(List<Integer> worker) {
        List<Node> workerNodes = new ArrayList<>();
        if (workers.isEmpty()) {
            for (int workerBeer : worker) {
                if (workerBeer != 0) {
                    workerNodes.add(new Node(workerBeer));
                }
            }
        } else {
            List<Node> parentBeersNodes = workers.get(workers.size() - 1);
            List<Integer> parentBeers = new ArrayList<>();
            for (Node beerMode : parentBeersNodes) {
                parentBeers.add(beerMode.getBeerNumber());
            }

            for (int workerBeer : worker) {
                for (Node parentBeerNode: parentBeersNodes) {
                    if (parentBeers.contains(workerBeer) && parentBeerNode.getBeerNumber() != workerBeer) {
                        continue;
                    }
                    workerNodes.add(new Node(parentBeerNode, workerBeer));
                }
            }
        }
        workers.add(workerNodes);
    }

    public int findTheSmallestVarietyOfBeers() {
        int result = 0;

        for (Node beer: workers.get(workers.size() - 1)) {
            Set<Integer> solution = new HashSet<>();
            while (beer != null) {
                solution.add(beer.getBeerNumber());
                beer = beer.parent;
            }
            if (solution.size() < result || result == 0) {
                result = solution.size();
            }
        }
        return result;
    }

    class Node {
        public Node parent;
        public int beerNumber;

        public Node(Node parent, int beerNumber) {
            this.parent = parent;
            this.beerNumber = beerNumber;
        }

        public Node(int beerNumber) {
            this.beerNumber = beerNumber;
        }

        public int getBeerNumber() {
            return beerNumber;
        }

        @Override
        public String toString() {
            String parent = this.parent == null ? "Null" : String.valueOf(this.parent.getBeerNumber());
            return "Node{" +
                    "parent=" + parent +
                    ", beerNumber=" + beerNumber +
                    '}';
        }
    }
}
