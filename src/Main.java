import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
        Pattern mac = Pattern.compile("([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})");
        Pattern identifynum = Pattern.compile("\\d{2}([05][1-9]|[16][0-2])[0-3][0-9]/?[0-9]{4}");
        Pattern plate = Pattern.compile("[A-Z]{2}[0-9]{3}[A-Z]{2}+");

        BufferedReader buffreader = new BufferedReader(new FileReader("C:\\Users\\AdminPC\\Desktop\\rawText.txt"));
        String line=null;
        FileWriter writermac = new FileWriter("mac.txt");
        FileWriter writeridentifynum = new FileWriter("identifynum.txt");
        FileWriter writerplate = new FileWriter("plate.txt");

        while((line = buffreader.readLine())!=null) {
            Matcher mspz =plate.matcher(line);

            while(mspz.find()) {
                int start = mspz.start(0);
                int end = mspz.end(0);
                writerplate.write(line.substring(start,end));
                writerplate.write(",");
                writerplate.flush();
                }

            Matcher mmac = mac.matcher(line);
            while (mmac.find()) {
                int start = mmac.start(0);
                int end = mmac.end(0);
                writermac.write(line.substring(start,end));
                writermac.write(",");
                writermac.flush();
            }

            Matcher mrod = identifynum.matcher(line);
            while(mrod.find())
            {
                int start = mrod.start(0);
                int end = mrod.end(0);
                writeridentifynum.write(line.substring(start,end));
                writeridentifynum.write(",");
                writeridentifynum.flush();
            }

        }
        writerplate.close();
        writermac.close();
        writeridentifynum.close();

    }
        catch(IOException e)
    {
        e.getMessage();
    }
}
    }
