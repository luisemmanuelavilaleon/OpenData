package mx.com.od.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Point;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Antonio Pérez Romero
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Csv implements CsvInterface {

    private String csvName;
    private Point csvDimension;
    private String[] csvColumn;
    private List<String[]> csvRows;

    @Override
    public List<String[]> csvReadAll(Reader reader) throws Exception {
        List<String[]> list;
        try (CSVReader csvReader = new CSVReader(reader)) {
            list = new ArrayList<>();
            list = csvReader.readAll();
        }
        reader.close();
        return list;
    }

    @Override
    public List<String[]> csvOneByOne(Reader reader) throws Exception {
        List<String[]> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
            }
        }
        reader.close();
        return list;
    }

    @Override
    public void csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            stringArray.forEach((array) -> {
                writer.writeNext(array);
            });
        }
    }

    @Override
    public void csvWriterAll(List<String[]> stringArray, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(stringArray);
        }
    }

    @Override
    public String csvFindColumn(int columnIndex) {
        return csvIsColumn(columnIndex) ? this.getCsvColumn()[columnIndex] : "Doesn't exist";
    }

    @Override
    public String[] csvFindRow(int rowIndex) {
        return csvIsRow(rowIndex) ? this.getCsvRows().get(rowIndex) : new String[]{"Doesn't exist"};

    }

    @Override
    public String csvFinCell(Point p) {
        return csvIsCell(p) ? this.getCsvRows().get((int) p.getY())[(int) p.getX()] : "Doesn't exist";
    }

    @Override
    public boolean csvIsColumn(int columnIndex) {
        try {
            return this.getCsvColumn()[columnIndex].length() > 0;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(" >> Error (Csv IndexBoundsException |006) :" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean csvIsRow(int rowIndex) {
        try {
            return this.getCsvRows().get(rowIndex).length > 0;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(" >> Error (Csv IndexBoundsException |007) :" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean csvIsCell(Point p) {
        return csvIsRow(p.y) && csvIsColumn(p.x);
    }

    @Override
    public String csvChangeCellValue(Point p, String newValue, Path path) {
        if (csvIsCell(p)) {
            for (int i = 0; i < this.getCsvRows().size(); i++) {
                System.out.println(i);
                if (i == p.getY()) {
                    String[] row = this.getCsvRows().get(i);
                    for (int j = 0; j < row.length; j++) {
                        if (j == p.getX()) {
                            try {
                                row[j] = newValue;
                                this.csvWriterAll(this.getCsvRows(), path);
                                return "Cell up-to-date";
                            } catch (Exception ex) {
                                System.out.println(" >> Error (Csv IndexBoundsException |008) :" + ex.getMessage());
                            }
                        }
                    }
                }
            }
        } else {
            return " >> Error (Csv Cell Doesn't exist |009)";
        }
        return "S >> Error (Csv Cell Doesn't exist |009)";
    }

    @Override
    public void csvInfo() {
        System.out.println("Name: " + this.getCsvName());
        System.out.println("Columns: " + Arrays.toString(this.getCsvColumn()));
        System.out.println("Dimension: " + this.getCsvDimension());

        this.getCsvRows().forEach((s) -> {
            System.out.println(Arrays.toString(s));
        });
    }

}

