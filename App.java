package sg.edu.nus.iss;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws FileNotFoundException{
        String dirPath = "C:\\Users\\vince\\Root\\day04_workshop\\CookieFolder";
        File newDirectory = new File(dirPath);
        // if direcotry exist, print directory exists.
        // else create the directory
        if (newDirectory.exists()) {
            System.out.println("directory already exists.");
        } else {
            newDirectory.mkdir();
        }

    }
}
