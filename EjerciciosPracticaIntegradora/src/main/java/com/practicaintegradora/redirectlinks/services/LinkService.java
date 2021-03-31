package com.practicaintegradora.redirectlinks.services;

import com.practicaintegradora.redirectlinks.dto.InvalidateDTO;
import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.dto.MetricsDTO;
import com.practicaintegradora.redirectlinks.exceptions.InvalidLinkException;
import com.practicaintegradora.redirectlinks.exceptions.InvalidPasswordException;
import com.practicaintegradora.redirectlinks.exceptions.LinkNotFoundException;

public interface LinkService {
    LinkDTO createLink(String url, String password) throws InvalidLinkException;
    LinkDTO getLink(Long linkId, String password) throws LinkNotFoundException, InvalidPasswordException;
    MetricsDTO getMetrics(Long linkId) throws LinkNotFoundException;
    InvalidateDTO invalidateLink(Long linkId) throws LinkNotFoundException;
}