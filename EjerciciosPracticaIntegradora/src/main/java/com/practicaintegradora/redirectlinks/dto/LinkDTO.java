package com.practicaintegradora.redirectlinks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
public class LinkDTO {
    private Long linkId;
    private String url;
    private String password;
}
