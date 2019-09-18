package pmh_system.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pmh_system.Main;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.itextpdf.text.FontFactory.*;
import static pmh_system.Main.*;

public class ReceiptCreator {
    public void receiptBuild() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 36, 36, 90, 36);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                "C:/Users/Elisvobs/Desktop/pmh/pmh_system_testing/apps/REC/IN" + receiptNo + ".pdf"));
        // add header and footer
        ReceiptHeader event = new ReceiptHeader();
        // set page event to pdfwriter
        writer.setPageEvent(event);
        // write to document
        document.open();

        Paragraph paragraph = new Paragraph("", new Font(getFont(HELVETICA_BOLD, 12, 1)));
        paragraph.setSpacingBefore(15);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        paragraph = new Paragraph("RECEIPT", new Font(getFont(TIMES_ROMAN, 12, 5)));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
        table.addCell(getCell("Date: " + dateFormat.format(new Date()), PdfPCell.ALIGN_LEFT));
        table.addCell(getHeaderCell("                    ", PdfPCell.ALIGN_MIDDLE));
        if (receiptNo < 10) {
            table.addCell(getHeaderCell("Receipt No: REC00000" + receiptNo, PdfPCell.ALIGN_MIDDLE));
        } else if (receiptNo < 100) {
            table.addCell(getHeaderCell("Receipt No: REC0000" + receiptNo, PdfPCell.ALIGN_MIDDLE));
        } else if (receiptNo < 1000) {
            table.addCell(getHeaderCell("Receipt No: REC000" + receiptNo, PdfPCell.ALIGN_MIDDLE));
        } else if (receiptNo < 10000) {
            table.addCell(getHeaderCell("Receipt No: REC00" + receiptNo, PdfPCell.ALIGN_MIDDLE));
        } else if (receiptNo < 100000) {
            table.addCell(getHeaderCell("Receipt No: REC00" + receiptNo, PdfPCell.ALIGN_MIDDLE));
        }
        table.setSpacingAfter(15);
        document.add(table);

        table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.addCell(getCell("Client: " + Main.client, PdfPCell.ALIGN_LEFT));
        table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("A/c No: " +  sortedAccNo, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(15);
        document.add(table);

        table = new PdfPTable(3);
        table.setWidthPercentage(100);
        switch (currencyUsed) {
            case "US$":
                table.addCell(getCell("Paid:  US$ " + String.format("%.2f", initialAmount), PdfPCell.ALIGN_LEFT));
                table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
                table.addCell(getCell(" ", PdfPCell.ALIGN_MIDDLE));
                break;
            case "ZAR":
                table.addCell(getCell("Paid:  ZAR" + String.format("%.2f", initialAmount), PdfPCell.ALIGN_LEFT));
                table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
                table.addCell(getCell("Equivalent: US$ " + String.format("%.2f", equivalency), PdfPCell.ALIGN_MIDDLE));
                break;
            case "GBP":
                table.addCell(getCell("Paid:  GBP £" + String.format("%.2f", initialAmount), PdfPCell.ALIGN_LEFT));
                table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
                table.addCell(getCell("Equivalent: US$ " + String.format("%.2f", equivalency), PdfPCell.ALIGN_MIDDLE));
                break;
            case "ZWL":
                table.addCell(getCell("Paid:  ZWL$" + String.format("%.2f", initialAmount), PdfPCell.ALIGN_LEFT));
                table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
                table.addCell(getCell("Equivalent: US$ " + String.format("%.2f", equivalency), PdfPCell.ALIGN_MIDDLE));
                break;
        }
        table.setSpacingAfter(15);
        document.add(table);

        table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.addCell(getCell("Cashier: " + cashier, PdfPCell.ALIGN_LEFT));
        table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("Next Subscription Due Date: ", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(3);
        document.add(table);

        table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.addCell(getCell("                    " , PdfPCell.ALIGN_LEFT));
        table.addCell(getHeaderCell("                    " , PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell(LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(5);
        document.add(table);

        paragraph = new Paragraph("Thank you for making payment!", new Font(getFont(TIMES_ITALIC, 12, 3)));
        paragraph.setIndentationLeft(150);
        paragraph.setSpacingAfter(3);
        document.add(paragraph);paragraph = new Paragraph( "________________________________________________________________________________________________________",
                new Font(getFont(TIMES_ROMAN, 10, 0)));
        document.add(paragraph);

//        paragraph = new Paragraph("Our banking details:", new Font(getFont(TIMES_ROMAN, 10, 1)));
//        document.add(paragraph);

//        paragraph = new Paragraph(String.join("\n", "Bank: NMB   Branch: Avondale    A/c No ZWL: 280350028    A/c No US$ Local:  280348546    A/c No US$ Export: 280350327",
//                "Bank: CBZ   Branch: Newlands    A/c No ZWL: 68961568800013    A/c No US$: 68961568800023",
//                "Ecocash Merchant Code:    *151*2*2*324914*Amount#  ",
//                "________________________________________________________________________________________________________"),
//                new Font(getFont(TIMES_ROMAN, 10, 0)));
//        document.add(paragraph);


        document.close();
        Desktop.getDesktop().open(new File("C:/Users/Elisvobs/Desktop/pmh/pmh_system_testing/apps/REC"
                + receiptNo + ".pdf"));
    }

    private PdfPCell getHeaderCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, new com.itextpdf.text.Font(getFont(TIMES_ROMAN, 12, 1))));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, new Font(getFont(TIMES_ROMAN, 12, 0))));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
}