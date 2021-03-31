package com.practicaintegradora.redirectlinks.services;

import com.practicaintegradora.redirectlinks.dto.InvalidateDTO;
import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.dto.MetricsDTO;
import com.practicaintegradora.redirectlinks.exceptions.InvalidLinkException;
import com.practicaintegradora.redirectlinks.exceptions.InvalidPasswordException;
import com.practicaintegradora.redirectlinks.exceptions.LinkNotFoundException;
import com.practicaintegradora.redirectlinks.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public LinkDTO createLink(String url, String password) throws InvalidLinkException {
        try {
            new URL(url).toURI();

            return linkRepository.createLink(url, password);
        }
        catch (Exception e) {
            throw new InvalidLinkException("El link ingresado es inválido");
        }
    }

    @Override
    public LinkDTO getLink(Long linkId, String password) throws LinkNotFoundException, InvalidPasswordException {
        LinkDTO linkDTO = getLinkByLinkId(linkId);

        if (linkDTO.getPassword().equals(password))
            linkRepository.incrementRedirect(linkDTO);
        else
            throw new InvalidPasswordException("La password ingresada es incorrecta");

        return linkDTO;
    }

    @Override
    public MetricsDTO getMetrics(Long linkId) throws LinkNotFoundException {
        LinkDTO linkDTO = getLinkByLinkId(linkId);

        return linkRepository.getMetrics(linkDTO);
    }

    @Override
    public InvalidateDTO invalidateLink(Long linkId) throws LinkNotFoundException {
        LinkDTO linkDTO = getLinkByLinkId(linkId);

        return linkRepository.invalidateLink(linkDTO);
    }

    private LinkDTO getLinkByLinkId(Long linkId) throws LinkNotFoundException {
        LinkDTO linkDTO = linkRepository.getLinkByLinkId(linkId);

        if (linkDTO == null)
            throw new LinkNotFoundException("El link ingresado no se encuentra en la base de datos");

        return linkDTO;
    }
}
