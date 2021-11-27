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

    public boolean generarPDF(String nombreArchivo, File img, Usuario us, Factura fa, DetalleFactura df) throws FileNotFoundException, IOException, InterruptedException {

        FileOutputStream f = new FileOutputStream(nombreArchivo);//nombre pdf

        PdfWriter writer = new PdfWriter(f);
        PdfDocument pdfDoc = new PdfDocument(writer);

        Document document = new Document(pdfDoc, PageSize.A2);
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

            document.add(imga.setTextAlignment(TextAlignment.LEFT));
            document.add(hue);       
            document.add(fecha.setTextAlignment(TextAlignment.RIGHT));
            document.add(pTitulo);
            document.add(pCuerpo.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(infoUsuario.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(rolUser.setTextAlignment(TextAlignment.JUSTIFIED));
            tablaProductos(font, document, df);
            tablaPrecios(font, document, df);
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
    
    private void tablaProductos(PdfFont font, Document document, DetalleFactura df) {

        Table tabla = new Table(6);//genera tabla
        tabla.addHeaderCell("Codigo del producto").setBackgroundColor(Color.LIGHT_GRAY);//ENCABEZADO DE TABLA COLOR GRIS
        tabla.addHeaderCell("Nombre");
        tabla.addHeaderCell("U/M");
        tabla.addHeaderCell("Valor unitario");
        tabla.addHeaderCell("% Desc");
        tabla.addHeaderCell("IVA");
        String val[] ={"AB12","Zapato","cm","200.000","3%","0%"};
        document.add(tabla);
        tabla.setWidthPercent(90);
        tabla = new Table(6);

        for (int j = 0; j<6; j++) {
        	tabla.addCell(val[j]).setFont(font);
        }
        document.add(tabla);
        tabla.setWidthPercent(50);
    }
    
    private void tablaPrecios(PdfFont font, Document document, DetalleFactura df) {

    	document.add(new Paragraph());
    	document.add(new Paragraph("--------------------------------------------------------------------------------").setWidthPercent(50));
    	document.add(new Paragraph());
        @SuppressWarnings("deprecation")
		Table tabla1 = new Table(1);//genera tabla
        tabla1.addHeaderCell("MONEDA (COP) PESOS COLOMBIANOS").setBackgroundColor(Color.LIGHT_GRAY);
        String valores[]= {"Subtotal","Valor neto","Descuento total","IVA","TOTAL"};
        String val[] ={"12","23","43","87","198"};
        
        document.add(tabla1);
        tabla1.setWidthPercent(50);
        Table tabla2 = new Table(2);

        for (int j = 0; j<valores.length-1; j++) {
        	tabla2.addCell(valores[j]).setFont(font);
        	tabla2.addCell(val[j]).setFont(font);
        }
        document.add(tabla2);
        tabla2.setWidthPercent(50);
        
        tabla2 = new Table(2);
        tabla2.addCell(valores[valores.length-1]).setFont(font).setBackgroundColor(Color.LIGHT_GRAY);
    	tabla2.addCell(val[val.length-1]).setFont(font);
    	
    	document.add(tabla2);
        tabla2.setWidthPercent(50);
    }

}