package com.practicaintegradora.redirectlinks.repositories;

import com.practicaintegradora.redirectlinks.dto.InvalidateDTO;
import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.dto.MetricsDTO;
import org.springframework.stereotype.Repository;
import sun.awt.image.ImageWatched;

import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LinkRepositoryImpl implements LinkRepository {
    private Map<LinkDTO, Integer> linkRepository = new HashMap<LinkDTO, Integer>();
    private AtomicLong linkId = new AtomicLong(0);

    @Override
    public LinkDTO createLink(String url, String password) {
        LinkDTO linkDTO = null;

        if (!linkInRepository(url)) {
            linkDTO = new LinkDTO(linkId.incrementAndGet(), url, password);

            linkRepository.put(linkDTO, 0);
        }
        else {
            linkDTO = getLinkByUrl(url);
        }

        return linkDTO;
    }

    @Override
    public LinkDTO getLinkByLinkId(Long linkId) {
        return linkRepository.keySet().stream()
                .filter(link -> link.getLinkId() == linkId)
                .findAny()
                .orElse(null);
    }

    @Override
    public void incrementRedirect(LinkDTO linkDTO) {
        Integer count = linkRepository.get(linkDTO);

        linkRepository.put(linkDTO, count + 1);
    }

    @Override
    public MetricsDTO getMetrics(LinkDTO linkDTO) {
        return new MetricsDTO(linkDTO.getUrl(), linkRepository.get(linkDTO));
    }

    @Override
    public InvalidateDTO invalidateLink(LinkDTO linkDTO) {
        linkRepository.remove(linkDTO);

        return new InvalidateDTO(linkDTO.getUrl());
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
