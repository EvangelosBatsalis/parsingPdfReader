import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (PDDocument pdDocument = PDDocument.load(new File("src/main/resources/demopdf.pdf"))) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(pdDocument);

            text = text.replace(".", "");

            String[] lines = text.split("\n");

            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains("Documentation")) {
                    for (int j = i + 1; j <= i + 5 && j < lines.length; j++) {  // Adjusted loop conditions
                        System.out.println(lines[j]);
                    }
                    break;  // This will exit the outer for loop
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
