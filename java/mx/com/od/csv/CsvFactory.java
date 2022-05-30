package mx.com.od.csv;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Antonio Pérez Romero
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsvFactory {

    private String csvNameFactory;
    private Path pathCsvFactory;
    private Csv csvFactory;
    private List<String[]> writeDataCsvFactory;

    public CsvFactory(Path pathCsvFactory, String csvNameFactory) {
        this.pathCsvFactory = pathCsvFactory;
        this.csvFactory = new Csv();
        this.writeDataCsvFactory = new ArrayList<>();
        this.csvNameFactory = csvNameFactory;
    }

    public Csv readData(String action) {
        try {
            switch (action) {
                case "readAll":
                    configureCsv(this.getCsvFactory().csvReadAll(Files.newBufferedReader(this.getPathCsvFactory())));
                    return this.getCsvFactory();
                case "oneByOne":
                    configureCsv(this.getCsvFactory().csvOneByOne(Files.newBufferedReader(this.getPathCsvFactory())));
                    return this.getCsvFactory();
            }
        } catch (IOException ex1) {
            System.out.println(" >> Error (CsvFactory|001) :" + ex1.getMessage());
        } catch (Exception ex2) {
            System.out.println(" >> Error (CsvFactory|002) :" + ex2.getMessage());
        }
        return null;
    }

    public void writeData(String action, List<String[]> writeData) throws IOException, Exception {
        this.setWriteDataCsvFactory(writeData);
        try {
            switch (action) {
                case "writeOneByOne":
                    this.getCsvFactory().csvWriterOneByOne(this.getWriteDataCsvFactory(), this.getPathCsvFactory());
                    break;
                case "writeAll":
                    this.getCsvFactory().csvWriterAll(this.getWriteDataCsvFactory(), this.getPathCsvFactory());
                    break;
                default:
                    System.out.println(" >> Error (CsvFactory|003) : Option doesnt valid");
                    break;
            }
        } catch (IOException ex1) {
            System.out.println(" >> Error (CsvFactory|004) :" + ex1.getMessage());
        } catch (Exception ex2) {
            System.out.println(" >> Error (CsvFactory|005) :" + ex2.getMessage());
        }
    }

    public void configureCsv(List<String[]> csv) {
        this.getCsvFactory().setCsvName(this.getCsvNameFactory());
        this.getCsvFactory().setCsvDimension(new Point(csv.get(0).length, csv.size()-1));
        this.getCsvFactory().setCsvColumn(csv.get(0));
        this.getCsvFactory().setCsvRows(csv);
    }
}
