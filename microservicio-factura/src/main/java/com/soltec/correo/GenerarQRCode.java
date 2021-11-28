package com.soltec.correo;

import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GenerarQRCode {
	
	public GenerarQRCode() throws Exception {
		QRCode qrCode = new QRCode();
		BitMatrix matrix= new MultiFormatWriter().encode(qrCode.getData(),BarcodeFormat.QR_CODE,qrCode.getHeight(),qrCode.getSize());
		//Formato de la imagen y la ruta
		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(qrCode.getPath()));
	}
}


