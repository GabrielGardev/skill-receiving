package com.softuni.exodia.repositories;

import com.softuni.exodia.domain.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
}
