package com.practicaintegradora.redirectlinks.repositories;

import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import org.springframework.stereotype.Repository;
import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LinkRepositoryImpl implements LinkRepository {
    private HashMap<LinkDTO, Integer> linkRepository;
    private AtomicLong linkId = new AtomicLong();

    public AtomicLong createLink(String url) {
        LinkDTO linkDTO = null;

        if (linkInRepository(url)) {
            linkDTO = getLinkByUrl(url);

            Integer cont = linkRepository.get(linkDTO);

            linkRepository.put(linkDTO, cont + 1);
        }
        else {
            linkDTO = new LinkDTO(linkId, url);
            linkRepository.put(linkDTO, 1);
        }

        return linkDTO.getLinkId();
    }

    private LinkDTO getLinkByUrl(String url) {
        return linkRepository.keySet().stream()
                .filter(link -> link.getUrl().equals(url))
                .findAny()
                .orElse(null);
    }

    private boolean linkInRepository(String url) {
        return getLinkByUrl(url) != null;
    }
}
