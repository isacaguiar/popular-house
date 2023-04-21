package br.com.house.adapter.controller;

import br.com.house.adapter.controller.payload.request.FamilyRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface FamilyController {

  @PostMapping
  ResponseEntity<Object> add(@Valid @RequestBody FamilyRequest familyRequest);
}
