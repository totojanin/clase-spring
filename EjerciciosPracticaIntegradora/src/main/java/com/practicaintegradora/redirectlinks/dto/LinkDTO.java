package com.practicaintegradora.redirectlinks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
public class LinkDTO {
    private AtomicLong linkId;
    private String url;
}
