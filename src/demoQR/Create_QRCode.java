/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoQR;

/**
 *
 * @author HP
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class Create_QRCode {

    private static final String QR_CODE_IMAGE_PATH = "MyQRCode1.png";//hằng

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);//đường dẫn
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);//writeToFile(bitMatrix, filePath, path.toFile() );
    }

    public static void main(String[] args) throws IOException {
        try {
            generateQRCodeImage("Wellcome to Infomation Technology 1", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {//nội dung không thể mã hóa ở 1 format
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        
    }
}
