package com.practicaintegradora.redirectlinks.repositories;

import java.util.concurrent.atomic.AtomicLong;

public interface LinkRepository {
    AtomicLong createLink(String url);
}
