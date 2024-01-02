package franxxcode.javacsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

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
}
