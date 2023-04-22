package br.com.house.adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.house.adapter.controller.payload.response.PointsResponse;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Points;
import br.com.house.domain.service.FamilyService;
import br.com.house.utils.BuilderUtils;
import br.com.house.utils.FileUtils;
import br.com.house.utils.JSONUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ExtendWith(SpringExtension.class)
@WebMvcTest({FamilyController.class})
@AutoConfigureMockMvc
class FamilyControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  FamilyService familyService;

  final String PATH = "/family";

  @Test
  void buyWithSuccess() throws Exception {

    Points points = BuilderUtils.getPoint("Claudio", 120);

    when(familyService.add(any())).thenReturn(points);

    MvcResult result = mvc.perform(
            post(PATH)
                .content(FileUtils.loadRequest("add-family"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andReturn();
    String content = result.getResponse().getContentAsString();

    PointsResponse pointsResponse =
        JSONUtils.toPointsResponse(content);

    assertNotNull(pointsResponse);
    assertNotNull(pointsResponse.getResponsibleName());
    assertEquals(points.getResponsibleName(), pointsResponse.getResponsibleName());
    assertEquals(points.getScore(), pointsResponse.getScore());
  }

  @Test
  void buyWithThrowsBusinessException() throws Exception {
    when(familyService.add(any())).thenThrow(BusinessException.class);

    mvc.perform(
            post(PATH)
                .content(FileUtils.loadRequest("add-family"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(BusinessException.class, () -> {
      familyService.add(any());
    });

  }

  @Test
  void buyWithThrowsNullPointerException() throws Exception {
    when(familyService.add(any())).thenThrow(NullPointerException.class);

    mvc.perform(
            post(PATH)
                .content(FileUtils.loadRequest("add-family"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(NullPointerException.class, () -> {
      familyService.add(any());
    });

  }


}