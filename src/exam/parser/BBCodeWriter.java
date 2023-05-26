package exam.parser;

import exam.parser.nodes.Node;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BBCodeWriter {
    // Запись разобранного текста в файл
    public static void writeToFile(Node node, String filename) {
        StringBuilder allText = new StringBuilder();
        node.writeDecoratedBBText(allText);
        try (PrintWriter pw = new PrintWriter(filename)){
            pw.print(allText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
