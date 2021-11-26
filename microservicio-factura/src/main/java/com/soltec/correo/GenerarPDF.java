package com.soltec.correo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Factura;
import com.soltec.entities.Usuario;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class GenerarPDF {

    public GenerarPDF() {

    }

    public boolean generarPDF(String nombreArchivo, File img, String nombreAnimal ,Usuario us, Factura fa, DetalleFactura df) throws FileNotFoundException, IOException, InterruptedException {

        FileOutputStream f = new FileOutputStream(nombreArchivo);

        PdfWriter writer = new PdfWriter(f);
        PdfDocument pdfDoc = new PdfDocument(writer);

        Document document = new Document(pdfDoc, PageSize.A4);
        document.setMargins(50, 30, 20, 30);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

        try {
        	System.out.println("a");
        	Paragraph hue = new Paragraph("Facturación Electrónica - SolTec").setFont(font1);
        	hue.setTextAlignment(TextAlignment.CENTER);
        	hue.setFontSize(36f);
        	System.out.println("n");
        	String[] fe=LocalDateTime.now().toString().split("T");
        	Paragraph factura = new Paragraph("Factura Electrónica de Venta N° "+fa.getRangoNumeracionBean()).setFont(font1);
        	Paragraph fecha = new Paragraph("Fecha: "+fe[0]+" "+fe[1].substring(0,8)).setFont(font1);
        	Paragraph pTitulo = new Paragraph("Hola, "+us.getNombre() + " "+ us.getApellido()+"\n").setFont(font1);
        	Paragraph pCuerpo = new Paragraph("").setFont(font1);
            Paragraph infoUsuario = new Paragraph("Nombre de usuario: "+"-----------"+"\nContraseña: "+"---------------------").setFont(font1);
            Paragraph rolUser = new Paragraph("También se le hace saber que el usuario y usted pertenecen al rol de "+'"'+us.getRol()+'"'+", favor tener en cuenta lo anterior.").setFont(font);
            Paragraph despedida = new Paragraph("").setFont(font1);
            ImageData data = ImageDataFactory.create(img.getAbsolutePath());
            Image imga = new Image(data).setFontSize(28f); 
            // Adding paragraphs to document       
            
            Table table = new Table(2);
            //proceso(table, font, document, burbuja, msBuble);

            
            document.add(imga.setTextAlignment(TextAlignment.LEFT));
            document.add(hue);       
            document.add(fecha.setTextAlignment(TextAlignment.RIGHT));
            document.add(pTitulo);
            document.add(pCuerpo.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(infoUsuario.setTextAlignment(TextAlignment.JUSTIFIED));

            document.add(rolUser.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(despedida.setTextAlignment(TextAlignment.JUSTIFIED));
            document.close();

        } catch (Exception ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

       return new File(nombreArchivo).exists();
    }
    
    public void abrirPDF(String nombreArchivo) throws IOException {

        int respuesta = JOptionPane.showConfirmDialog(null, "Desea Imprimir PDF",
                "Seguimiento", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            File f = new File(nombreArchivo);
            
            Desktop.getDesktop().open(f);
        } else {
            JOptionPane.showMessageDialog(null, "No se abrirá el PDF");
        }
    }
    
    private void tablaProductos(Table tabla, PdfFont font, Document document, DetalleFactura df) {

        tabla = new Table(6);//genera tabla
        tabla.addHeaderCell("Productos").setBackgroundColor(Color.CYAN);//ENCABEZADO DE TABLA COLOR GRIS
        tabla.addHeaderCell("Valor Unitario").setBackgroundColor(Color.CYAN);
        tabla.addHeaderCell("Cantidad").setBackgroundColor(Color.CYAN);
        tabla.addHeaderCell("Subtotal").setBackgroundColor(Color.CYAN);
        tabla.addHeaderCell("Descuento").setBackgroundColor(Color.CYAN);
        tabla.addHeaderCell("Total").setBackgroundColor(Color.CYAN);
        
        document.add(tabla);
        tabla.setWidthPercent(90);
        tabla = new Table(2);

        for (int j = 0; j<6; j++) {
            //condicionesUso(j, datosBurbujaBi, datosBubleSort, tabla, font);
        }
        cargarTablas(tabla, document);
    }
    
    private void condicionesUso(int j, String datosBurbujaBi[], String datosBubleSort[], Table tabla, PdfFont font) {

       
        //tabla.addCell("agrega valor").setFont(font).setBackgroundColor(Color.YELLOW);
        //tabla.addCell("").setFont(font).setBackgroundColor(Color.YELLOW);
    }

    private void cargarTablas(Table tabla, Document document) {
        document.add(tabla);
        tabla.setWidthPercent(90);

        tabla = new Table(2);

        //tabla.addFooterCell("").setBackgroundColor(Color.LIGHT_GRAY);//PIE DE PAGINA DE LA TABLA
        //tabla.addFooterCell(" " ).setBackgroundColor(Color.LIGHT_GRAY);
        document.add(tabla);
        tabla.setWidthPercent(90);
    }


}