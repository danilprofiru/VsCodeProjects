package lab8;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new TransformHandler());
        dataManager.registerDataProcessor(new FilterHandler());

        dataManager.loadData("C:\\Users\\danil\\VsCodeProjects\\sem3\\lab8\\source.txt");

        dataManager.processData();

        while (!dataManager.getExecutorService().isTerminated()) {
        }
        dataManager.saveData("C:\\Users\\danil\\VsCodeProjects\\sem3\\lab8\\destination.txt");
    }
}
