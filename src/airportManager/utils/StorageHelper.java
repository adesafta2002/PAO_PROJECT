package airportManager.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StorageHelper {
    private static final StorageHelper instance = new StorageHelper();

    public ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> readFromFileReturn = new ArrayList<String>();
        try {
            File readFile = new File("src/airportManager/csv/" + fileName);
            Scanner scanner = new Scanner(readFile);
            while (scanner.hasNextLine()) {
                String csvLine = scanner.nextLine();
                readFromFileReturn.add(csvLine);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading from file: " + fileName);

        }
        return  readFromFileReturn;
    }

    public void writeToFile(String rowToInsert, String fileName){
        try {
            FileWriter writer = new FileWriter("src/airportManager/csv/" + fileName,true);
            writer.write(rowToInsert + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + fileName);
        }
    }

    public void logActivity(String action){
        try {
            FileWriter writer = new FileWriter("src/airportManager/csv/AuditCsv.txt",true);
            writer.write(action +"," + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to audit");
        }
    }

    private StorageHelper(){}

    public static StorageHelper getInstance(){
        return instance;
    }
}
