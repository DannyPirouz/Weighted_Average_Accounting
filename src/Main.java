import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This will determine your cost of goods sold, gross margin, and ending inventory using the weighted-average method for a perpetual inventory system.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many units are in your beginning inventory?");
        double units = scanner.nextDouble();
        System.out.println("How much does each unit cost?");
        double unitCost = scanner.nextDouble();
        double weightedAvgCost = unitCost;
        double cogas = units * unitCost;
        double cogs = 0;
        double grossMargin;
        double salesCounter = 0;

        System.out.println("How many units did you sell from the beginning of the period until your next inventory purchase?");
        double sales = scanner.nextDouble();
        double runningUnitCount = units - sales;
        cogs = (sales * weightedAvgCost) + cogs;
        salesCounter = salesCounter + sales;

        System.out.println("Have you accounted for all inventory purchases and sales for the period? Please enter \"y\" or \"n\".");
        String response = scanner.next();

        while (response.equals("n")) {

            System.out.println("How many units did you buy for your next inventory purchase?");
            double units2 = scanner.nextDouble();
            System.out.println("How much did each unit cost?");
            double cost2 = scanner.nextDouble();
            runningUnitCount = runningUnitCount + units2;
            cogas = cogas + (units2 * cost2);
            weightedAvgCost = cogas / runningUnitCount;

            System.out.println("How many units did you sell until your next inventory purchase?");
            sales = scanner.nextDouble();
            runningUnitCount = runningUnitCount - sales;
            cogas = cogas - (sales * weightedAvgCost);
            cogs = cogs + (sales * weightedAvgCost);
            salesCounter = salesCounter + sales;
            System.out.println("Have you accounted for all inventory purchases and sales for the period? Please enter \"y\" or \"n\".");
            response = scanner.next();
        }

        double roundAvgCost = Math.round(weightedAvgCost * 100.0) / 100.0;
        System.out.println("How much is each unit sold for?");
        double sellingPrice = scanner.nextDouble();
        grossMargin = (salesCounter * sellingPrice) - cogs;
        double roundCogs = Math.round(cogs * 100.0) / 100.0;
        double roundGrossMargin = Math.round(grossMargin * 100.0) / 100.0;
        double roundCogas = Math.round(cogas * 100.0) / 100.0;

        System.out.println("Your cost of goods sold is $" + roundCogs);
        System.out.println("Your gross margin is $" + roundGrossMargin);
        System.out.println("Your ending inventory is " + runningUnitCount + " units at $" + roundAvgCost +
                " each for a total cost of goods available of $" + roundCogas);


    }
}