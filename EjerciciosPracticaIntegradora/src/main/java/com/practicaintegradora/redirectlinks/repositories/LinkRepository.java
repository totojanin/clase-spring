package com.practicaintegradora.redirectlinks.repositories;

import com.practicaintegradora.redirectlinks.dto.InvalidateDTO;
import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.dto.MetricsDTO;

public interface LinkRepository {
    LinkDTO createLink(String url, String password);
    LinkDTO getLinkByLinkId(Long linkId);
    void incrementRedirect(LinkDTO linkDTO);
    MetricsDTO getMetrics(LinkDTO linkDTO);
    InvalidateDTO invalidateLink(LinkDTO linkDTO);
}
