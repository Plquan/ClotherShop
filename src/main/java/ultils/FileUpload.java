package ultils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


public class FileUpload {

    private static final String UPLOAD_DIR = "fileupload"; 
    private static final String[] ALLOWED_EXTENSIONS = { "jpg", "jpeg", "png", "gif" }; 


    public static String saveFile(Part filePart, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/fileUpload");          
        String filename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
        File imageDir = new File(realPath);
        if (!imageDir.exists()) {
            imageDir.mkdir();
        }
        filePart.write(realPath +"/" + filename);
        return filename; 
    }
    public static void deleteFile(String fileName, HttpServletRequest request) { 
        String realPath = request.getServletContext().getRealPath("/fileUpload");      
        File file = new File(realPath + "/" + fileName);

        if (file.exists()) {
            file.delete(); 
        }
    }

    private static String getFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 2, content.length() - 1);
            }
        }
        return null;
    }


}
