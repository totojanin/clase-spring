package com.practicaintegradora.redirectlinks.services;

import java.util.concurrent.atomic.AtomicLong;

public interface LinkService {
    AtomicLong createLink(String url);
}