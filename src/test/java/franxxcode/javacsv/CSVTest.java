package franxxcode.javacsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CSVTest {

    @Test
    void create() throws IOException {

        StringWriter writer = new StringWriter();

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        csvPrinter.printRecord("Mee", true, 100);
        csvPrinter.printRecord("Qee", true, 100);
        csvPrinter.flush();

        System.out.println(
                writer.getBuffer().toString()
        );

        assertNotNull(writer);
    }

    @Test
    void readCSV() throws IOException {

        CSVParser records = new CSVParser(
                Files.newBufferedReader(Path.of("sample.csv")),
                CSVFormat.DEFAULT
        );

        for (CSVRecord record : records) {
            System.out.println("Name: " + record.get(0));
            System.out.println("Success: " + record.get(1));
            System.out.println("Value: " + record.get(2));
        }
    }
}
