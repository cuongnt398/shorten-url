package com.example.shortenurl.service;

import com.example.shortenurl.entity.UrlEntity;
import com.example.shortenurl.repository.UrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class UrlService {
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private Base62Conversion base62Conversion;

    @Autowired
    private UrlRepository urlRepository;

    public UrlEntity generateShortenUrl(String longUrl) {
        long uniqueId = sequenceGenerator.nextId();
        String shortenUrl = base62Conversion.convertFromId(uniqueId);
        log.info("Convert longUrl: {} to shortUrl: {} and id: {}", longUrl, shortenUrl, uniqueId);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setId(uniqueId);
        urlEntity.setShortUrl(shortenUrl);
        urlEntity.setLongUrl(longUrl);
        urlEntity.setCreatedDate(new Date());
        return urlEntity;
    }

    public void save(UrlEntity urlEntity) {
        urlRepository.save(urlEntity);
    }

    public Optional<UrlEntity> findByShortUrl(String shortenUrl) {
        return urlRepository.findByShortUrl(shortenUrl);
    }
}
