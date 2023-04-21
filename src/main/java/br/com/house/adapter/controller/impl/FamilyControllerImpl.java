package br.com.house.adapter.controller.impl;

import br.com.house.adapter.controller.FamilyController;
import br.com.house.adapter.controller.payload.request.FamilyRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/family")
public class FamilyControllerImpl implements FamilyController {

  public ResponseEntity<Object> add(@Valid @RequestBody FamilyRequest familyRequest) {
    log.info("Add family");
    System.out.println(familyRequest);
    return null;
  }
}
