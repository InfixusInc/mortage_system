package pmh_system.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.itextpdf.text.FontFactory.*;
import static pmh_system.Main.*;

public class DocumentCreator {
    public void formBuild() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 36, 36, 95, 36);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                "C:/Users/Elisvobs/Desktop/pmh/pmh_system_testing/apps/REC/M" + accountNo + ".pdf"));
        // add header and footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        // set page event to pdfwriter
        writer.setPageEvent(event);
        // write to document
        document.open();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getTopHeaderCell("APPLICATION FORM", PdfPCell.ALIGN_LEFT));
        if (accountNo < 10) {
            table.addCell(getTopHeaderCell("Account No: M00000" + accountNo, PdfPCell.ALIGN_RIGHT));
        } else if (accountNo < 100) {
            table.addCell(getTopHeaderCell("Account No: M0000" + accountNo, PdfPCell.ALIGN_RIGHT));
        } else if (accountNo < 1000) {
            table.addCell(getTopHeaderCell("Account No: M000" + accountNo, PdfPCell.ALIGN_RIGHT));
        } else if (accountNo < 10000) {
            table.addCell(getTopHeaderCell("Account No: M00" + accountNo, PdfPCell.ALIGN_RIGHT));
        } else if (accountNo <100000) {
            table.addCell(getTopHeaderCell("Account No: M0" + accountNo, PdfPCell.ALIGN_RIGHT));
        }
        table.setSpacingAfter(10);
        table.setSpacingBefore(10);
        document.add(table);

        Paragraph paragraph = new Paragraph("PERSONAL AND CONTACT DETAILS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingAfter(2);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Surname: " + surname, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("First Name (s): " + firstName, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Date of Birth: " + dob, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("National ID No: " + natIdNo, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Country of Birth: " + countryOfBirth, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Nationality: " + nationality, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Marital Status: " + maritalStatus, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Gender: " + gender, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Cell Number (s): " + cellNumber, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Email Address: " + email, PdfPCell.ALIGN_MIDDLE));
        document.add(table);

        paragraph = new Paragraph("Physical Address: " + physAdd, new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(2);
        document.add(paragraph);

        paragraph = new Paragraph("EMPLOYMENT DETAILS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingBefore(3);
        paragraph.setSpacingAfter(2);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Company Name: " + companyName, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Phone Number: " + companyPhone, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        paragraph = new Paragraph("PROPERTY DETAILS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingBefore(3);
        paragraph.setSpacingAfter(2);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Preferred Locality: " + preferredLocality, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Preferred Stand Size: " + standSize + "\u00B2", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("House Type: " + houseType, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Repayment Period: " + repaymentPeriod , PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(3);
        document.add(table);

        paragraph = new Paragraph("MORTGAGE DETAILS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingAfter(3);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Property Value: US$" +  String.format("%.2f", propertyValue), PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Loan Value: US$" +  String.format("%.2f", loanValue), PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Monthly Subscription Amount:  US$" +  String.format("%.2f", monthlySubscription), PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Underwriter Policy No: AB00001", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        paragraph = new Paragraph( "________________________________________________________________________________________________________",
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

        paragraph = new Paragraph("NEXT OF KIN DETAILS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingBefore(2);
        paragraph.setSpacingAfter(3);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Name : " + nameOfKin + " " + surnameOfKin, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("National ID No: " + idOfKin, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Date of Birth: " + dobOfKin, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Phone Number: " + phoneOfKin, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Address: " + addressOfKin, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell(" ", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        paragraph = new Paragraph("LIST OF BENEFICIARIES", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingAfter(2);
        document.add(paragraph);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + "First Name (s)", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + "Surname", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + "National ID", PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + "Gender", PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + "DOB", PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + "Relationship", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(5);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(1);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName1, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname1, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId1, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender1, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob1, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel1, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(1);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName2, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname2, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId2, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender2, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob2, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel2, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(1);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName3, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname3, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId3, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender3, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob3, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel3, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(1);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName4, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname4, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId4, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender4, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob4, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel4, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName5, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname5, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId5, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender5, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob5, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel5, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName6, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname6, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId6, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender6, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob6, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel6, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName7, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname7, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId7, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender7, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob7, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel7, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName8, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname8, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId8, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender8, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob8, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel8, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.addCell(getCell("" + benName9, PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("" + benSurname9, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benNatId9, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benGender9, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benDob9, PdfPCell.ALIGN_MIDDLE));
        table.addCell(getCell("" + benRel9, PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);


        document.newPage();
        paragraph = new Paragraph("", new Font(getFont(HELVETICA_BOLD, 12, 1)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph("TERMS AND CONDITIONS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingBefore(5);
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "1.  The effective start date of the agreement is the date of its final authorization by a signature from",
                "  " + "   Mortgaging & Housing Company."), new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "2.  Installments subscriptions shall be paid in legal tender in Zimbabwe subject to Mortgaging & Housing",
                "  " + "   Company terms and conditions for payments. Monthly subscriptions are due on the same day",
                "  " + "   the following month. Annual subscriptions are due on the same date the following year."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("3.  Subscription period shall be a minimum of 5 years, maximum 30 years subject to age of the applicant.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("4.  Monthly installment includes administration, interest and insurance charges.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("5.  Insurance documents only obtainable through preferred financial advisor.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("6.  Allocation of property is done upon payment of 30% of the mortgage value.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "7.  In the event of passing on of the subscribing member, installment balance of the property shall be ",
                "  " + "   paid by the insurance company to Mortgaging & Housing Company, upon which Mortgaging &",
                "  " + "   Housing Company shall not repossess the property."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "8.  On voluntary withdrawal, Mortgaging & Housing Company shall refund the subscribing  ",
                "  " + "   member after having deducted 30% of total subscription to cover for insurance and administration costs."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n","9.  At inception, a subscribing member can choose a location of their preference, only once are they allowed",
                "   " + "   to shift to another location especially upon reaching a third of their mortgage value payments if the",
                "   " + "   chosen new area is available for allocation."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("10. Installment amount shall be determined by mortgage value.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("11. The insurance document shall be ceded to Mortgaging & Housing Company as collateral.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n","12. Mortgaging & Housing Company reserves the right to amend these terms and conditions."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);


        document.newPage();
        paragraph = new Paragraph("", new Font(getFont(HELVETICA_BOLD, 12, 1)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph("DECLARATION AND AUTHORIZATION", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "The information I have given is correct and to the best of my knowledge. It is my duty to supply",
                "any material changes to Mortgaging & Housing Company."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "I understand that if I have given false or inaccurate information to Mortgaging & Housing Company.",
                "They have the right to defer, cancel or amend my application."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "I authorize Mortgaging & Housing Company use of the information prescribed in this document for ",
                "the purpose of conducting its Housing scheme and related business. I understand the information may be ",
                "photocopied and agree that copies may be used to obtain the required information."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        paragraph = new Paragraph("MORTGAGING & HOUSING COMPANY CESSION OF ASSURANCE POLICY",
                new Font(getFont(TIMES_ROMAN, 12, 5)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Mortgager: Mortgaging & Housing Company", PdfPCell.ALIGN_LEFT));
        if (gender.equals("Male")) {
            table.addCell(getCell("Name of Cedent: Mr " + firstName + " " + surname, PdfPCell.ALIGN_MIDDLE));
        } else if (gender.equals("Female") && maritalStatus.equals("Single")) {
            table.addCell(getCell("Name of Cedent: Miss " + firstName + " " + surname, PdfPCell.ALIGN_MIDDLE));
        } else if (gender.equals("Female") && maritalStatus.equals("Divorced")) {
            table.addCell(getCell("Name of Cedent: Ms " + firstName + " " + surname, PdfPCell.ALIGN_MIDDLE));
        } else if (gender.equals("Female") && maritalStatus.equals("Widowed")) {
            table.addCell(getCell("Name of Cedent: Ms " + firstName + " " + surname, PdfPCell.ALIGN_MIDDLE));
        } else if (gender.equals("Female") && maritalStatus.equals("Married")) {
            table.addCell(getCell("Name of Cedent: Mrs " + firstName + " " + surname, PdfPCell.ALIGN_MIDDLE));
        }
        table.setSpacingAfter(5);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Assurance Company: Life Assurance", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Policy No: AB00001", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(1);
        document.add(table);

        paragraph = new Paragraph("Sum Assured: US$" + String.format("%.2f", propertyValue),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "The cedent hereby cedes, assigns and transfers, upon the conditions appearing below, to",
                "Mortgaging & Housing Company, its order or assigns, as collateral security, the cedent’s right, title ",
                "and interest in and to the above policy, which has been/is about to be issued."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n",
                "Dated this ..........day of.......year....... & Signed at............ in presence of the undersigned witnesses. Cession",
                "of the Policy mentioned above has been registered in the Assurance Company's records."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(" ", PdfPCell.ALIGN_LEFT));
        table.addCell(getHeaderCell("AS WITNESS", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(25);
        document.add(table);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("..............................................................", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("1. ............................................................", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(2);
        document.add(table);

        paragraph = new Paragraph("Applicant signature", new Font(getFont(TIMES_ROMAN, 12, Font.BOLDITALIC)));
        paragraph.setIndentationLeft(45);
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("2. ............................................................", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(15);
        document.add(table);

        paragraph = new Paragraph(String.join("\n",
                "________________________________________________________________________________________________________",
                "For office use only:"), new Font(getFont(TIMES_ROMAN, 10, 1)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(" "  , PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Stamp ", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(15);
        document.add(table);

        paragraph = new Paragraph("Name: " + cashier, new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(15);
        document.add(paragraph);

        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("Authorisation Signature:..................................", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("Date:.......................................", PdfPCell.ALIGN_MIDDLE));
        table.setSpacingAfter(3);
        document.add(table);

        paragraph = new Paragraph("Mortgaging & Housing Company.",
                new Font(getFont(TIMES_ROMAN, 12, Font.ITALIC)));
        paragraph.setIndentationLeft(15);
        document.add(paragraph);


        document.newPage();
        paragraph = new Paragraph("", new Font(getFont(HELVETICA_BOLD, 12, 1)));
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        paragraph = new Paragraph("CESSION OF ASSURANCE CONDITIONS", new Font(getFont(TIMES_ROMAN, 12, 1)));
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n","1. The policy above is ceded as security for any sums of money now or at any time hereafter due, ",
                "  " + "   owing or payable by the Mortgager to the Cessionary from whatever cause arising."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph("2. The cession shall remain in force until cancelled by the Cessionary.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n","3. The Cedent hereby undertakes to pay or cause to be paid all premiums due under the said Policy and ",
                "  " + "   to exhibit to the Cessionary the Premium Renewal Receipts if called upon to do so by the Cessionary. ",
                "  " + "   The Cedent also acknowledges the Cessionary’s right to pay arrear premiums on the Cedent’s behalf ",
                "  " + "   and hereby undertakes to reimburse the Cessionary the amount so disbursed."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(5);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n", "4. The Cedent hereby appoints the Cessionary irrevocaby ad in rem suam with power of substitution to",
                "  " + "   be the Cedent’s agent at any time to surrender the Policy and to appropriate the surrender value",
                "  " + "   thereof on the amount owing to the Cessionary by the Mortgagor in terms of Clause 1 hereof."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n", " 5. The Cedent is bound hereby as surety in Solidium for and co-principal debtor with the Cessinary ",
                "  " + "   may hold the Surety liable for the whole debt and is not obliged to proceed against the Mortgagor. ",
                "  " + "   Under the law a Surety may demand that the Principal Debtor must be sued before any claim is made ",
                "  " + "   on the Surety and that thereafter the claim is made on the surety and that thereafter the claim against ",
                "  " + "   the surety can only be for the amount by which the Principal Debtor has may sue me for the full ",
                "  " + "   amount hereby guaranteed by me even though he may not have sued the Principal Debtor first, and ",
                "  " + "   further that having renounced the “Beneficiaum Divisionis” I cannot be heard to say that if there are ",
                "  " + "   other guarantors of this debt then my liability should be reduced proportionately because having so ",
                "  " + "   renounced I am bound fully as though there were no other such guarantors. Since I might not be bound ",
                "  " + "   if I did not renounce these benefits, and as I am quite willing to be bound, I hereby renounce them. ",
                "  " + "   I acknowledge that I understood their meaning and what I am doing in renouncing them."),
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph(String.join("\n", "6. If the policy shall become payable for any reason whatsoever the Cessionary shall have the right to",
                "  " + "  appropriate all or a portion of the proceeds thereof towards the Mortgagor’s liability under Clause 1",
                "  " + "  hereof."), new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        paragraph = new Paragraph("7. The Cedents liability here under is limited to the proceeds of the Policy.",
                new Font(getFont(TIMES_ROMAN, 12, 0)));
        paragraph.setSpacingAfter(10);
        document.add(paragraph);


        document.close();
        Desktop.getDesktop().open(new File("C:/Users/Elisvobs/Desktop/pmh/pmh_system_testing/apps/REC/M" + accountNo + ".pdf"));
    }

    private PdfPCell getTopHeaderCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, new Font(getFont(TIMES_ROMAN, 14, 1))));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private PdfPCell getHeaderCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, new Font(getFont(TIMES_ROMAN, 10, 0))));
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