package com.shuplat;

public class Main {
    private static final int TOTAL_NUMBER_OF_COWS = 5;
    private static final int QUANTITY_OF_ANGRY_COWS = 3;
    private static final int[] FREE_SECTIONS_TO_SETTLE_COW = {1, 2, 4, 8, 9};

    public static void main(String[] args) {
        int mostLeftSectionForAngryCow = FREE_SECTIONS_TO_SETTLE_COW[0];
        int mostRightSectionForAngryCow = FREE_SECTIONS_TO_SETTLE_COW[FREE_SECTIONS_TO_SETTLE_COW.length - 1];
        int result = 0;

        while (mostLeftSectionForAngryCow < mostRightSectionForAngryCow) {
            int middle = mostLeftSectionForAngryCow
                    + (mostRightSectionForAngryCow - mostLeftSectionForAngryCow) / QUANTITY_OF_ANGRY_COWS;
            if (check(middle)) {
                result = middle;
                mostLeftSectionForAngryCow = middle + 1;
            }
            else {
                mostRightSectionForAngryCow = middle;
            }
        }
        System.out.println("The minimum value of the maximum distance is: " + result);
    }

    public static boolean check(int middle) {
        int settledAngryCowsCounter = 1;
        int tempLastSettledCow = FREE_SECTIONS_TO_SETTLE_COW[0];
        System.out.println("Chosen free sections for angry cow with max distance "+ middle + ": " + tempLastSettledCow);
        for (int iterator : FREE_SECTIONS_TO_SETTLE_COW) {
            if (iterator - tempLastSettledCow >= middle) {
                settledAngryCowsCounter++;
                tempLastSettledCow = iterator;
                System.out.println("Chosen free sections for angry cow with max distance "+ middle + ": " + tempLastSettledCow);
                System.out.println("settledAngryCowsCounter" + settledAngryCowsCounter);
                if (settledAngryCowsCounter >= QUANTITY_OF_ANGRY_COWS) {
                    return true;
                }
            }
        }
        return false;
    }
}
