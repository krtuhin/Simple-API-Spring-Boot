package com.api.book.book_api.controllers;

import com.api.book.book_api.helpers.FileUploadHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    //method for upload file
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        try {

            //if file not select then
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Request must contain file..!");

                //if the file is not an image
            } else if (!file.getContentType().trim().contains("image")) {

                return ResponseEntity.internalServerError().body("Select only Image");
            }

            //file upload code
            if (FileUploadHelper.fileUpload(file)) {

                //return url of saved image
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/").path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        return ResponseEntity.internalServerError().body("Something went wrong, try again..!");
    }
}
