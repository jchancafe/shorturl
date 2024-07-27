package com.techruna.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techruna.model.UrlMapping;
import com.techruna.service.ShortUrlService;

@RestController
@RequestMapping("/api")
public class shortUrlController {
	
	@Autowired
	private ShortUrlService shortUrlService;
	
	@PostMapping("/shortIn")
	public ResponseEntity<String> shortInUrl(@RequestBody com.techruna.dto.urlDTO urlDTO) {
		String shortUrl = shortUrlService.registrarUrl(urlDTO.getUrl());
		return ResponseEntity.ok(shortUrl);
	}
	
	@GetMapping("/{shortUrl}")
	public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) throws URISyntaxException {
		Optional<UrlMapping> urlMapping = shortUrlService.obtenerUrlOriginal(shortUrl);
		if(urlMapping.isPresent()) {
			URI uri = new URI(urlMapping.get().getUrlOrigen());
			return ResponseEntity.status(302).location(uri).build();
		}
		return ResponseEntity.notFound().build();
	}
}
