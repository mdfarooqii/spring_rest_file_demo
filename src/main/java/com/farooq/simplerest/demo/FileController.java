package com.farooq.simplerest.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/appdemo")
public class FileController {


    @RequestMapping(path = "file1", method = RequestMethod.GET)
    public ResponseEntity<org.springframework.core.io.Resource> downPython() throws IOException {
        Resource resource = new ClassPathResource("static/test.txt");
        File file = resource.getFile();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION , "attachment;filename =demo.txt");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        Path p = Paths.get(file.getAbsolutePath());

        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);

    }

    @RequestMapping(path = "file2", method = RequestMethod.GET)
    public ResponseEntity<org.springframework.core.io.Resource> downloadMapping() throws IOException {
        Resource resource = new ClassPathResource("static/test1.csv");
        File file = resource.getFile();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION , "attachment;filename =demo.csv");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        Path p = Paths.get(file.getAbsolutePath());

        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);

    }
}
