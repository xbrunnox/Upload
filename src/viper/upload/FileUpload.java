package viper.upload;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
  
public class FileUpload extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public FileUpload() {  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        String contentType = request.getContentType();  
        String diretorio = new String("C:\\Arquivos\\");  
        String nomeArquivo = request.getParameter("nomeArquivo");  
  
        try {  
            if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))   
            {  
                DataInputStream in = new DataInputStream(request.getInputStream());  
                int formDataLength = request.getContentLength();  
                byte dataBytes[] = new byte[formDataLength];  
                int byteRead = 0;  
                int totalBytesRead = 0;  
  
                while (totalBytesRead < formDataLength)   
                {  
                    byteRead = in.read(dataBytes, totalBytesRead,formDataLength);  
                    totalBytesRead += byteRead;  
                }  
  
                String file = new String(dataBytes);  
                  
                int lastIndex = contentType.lastIndexOf("=");  
                String boundary = contentType.substring(lastIndex + 1,contentType.length());  
  
                int pos;  
                pos = file.indexOf("filename=\"");  
                pos = file.indexOf("\n", pos) + 1;  
                pos = file.indexOf("\n", pos) + 1;  
                pos = file.indexOf("\n", pos) + 1;  
  
                int boundaryLocation = file.indexOf(boundary, pos) - 4;  
                int startPos = ((file.substring(0, pos)).getBytes()).length;  
                int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;  
  
                // Salva no diretorio especificado  
                FileOutputStream fileOut = new FileOutputStream(diretorio + nomeArquivo);  
  
                fileOut.write(dataBytes, startPos, (endPos - startPos));  
                fileOut.flush();  
                fileOut.close();  
                  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
