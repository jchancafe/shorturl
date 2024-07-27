package com.techruna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techruna.model.UrlMapping;

public interface UrlMapRepository extends JpaRepository<UrlMapping, Long> {
	Optional<UrlMapping> findByShortUrl(String shortUrl);
}
