package br.com.house.adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.house.adapter.controller.payload.request.FamilyRequest;
import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.controller.payload.response.ListFamilyResponse;
import br.com.house.adapter.controller.payload.response.PointsResponse;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Family;
import br.com.house.domain.model.Points;
import br.com.house.domain.service.FamilyService;
import br.com.house.utils.BuilderUtils;
import br.com.house.utils.FileUtils;
import br.com.house.utils.JSONUtils;
import java.util.List;
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
  void addFamilyWithSuccess() throws Exception {
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

    verify(familyService).add(any());
  }

  @Test
  void addFamilyWithThrowsBusinessException() throws Exception {
    when(familyService.add(any())).thenThrow(BusinessException.class);

    String request = FileUtils.loadRequest("add-family");
    FamilyRequest familyRequest = JSONUtils.toFamilyRequest(request);
    Family family = familyRequest.toModel();

    mvc.perform(
            post(PATH)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(BusinessException.class, () -> familyService.add(family));

  }

  @Test
  void loadByIdWithSuccess() throws Exception {

    Family family = BuilderUtils.loadFamily();
    when(familyService.loadById(any())).thenReturn(family);

    MvcResult result = mvc.perform(
            get(PATH + "/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andReturn();
    String content = result.getResponse().getContentAsString();

    FamilyResponse response = JSONUtils.toFamilyResponse(content);

    assertNotNull(response);
    assertNotNull(response.getPerson());
    assertNotNull(response.getPersons());

    verify(familyService).loadById(any());
  }

  @Test
  void loadByIdWithThrowsBusinessException() throws Exception {
    when(familyService.loadById(any())).thenThrow(BusinessException.class);

    mvc.perform(get(PATH + "/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(BusinessException.class, () -> familyService.loadById(any()));
  }

  @Test
  void loadAllWithSuccess() throws Exception {

    List<Family> list = BuilderUtils.loadFamilies();
    when(familyService.loadAll()).thenReturn(list);

    MvcResult result =
        mvc.perform(get(PATH).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful())
            .andReturn();
    String content = result.getResponse().getContentAsString();

    ListFamilyResponse response = JSONUtils.toListFamilyResponse(content);

    assertNotNull(response);

    verify(familyService).loadAll();
  }

  @Test
  void loadAllWithThrowsBusinessException() throws Exception {
    when(familyService.loadAll()).thenThrow(BusinessException.class);

    mvc.perform(get(PATH).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(BusinessException.class, () -> familyService.loadAll());
  }

  @Test
  void deleteWithSuccess() throws Exception {
    long id = 120L;

    doNothing().when(familyService).delete(id);

    mvc.perform(delete(PATH + "/" + id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andReturn();

    verify(familyService).delete(id);
  }

  @Test
  void deleteWithThrowsBusinessException() throws Exception {
    doThrow(new BusinessException("Error")).when(familyService).delete(any());

    mvc.perform(
            delete(PATH + "/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());

    assertThrows(BusinessException.class, () -> familyService.delete(any()));
  }

}