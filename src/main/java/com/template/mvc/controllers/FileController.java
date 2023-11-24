package com.template.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/fetch-files")
    public ResponseEntity<FileSystemResource> fetchFile(@RequestParam String filename) {

        LOGGER.info("Controller: Fetch files users...");
        try {
            // Provide the path to the directory where files are stored
            String directoryPath = "src/main/resources/static/uploads/";

            // Create a FileSystemResource from the file
            FileSystemResource resource = new FileSystemResource(new File(directoryPath + filename));

            // Check if the file exists
            if (resource.exists()) {
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                        .body(resource);
            } else {
                LOGGER.info("Error File not found:  " + filename);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception error) {
            error.printStackTrace();
            LOGGER.error("Error fetching files: {}", error.getMessage(), error);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
