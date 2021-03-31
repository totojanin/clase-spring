package com.practicaintegradora.redirectlinks.services;

import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.repositories.LinkRepository;
import org.springframework.stereotype.Service;
import sun.awt.image.ImageWatched;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LinkServiceImpl implements LinkService {
    private LinkRepository linkRepository;

    @Override
    public AtomicLong createLink(String url) {
        try {
            new URL(url).toURI();

            return linkRepository.createLink(url);
        }
        catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
