package mx.com.od.test;

import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import mx.com.od.csv.Csv;
import mx.com.od.csv.CsvFactory;

/**
 *
 * @author Antonio Pérez Romero
 */
public class CsvTest {

    public static void main(String[] args) {
        CsvFactory csvFactory = new CsvFactory(Paths.get("C:\\Open_Data_Project\\Admission_Predict.csv"), "Admission_Predict.csv");
        Csv csv = csvFactory.readData("readAll");

        testCsvFindCell(csv);
        /*
        testCsvGeneralInfo(csv);
        testCsvIsRow(csv);
        testCsvIsColumn(csv);
        testCsvIsCell(csv);
        testCsvFindColumn(csv);
        testCsvFindRow(csv);
        testCsvFindCell(csv);
        testCsvChangeCellValue(csv,csvFactory.getPathCsvFactory());
        */

        /* FALTA VALIDAR SI EXISTE EL CSV*/
    }

    public static void testCsvGeneralInfo(Csv csv) {
        /* csvInfo()
        *
        *   Devuelve informacion general del CSV
        * */
        csv.csvInfo();

    }

    public static void testCsvIsColumn(Csv csv) {
        /* csvIsColumn()
        *  
        *  Devuelve valor si la columna existe
        **/

        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Columns: " + Arrays.toString(csv.getCsvColumn()));
        System.out.println("Answer(0): " + csv.csvIsColumn(0));
        System.out.println("Answer(1): " + csv.csvIsColumn(1));
        System.out.println("Answer(2): " + csv.csvIsColumn(2));
        System.out.println("Answer(3): " + csv.csvIsColumn(3));
        System.out.println("Answer(8): " + csv.csvIsColumn(8));
        System.out.println("Answer(9): " + csv.csvIsColumn(9));
        System.out.println("Answer(10): " + csv.csvIsColumn(10));

    }

    public static void testCsvIsRow(Csv csv) {
        /* csvIsRow()
        *  
        *  Devuelve valor si el renglon existe
        **/
        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Answer(0): " + csv.csvIsRow(0));
        System.out.println("Answer(1): " + csv.csvIsRow(1));
        System.out.println("Answer(2): " + csv.csvIsRow(2));
        System.out.println("Answer(100): " + csv.csvIsRow(100));
        System.out.println("Answer(300): " + csv.csvIsRow(300));
        System.out.println("Answer(399): " + csv.csvIsRow(399));
        System.out.println("Answer(400): " + csv.csvIsRow(400));
        System.out.println("Answer(401): " + csv.csvIsRow(401));
        System.out.println("Answer(402): " + csv.csvIsRow(401));
    }

    public static void testCsvIsCell(Csv csv) {
        /* csvIsCell()
        *  
        *  Devuelve valor si la celda existe(X,Y)
        **/
        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Answer(0,100): " + csv.csvIsCell(new Point(0, 100)));
        System.out.println("Answer(1,100): " + csv.csvIsCell(new Point(1, 100)));
        System.out.println("Answer(8,100): " + csv.csvIsCell(new Point(8, 100)));
        System.out.println("Answer(9,100): " + csv.csvIsCell(new Point(9, 100)));

        System.out.println("Answer(1,0): " + csv.csvIsCell(new Point(1, 0)));
        System.out.println("Answer(1,1): " + csv.csvIsCell(new Point(1, 1)));
        System.out.println("Answer(1,399): " + csv.csvIsCell(new Point(1, 399)));
        System.out.println("Answer(1,400): " + csv.csvIsCell(new Point(1, 400)));
        System.out.println("Answer(1,401): " + csv.csvIsCell(new Point(1, 401)));
        System.out.println("Answer(1,402): " + csv.csvIsCell(new Point(1, 402)));
    }

    public static void testCsvFindColumn(Csv csv) {
        /* csvFindColumn()
        *  
        *  Devuelve valor de la columna 
        **/

        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Columns: " + Arrays.toString(csv.getCsvColumn()));
        System.out.println("Answer(-1): " + csv.csvFindColumn(-1));
        System.out.println("Answer(0): " + csv.csvFindColumn(0));
        System.out.println("Answer(1): " + csv.csvFindColumn(1));
        System.out.println("Answer(2): " + csv.csvFindColumn(2));
        System.out.println("Answer(3): " + csv.csvFindColumn(3));
        System.out.println("Answer(8): " + csv.csvFindColumn(8));
        System.out.println("Answer(9): " + csv.csvFindColumn(9));
        System.out.println("Answer(10): " + csv.csvFindColumn(10));
    }

    public static void testCsvFindRow(Csv csv) {
        /* csvIsRow()
        *  
        *  Devuelve valor del renglon 
        **/
        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Answer(-1): " + Arrays.toString(csv.csvFindRow(-1)));
        System.out.println("Answer(0): " + Arrays.toString(csv.csvFindRow(0)));
        System.out.println("Answer(1): " + Arrays.toString(csv.csvFindRow(1)));
        System.out.println("Answer(2): " + Arrays.toString(csv.csvFindRow(2)));
        System.out.println("Answer(100): " + Arrays.toString(csv.csvFindRow(100)));
        System.out.println("Answer(300): " + Arrays.toString(csv.csvFindRow(300)));
        System.out.println("Answer(399): " + Arrays.toString(csv.csvFindRow(399)));
        System.out.println("Answer(400): " + Arrays.toString(csv.csvFindRow(400)));
        System.out.println("Answer(401): " + Arrays.toString(csv.csvFindRow(401)));
    }

    public static void testCsvFindCell(Csv csv) {

        /* csvFindCell()
        *  
        *  Devuelve valor de la celda(X,Y)
        **/
        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Answer(0,100): " + csv.csvFinCell(new Point(0, 100)));
        System.out.println("Answer(1,100): " + csv.csvFinCell(new Point(1, 100)));
        System.out.println("Answer(8,100): " + csv.csvFinCell(new Point(8, 100)));
        System.out.println("Answer(9,100): " + csv.csvFinCell(new Point(9, 100)));

        System.out.println("Answer(1,0): " + csv.csvFinCell(new Point(1, 0)));
        System.out.println("Answer(1,1): " + csv.csvFinCell(new Point(1, 1)));
        System.out.println("Answer(1,399): " + csv.csvFinCell(new Point(1, 399)));
        System.out.println("Answer(1,400): " + csv.csvFinCell(new Point(1, 400)));

    }

    public static void testCsvChangeCellValue(Csv csv, Path path) {
        /* csvFindCell()
        *  
        *  Devuelve valor de la celda(X,Y)
        *  No cambiar indices
        **/
        String newValue = "34";
        System.out.println("Dimension: " + csv.getCsvDimension());
        System.out.println("Answer(1,1): " + csv.csvChangeCellValue(new Point(1, 1), newValue, path));

    }

}
