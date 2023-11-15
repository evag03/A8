import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class AnimalGuess {

    private DecisionTree gameTree;
    private Scanner readInput;
    private PrintWriter writeInto;
    public AnimalGuess(String fileName) {
        //fileReader(fileName);
    }

    public DecisionTree treeCreator(String fileName) {        
        try {
        File file = new File(fileName);
        readInput = new Scanner(file);
        }
        catch (FileNotFoundException e) {
        System.err.println("Cannot locate file.");
        System.exit(-1);
        }
        
        String line = readInput.nextLine();
        String lineQuestion = line.substring(line.indexOf(" ") + 1, line.length());
        DecisionTree root = new DecisionTree(lineQuestion);
        while (readInput.hasNextLine()) {
            line = readInput.nextLine();
            int intIndex = line.indexOf(" ");
            String path = line.substring(0, intIndex - 1);
            String data = line.substring((intIndex + 1));
            if (line.substring(path.length(), intIndex).equals("Y")) {
                root.followPath(path).setLeft(new DecisionTree(lineQuestion));
            }
            else if (line.substring(path.length(), intIndex).equals("N")) {
                root.followPath(path).setRight(new DecisionTree(lineQuestion));
            }            
        }
        readInput.close();
        return root;
    }

    public void fileCreator(String path, String data) {
        if (path.isEmpty()) {
            gameTree = new DecisionTree (data);
        }
        else {
            gameTree.followPath(data); 
            // gameTree.setLeft(data);
        }
    }
    // storing node and path at same time, printing out
    // add root to queue
    // add empty path to path queue
    // while queue is not empty (will never be not empty until last lvl)
    // store inside variable
    // .poll to get queue
    // 

    public static void main(String[] args) {
        DecisionTree isMammal = new DecisionTree("Is it a mammal?");
        DecisionTree hasHooves = new DecisionTree("Does it have hooves?");
        isMammal.setLeft(hasHooves);
        DecisionTree isReptile = new DecisionTree("Is it a reptile?");
        isMammal.setRight(isReptile);
        DecisionTree isGiveMilk = new DecisionTree("Does it give milk?");
        hasHooves.setLeft(isGiveMilk);
        DecisionTree isCarnivore = new DecisionTree("Is it a carnivore?");
        hasHooves.setRight(isCarnivore);
        DecisionTree isDogFamily = new DecisionTree("Is it in the dog family?");
        isCarnivore.setLeft(isDogFamily);
        DecisionTree currentNode = isMammal.followPath("YNYN");
        
        if(args.length > 0) {
            new AnimalGuess(args[0]);
        }

        Scanner userInput = new Scanner(System.in);

        int guessing_round = 0;
        //outer loop: whole game
        //inner loop: only while still navigating through tree/answering questions    


    //public DecisionTree readFile(String filename) {}


        // while (guessing_round != DecisionTree.length) {
        //   String user_response = userInput.nextLine();
        
        // }
        // while (DecisionTree != is.Leaf()) {

        // }


        //     catch (IllegalArgumentException e) {
        //         System.err.println("Invalid input. Only Y and N inputs accepted.");
        //         }
    }
}

