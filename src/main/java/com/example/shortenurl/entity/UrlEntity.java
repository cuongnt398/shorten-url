package com.example.shortenurl.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document("url_entity")
public class UrlEntity {

    @Id
    private long id;

    @Field(name = "short_url")
    private String shortUrl;

    @Field(name = "long_url")
    private String longUrl;

    @CreatedDate
    private Date createdDate;
}
