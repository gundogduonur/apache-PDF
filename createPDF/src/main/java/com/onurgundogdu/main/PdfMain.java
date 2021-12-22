package com.onurgundogdu.main;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;

public class PdfMain {
    public static void main(String[] args) {
   try{
       createPdf();
   }
   catch (Exception exception)
   {
       System.err.println(exception.getLocalizedMessage());
   }

    }

    private static void createPdf() throws  Exception {
        String filePath="simple.pdf";
        String line="JAVABOOST";
        String[] technologies={"OOP","HIBERNATE","SPRING","JS"};
        PDPageContentStream contentStream = null;
        try (PDDocument pdfDocument = new PDDocument()) {
            PDPage page = new PDPage();
            pdfDocument.addPage(page);
            contentStream = new PDPageContentStream(pdfDocument, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN,15);
            contentStream.setLeading(12.5f);
            contentStream.newLineAtOffset(20,750);
            contentStream.showText(line);
            contentStream.newLine();
            for(int i=0;i<technologies.length;i++)
            {
                contentStream.newLine();
                contentStream.showText(technologies[i]);
            }
            contentStream.endText();
            contentStream.close();
            pdfDocument.save(filePath);
        } finally {
            if (contentStream != null) {
                try
                {
                    contentStream.close();

                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                }

            }
        }



    }
}
