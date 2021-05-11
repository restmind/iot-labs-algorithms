package com.shuplat;

import com.shuplat.manager.CombineManager;
import com.shuplat.model.Combine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "src/com/shuplat/combines.csv"));
        String line;
        int index = 0, i = 0;
        Combine[] combines = new Combine[5];

        while ((line = reader.readLine()) != null) {
            Combine combine = new Combine();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    combine.setModel(data);
                else if (index == 1)
                    combine.setCapacityOfGrainInKg(parseInt(data));
                else if (index == 2)
                    combine.setFuelConsumptionOnOneHectare(parseInt(data));
                else if (index == 3)
                    combine.setEnginePowerInHorsePower(parseInt(data));
                else
                    System.out.println("Incorrect input data:" + data);
                index++;
            }
            index = 0;
            combines[i++] = combine;
        }
        reader.close();

        for (Combine combine: combines) {
            System.out.println(combine.toString());
        }


        CombineManager combineManager = new CombineManager();
        combineManager.insertionSortByCapacityOfGrainASC(combines);
        System.out.println("--------INSERTION SORT-----------");
        for (Combine combine: combines) {
            System.out.println(combine.toString());
        }
        combineManager.mergeSortByEnginePowerDESC(combines);
        System.out.println("------------MERGE SORT-------");
        for (Combine combine: combines) {
            System.out.println(combine.toString());
        }
    }
}

