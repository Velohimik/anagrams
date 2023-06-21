package ua.com.foxminded.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMaker {
    
    /*
     * This method gets two strings: input sentence for Anagrams app and expected result of Anagrams work.
     * Adds input sentence to previously prepared string array of powershell commands. Sends obtained array to
     * runCommands(), receives from it real result of Anagrams work and compares expected and real results.
     * Depends on comparison result returns either 0 or 1.
     */
    public int makeTest(String inputSentence, String expectedResult) {
        String[] commands = {"powershell.exe", "java -cp .\\dist\\anagrams.jar ua.com.foxminded.anagrams.Main " + inputSentence};
        String realResult = runCommands(commands);

        return (expectedResult.equals(realResult) ? 0 : 1);
    }

    /*
     * This method gets string array of powershell commands and executes them. Then catches standard output 
     * of executed commands using streams, writes it in the string and returns.
     */
    private String runCommands(String[] commands) {
        String line;
        String catchedOutput = "";

        try {
            Process commandExcecutor = Runtime.getRuntime().exec(commands);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(commandExcecutor.getInputStream()));
            StringBuilder outputString = new StringBuilder();
            while ((line = inputStream.readLine()) != null) {
                outputString.append(line + "\n");
            }
            catchedOutput = outputString.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return catchedOutput;
    }
}