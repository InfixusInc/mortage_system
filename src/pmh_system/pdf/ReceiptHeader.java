package pmh_system.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

public class ReceiptHeader extends PdfPageEventHelper {

    private PdfTemplate template;
    private Image image;

    public void onOpenDocument(PdfWriter writer, Document document){
        template = writer.getDirectContent().createTemplate(48, 40);
        try {
            image = Image.getInstance(template);
            image.setRole(PdfName.ART);
        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        addHeader(writer);
    }

    private void addHeader(PdfWriter writer){
        PdfPTable header = new PdfPTable(2);
        try {
            // set defaults
            header.setWidths(new int[]{2, 24});
            header.setTotalWidth(527);
            header.setLockedWidth(true);
            header.getDefaultCell().setFixedHeight(24);
            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add image
            Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/pmh_system/views/images/logo.jpg"));
            header.addCell(logo);
            header.setSpacingBefore(4);

            header.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            // add text
            PdfPCell text = new PdfPCell();
            text.setPaddingTop(4);
            text.setPaddingBottom(4);
            text.setPaddingLeft(40);
            text.setHorizontalAlignment(text.ALIGN_CENTER);
            text.setBorder(Rectangle.BOTTOM);
            text.setBorderColor(BaseColor.LIGHT_GRAY);
            text.addElement(new Phrase("                Mortgaging & Housing Company", new Font(Font.FontFamily.HELVETICA, 14, 1)));
            text.addElement(new Phrase("                                                    'Write your catch phrase here!'", new Font(Font.FontFamily.HELVETICA, 10, 2)));
            text.addElement(new Phrase("                                      Street # and Address, Location, City, Country", new Font(Font.FontFamily.HELVETICA, 10, 0)));
            text.addElement(new Phrase("                Email:  info@company.com, sales@company.com; Website: www.company.com ", new Font(Font.FontFamily.HELVETICA, 10, 0)));
            text.addElement(new Phrase("    Tel:  +263 242 000 000-2; Cell: +263 71 000 0000, +263 77 000 00000, +263 73 000 0000", new Font(Font.FontFamily.HELVETICA, 10, 0)));
            header.addCell(text);

            // write content
            header.writeSelectedRows(0, -1, 32, 842, writer.getDirectContent());
        } catch(DocumentException | IOException de) {
            throw new ExceptionConverter(de);
        }
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(3);
        try {
            // set defaults
            footer.setWidths(new int[]{24, 2, 1});
            footer.setTotalWidth(527);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(40);
            footer.getDefaultCell().setBorder(Rectangle.SUBJECT);
            footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add copyright
            footer.addCell(new Phrase("\u00A9 Mortgaging & Housing Company ",
                    new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));

            // add current page count
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            footer.addCell(new Phrase(String.format("Page %d", writer.getPageNumber()),
                    new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL)));

            // add placeholder for image page count
            PdfPCell totalPageCount = new PdfPCell(image);
            totalPageCount.setBorder(Rectangle.SUBJECT);
            totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
            footer.addCell(totalPageCount);

            // write page
            PdfContentByte canvas = writer.getDirectContent();
            canvas.beginMarkedContentSequence(PdfName.ART);
            footer.writeSelectedRows(0, -1, 34, 50, canvas);
            canvas.endMarkedContentSequence();
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document) {
        int totalLength = Integer.parseInt(String.valueOf(writer.getPageNumber()));
        int totalWidth = totalLength * 4;
//        ColumnText.showTextAligned(template, Element.ALIGN_RIGHT, new Phrase(String.valueOf(
//                writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8, 0)),
//                totalWidth, 4, 0);
    }
}