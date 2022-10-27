package com.example.shortenurl.repository;

import com.example.shortenurl.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<UrlEntity, Long> {

    @Query("{short_url:  ?0}")
    Optional<UrlEntity> findByShortUrl(String shortenUrl);
}
