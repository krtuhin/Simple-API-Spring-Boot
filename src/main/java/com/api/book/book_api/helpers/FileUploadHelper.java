package com.api.book.book_api.helpers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadHelper {

    //method for upload file
    public static boolean fileUpload(MultipartFile file) {

        boolean f = false;

        //static path
        //String path = "C:\\Users\\krtuh\\Desktop\\SpringBootAPI\\book_api\\src\\main\\resources\\static\\img" + File.separator;
        
        try {

            //dynamic path
            //ClassPathResource return the path of resource folder of the project
            String path = new ClassPathResource("static").getFile().getAbsolutePath()
                    + File.separator + "img" + File.separator + file.getOriginalFilename();

            //save file into path using nio API
            Files.copy(file.getInputStream(), Paths.get(path),
                    StandardCopyOption.REPLACE_EXISTING);

            f = true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }
}
