package br.com.house.adapter.controller;

import br.com.house.adapter.controller.payload.request.FamilyRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FamilyController {

  @PostMapping
  ResponseEntity<Object> add(@Valid @RequestBody FamilyRequest familyRequest);

  @GetMapping("/{id}")
  ResponseEntity<Object> loadFamily(@PathVariable("id") Long id);

  @GetMapping
  ResponseEntity<Object> loadFamilies();
}
