package com.techruna.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techruna.model.UrlMapping;
import com.techruna.repository.UrlMapRepository;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {
	
	@Autowired
	UrlMapRepository urlMapRepository;

	@Override
	public String registrarUrl(String url) {
		UrlMapping urlMapping = new UrlMapping();
		urlMapping.setShortUrl(generarUrl(url));
		urlMapping.setUrlOrigen(url);
		urlMapRepository.save(urlMapping);
		return urlMapping.getShortUrl();
	}

	@Override
	public Optional<UrlMapping> obtenerUrlOriginal(String urlShort) {
		return urlMapRepository.findByShortUrl(urlShort);
	}
	
	private String generarUrl(String originalUrl) {
		return Base64.getUrlEncoder().encodeToString(originalUrl.getBytes(StandardCharsets.UTF_8)).substring(0, 6);
	}

}
