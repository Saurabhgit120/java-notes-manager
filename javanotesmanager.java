import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class javanotesmanager {
    public static void main(String[] args) throws Exception {
        int choice;
        Scanner sc = new Scanner(System.in);
        File file;
        FileWriter fw = null;
        BufferedWriter bw = null;

        FileReader fr = null;
        BufferedReader br = null;
        String notes;

        FileInputStream fis = null;
        FileOutputStream fos = null;

        System.out.println("__________Menu Driven Program__________");
        System.out.println(" press 1 for writing to a file (Write exit to stop writing)");
        System.out.println(" press 2 to read from a file and print to console");
        System.out.println(" press 3 to create a new file and write in it");
        System.out.println(" press 4 to copy the contents to the new file");
        System.out.println(" Press 5 to count the number of words, characters,lines and also find polymorphism count ");
        System.out.println(" Press 6 to exit form the file manager program");

        while (true) {
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1 -> {
                    try {
                        file = new File("javaFile.txt");
                        fw = new FileWriter(file, true);
                        bw = new BufferedWriter(fw);
                        while (true) {
                            notes = sc.nextLine();
                            if (notes.trim().isEmpty())
                                continue;
                            if (notes.trim().equals("exit")) {
                                break;
                            }
                            bw.write(notes);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("file was not created!" + e.getMessage());
                    } finally {
                        try {
                            if (bw != null)
                                bw.close();
                            if (fw != null)
                                fw.close();
                        } catch (IOException e) {
                            System.out.println("Error while closing" + e.getMessage());
                        }
                    }
                }

                case 2 -> {
                    try {
                        fr = new FileReader("javaFile.txt");
                        br = new BufferedReader(fr);

                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }

                    } catch (IOException e) {
                        System.out.println("File not Found" + e.getMessage());
                    } finally {
                        if (fr != null)
                            fr.close();
                        if (br != null)
                            br.close();
                    }
                }

                case 3 -> {
                    try {
                        file = new File("javaFile2.txt");
                        fw = new FileWriter(file, true);
                        bw = new BufferedWriter(fw);
                        while (true) {
                            notes = sc.nextLine();
                            if (notes.trim().isEmpty())
                                continue;
                            if (notes.trim().equals("exit")) {
                                break;
                            }
                            bw.write(notes);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("file was not created!" + e.getMessage());
                    } finally {
                        try {
                            if (bw != null)
                                bw.close();
                            if (fw != null)
                                fw.close();
                        } catch (IOException e) {
                            System.out.println("Error while closing" + e.getMessage());
                        }
                    }
                }

                case 4 -> {
                    try {
                        fis = new FileInputStream("javaFile.txt");
                        fos = new FileOutputStream("javaFile2.txt", true);

                        fos.write(System.lineSeparator().getBytes());
                        int ch;
                        while ((ch = fis.read()) != -1) {
                            // System.out.print(char(ch));
                            fos.write(ch);
                        }

                    } catch (IOException e) {
                        System.out.println("File not Found" + e.getMessage());
                    } finally {
                        if (fos != null)
                            fos.close();
                        if (fis != null)
                            fis.close();
                    }
                }

                case 5 -> {
                    try {
                        fr = new FileReader("javaFile.txt");
                        br = new BufferedReader(fr);

                        String line;
                        int lineNumber = 0;
                        int totalChars = 0;
                        int totalWords = 0;
                        int totalLines = 0;
                        int polymorphismOccurrences = 0;
                        String wordToFind = "polymorphism";

                        System.out.println("\nAnalyzing javaFile1.txt...\n");

                        while ((line = br.readLine()) != null) {
                            lineNumber++;
                            totalLines++;
                            totalChars += line.length();
                            String[] words = line.trim().split("\\s+");
                            totalWords += words.length;

                            if (line.toLowerCase().contains(wordToFind.toLowerCase())) {
                                System.out.println("Word \"" + wordToFind + "\" found at line: " + lineNumber);

                                for (String word : words) {
                                    if (wordToFind.equalsIgnoreCase(word.replaceAll("[^a-zA-Z]", ""))) {
                                        polymorphismOccurrences++;
                                    }
                                }
                            }
                        }

                        System.out.println("\nTotal characters: " + totalChars);
                        System.out.println("Total lines: " + totalLines);
                        System.out.println("Total words: " + totalWords);
                        System.out.println("Total occurrences of \"" + wordToFind + "\": " + polymorphismOccurrences);

                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    } finally {
                        if (fr != null)
                            fr.close();
                        if (br != null)
                            br.close();
                    }
                }
                case 6 -> {
                    System.out.println("exiting the program");
                    sc.close();
                    System.exit(0);
                }
            }
        }

    }

}
