import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        if (args.length == 2){
            String command = args[0];
            String fileName = args[1];
            String fileAbsPath = "C:\\Users\\zmeui\\Projects\\Coding-Challenges\\Coding-Challenge-1\\" + fileName;
            File file = new File(fileAbsPath);
            System.out.println(l(fileAbsPath) + " " + w(fileAbsPath) + " " + c(file) + " " + fileName);
        }
        else {
            String command = args[0];
            String argument = args[1];
            String fileName = args[2];
            String fileAbsPath = "C:\\Users\\zmeui\\Projects\\Coding-Challenges\\Coding-Challenge-1\\" + fileName;
            File file = new File(fileAbsPath);

            if (command.equals("ccwc")){
             if (argument.equals("-c")){ //number of bytes in a file
                 System.out.println(c(file) + " " + fileName);
             }
             if (argument.equals("-l")){ //number of lines in a file
                 System.out.println(l(fileAbsPath) + " " + fileName);
             }
             if (argument.equals("-w")){ //number of words in a file

                 System.out.println(w(fileAbsPath) + " " + fileName);
             }
             if (argument.equals("-m")){ //number of chars in a file ???
                 Scanner scanner = new Scanner(new FileReader(fileAbsPath));
                 Long chars = 0L;
                 while (scanner.hasNextLine()) {
                     chars += scanner.nextLine().chars().count();
                 }
                 System.out.println(chars + " " + fileName);
             }

            }
            System.out.println("Command: " + command + " Argument: " + argument + " File Name: " + fileName);
        }
    }

    private static Long c(File file) {
        Long bytes = file.length();
        return bytes;
    }

    private static Long l(String fileAbsPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileAbsPath));
        Long lines = 0L;
        while(reader.readLine()!= null){
            lines++;
        }
        return lines;
    }

    private static Long w(String fileAbsPath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(fileAbsPath));
        Long words = 0L;
        while (scanner.hasNext()) {
            scanner.next();
            words++;
        }
        return words;
    }
}