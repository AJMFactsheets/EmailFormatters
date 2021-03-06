package philclubemailextractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input format is: xxx@xxx.com,
 * Output format is: <xxx@xxx.com>,
 * @author Andrew Mollenkamp
 */
public class PhilClubEmailExtractor {

    public static void main(String[] args) {
        final String INPUT_FILE = "input.dat";
        final String OUTPUT_FILE = "output.dat";
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(INPUT_FILE)));
            PrintWriter out = new PrintWriter(new FileWriter(new File(OUTPUT_FILE)));
            
            String inLine;
            int start, stop;
            String extractedData;
            StringBuilder outLine = new StringBuilder();
            
            while (in.ready()) {
                inLine = in.readLine();
                
                start = inLine.indexOf("<");
                stop = inLine.indexOf(">");
               
                extractedData = inLine.substring(start + 1, stop);
                
                outLine.append(extractedData);
                
                
                out.println(outLine.toString());
                outLine.setLength(0);
            }
            in.close();
            out.close();
        }
        catch (FileNotFoundException fx) {
            System.err.println("File " + INPUT_FILE + " Not found in main program directory");
        }
        catch (IOException ix) {
            System.err.println("IO Error reading file: " + INPUT_FILE);
        }
        finally {
            System.out.println("File successfully written");
        }
        
    }
    
}

