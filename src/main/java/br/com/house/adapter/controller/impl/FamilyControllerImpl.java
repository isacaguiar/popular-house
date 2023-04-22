package br.com.house.adapter.controller.impl;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import br.com.house.adapter.controller.FamilyController;
import br.com.house.adapter.controller.payload.request.FamilyRequest;
import br.com.house.adapter.controller.payload.response.PointsResponse;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Family;
import br.com.house.domain.service.FamilyService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/family")
public class FamilyControllerImpl implements FamilyController {

  @Autowired
  FamilyService familyService;

  public ResponseEntity<Object> add(@Valid @RequestBody FamilyRequest familyRequest) {

    PointsResponse pointsResponse;
    try {
      pointsResponse = familyService.add(familyRequest.toModel()).toResponse();
      log.info("Successfull add family");
    } catch (BusinessException exception) {
      log.error("Error on add family");
      return new ResponseEntity<>(exception.getMessage(), UNPROCESSABLE_ENTITY);
    } catch (NullPointerException exception) {
      exception.printStackTrace();
      log.error("Error on add family");
      return new ResponseEntity<>("Error on add family.", UNPROCESSABLE_ENTITY);
    }
    return ResponseEntity.ok(pointsResponse);
  }

  @Override
  public ResponseEntity<Object> loadFamily(Long id) {
    //TODO Adicionar response
    Family familyResponse;
    try {
      familyResponse = familyService.loadFamily(id);
      log.info("Successfull load family");
    } catch (BusinessException exception) {
      log.error("Error on load family");
      return new ResponseEntity<>(exception.getMessage(), UNPROCESSABLE_ENTITY);
    } catch (NullPointerException exception) {
      exception.printStackTrace();
      log.error("Error on load family");
      return new ResponseEntity<>("Error on load family.", UNPROCESSABLE_ENTITY);
    }
    return ResponseEntity.ok(familyResponse);
  }

  @Override
  public ResponseEntity<Object> loadFamilies() {
    //TODO Adicionar response
    List<Family> familyList;
    try {
      familyList = familyService.loadFamilies();
      log.info("Successfull load all family");
    } catch (BusinessException exception) {
      log.error("Error on load all family");
      return new ResponseEntity<>(exception.getMessage(), UNPROCESSABLE_ENTITY);
    } catch (NullPointerException exception) {
      exception.printStackTrace();
      log.error("Error on load all family");
      return new ResponseEntity<>("Error on load all family.", UNPROCESSABLE_ENTITY);
    }
    return ResponseEntity.ok(familyList);
  }
}
