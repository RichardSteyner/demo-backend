package com.codifacil.demobackend.controller;

import com.codifacil.demobackend.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
@CrossOrigin({"*"})
public class VideoController {

    @Autowired
    private VideoServiceImpl service;

    @GetMapping(value = "/{title}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideoBlocking(@PathVariable String title) {
        System.out.println("Request video!");
        Resource video = service.getVideoBlocking(title);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + video.getFilename());
        return ResponseEntity.ok().headers(headers).body(video);
    }

}
