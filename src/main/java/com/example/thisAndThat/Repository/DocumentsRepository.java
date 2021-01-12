package com.example.thisAndThat.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.thisAndThat.entity.Document;

@Repository
public interface DocumentsRepository extends CrudRepository<Document, Integer> {}
