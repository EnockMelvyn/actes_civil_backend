package com.mairie.actes.utils;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;;import java.io.FileNotFoundException;

public class PdfGenerator {

    public PdfGenerator() {
    }

    public void createFirstPdf() throws FileNotFoundException {
        String path = "d:\\testPdf.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.close();



    }
}
