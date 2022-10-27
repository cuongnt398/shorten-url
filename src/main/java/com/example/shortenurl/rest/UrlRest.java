package com.example.shortenurl.rest;

import com.example.shortenurl.common.BaseResponse;
import com.example.shortenurl.entity.UrlEntity;
import com.example.shortenurl.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Slf4j
public class UrlRest {

    @Autowired
    private UrlService urlService;

    @PostMapping("api/v1/data/shorten")
    public BaseResponse<UrlEntity> generateShortenUrl(@RequestParam("longUrl") String longUrl) {
        log.info("Generate shortenUrl from longUrl {}", longUrl);
        UrlEntity urlEntity = urlService.generateShortenUrl(longUrl);
        urlService.save(urlEntity);
        return BaseResponse.success(urlEntity);
    }

    @GetMapping("/{shortenUrl}")
    public RedirectView redirectToLongUrl(@PathVariable String shortenUrl) {
        return urlService.findByShortUrl(shortenUrl)
                .map(UrlEntity::getLongUrl)
                .map(RedirectView::new)
                .orElse(new RedirectView("/"));
    }

}
