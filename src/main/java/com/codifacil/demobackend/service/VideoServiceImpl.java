package com.codifacil.demobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl {

    private static final String FILE_PATH = "classpath:videos//%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;

    public Resource getVideoBlocking(String title) {
        String location = String.format(FILE_PATH, title);
        return resourceLoader.getResource(location);
    }

}
