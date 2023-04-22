package br.com.house.adapter.controller;

import br.com.house.adapter.controller.payload.request.FamilyRequest;
import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.controller.payload.response.PointsResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FamilyController {

  @PostMapping
  ResponseEntity<PointsResponse> add(@Valid @RequestBody FamilyRequest familyRequest);

  @GetMapping("/{id}")
  ResponseEntity<FamilyResponse> loadById(@PathVariable("id") Long id);

  @GetMapping
  ResponseEntity<List<FamilyResponse>> loadAll();

  @DeleteMapping("/{id}")
  ResponseEntity<String> delete(@PathVariable("id") Long id);
}
