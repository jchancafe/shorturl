package com.techruna.service;

import java.util.Optional;

import com.techruna.model.UrlMapping;

public interface ShortUrlService {
	String registrarUrl(String url);
	Optional<UrlMapping> obtenerUrlOriginal(String url);
}
