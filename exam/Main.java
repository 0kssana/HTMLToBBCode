package exam;

import exam.parser.BBCodeWriter;
import exam.parser.HtmlParser;
import exam.parser.nodes.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (!(args != null && args.length == 2 && args[0] != null && args[1] != null)) {
            System.err.println("Usage: Html2Bbcode <input file> <output file>");
            return;
        }
        // Получаем имена входных и выходных файлов
	    String inputFile = args[0];
        String outputFile = args[1];
        try {
            // Считываем текст
            String inputText = Files.readString(Paths.get(inputFile));
            // Парсим текст в структуру с нодами
            Node parsed = HtmlParser.parse(inputText);
            // Пишем полученную структуру в файл
            BBCodeWriter.writeToFile(parsed, outputFile);
        } catch (IOException e) {
            System.err.println("Cannot read input file");
        }
    }
}
