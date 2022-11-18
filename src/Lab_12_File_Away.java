import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Lab_12_File_Away {
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        File selectedFile = null;
        String line;
        ArrayList<String> lines = new ArrayList<>();

        try{
            File workingDirctory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirctory);

            chooser.showOpenDialog(null);

            if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                //if the user selects a file
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                Paths.get("");

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int lineNumber = 0;
                while(reader.ready()){
                    line = reader.readLine();
                    lines.add(line);
                    lineNumber++;
                    System.out.printf("\n %-4s ---> %-60s ", line, lines);
                }
                String line4 = lines.get(3);
                String[] wordsInLine4 = line4.split(", ");

                System.out.println(" ");
                for (String word: wordsInLine4){
                    System.out.println(word);
                }


                reader.close();
                System.out.println("File read successfully!");


            }else{
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again");
                System.exit(0);
            }
        } catch(IOException ex){
            ex.printStackTrace();

        }
        System.out.println("The file you have chosen is: " + chooser.getSelectedFile());
        int countwords = (int) chooser.getSelectedFile().length();
        System.out.println("The amount of words in this file is: " + countwords);
        int countlines = (int) chooser.getSelectedFile().length();
        Scanner sc = new Scanner(chooser.getSelectedFile());
        while(sc.hasNextLine()){
            sc.nextLine();
            countlines++;
        }
        System.out.println("The amount of lines in this file is: " + countlines);
        int countCharacters = (int) chooser.getSelectedFile().length();
        Scanner fc = new Scanner(chooser.getSelectedFile());
        while(fc.hasNextLine()){
            fc.nextLine();
            countCharacters++;
        }
        System.out.println("The amount of characters in this file is: " + countCharacters);




    }
}
