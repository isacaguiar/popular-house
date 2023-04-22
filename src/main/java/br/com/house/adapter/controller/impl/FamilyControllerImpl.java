package br.com.house.adapter.controller.impl;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import br.com.house.adapter.controller.FamilyController;
import br.com.house.adapter.controller.payload.request.FamilyRequest;
import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.controller.payload.response.PointsResponse;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Points;
import br.com.house.domain.service.FamilyService;
import br.com.house.domain.utils.BuilderUtils;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(value = "/family")
public class FamilyControllerImpl implements FamilyController {

  @Autowired
  FamilyService familyService;

  public ResponseEntity<PointsResponse> add(@Valid @RequestBody FamilyRequest familyRequest) {

    PointsResponse pointsResponse;
    try {
      Points points = familyService.add(familyRequest.toModel());
      pointsResponse = points.toResponse();
      log.info("Successfull add family");
    } catch (BusinessException exception) {
      log.error(exception.getMessage());
      throw new ResponseStatusException(UNPROCESSABLE_ENTITY, exception.getMessage(), exception);
    }
    return ResponseEntity.ok(pointsResponse);
  }

  @Override
  public ResponseEntity<FamilyResponse> loadById(Long id) {
    FamilyResponse familyResponse;
    try {
      familyResponse = familyService.loadById(id).toReponse();
      log.info("Successfull load family");
    } catch (BusinessException exception) {
      log.error(exception.getMessage());
      throw new ResponseStatusException(UNPROCESSABLE_ENTITY, exception.getMessage(), exception);
    }
    return ResponseEntity.ok(familyResponse);
  }

  @Override
  public ResponseEntity<List<FamilyResponse>> loadAll() {
    List<FamilyResponse> familyList;
    try {
      familyList = BuilderUtils.toResponse(familyService.loadAll());
      log.info("Successfull load all families");
    } catch (BusinessException exception) {
      log.error(exception.getMessage());
      throw new ResponseStatusException(UNPROCESSABLE_ENTITY, exception.getMessage(), exception);
    }
    return ResponseEntity.ok(familyList);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    try {
      familyService.delete(id);
    } catch (BusinessException exception) {
      log.error(exception.getMessage());
      throw new ResponseStatusException(UNPROCESSABLE_ENTITY, exception.getMessage(), exception);
    }
    return ResponseEntity.ok("Family excluded with success");
  }
}
