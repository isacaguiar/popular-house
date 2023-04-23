package br.com.house.utils;

import br.com.house.adapter.controller.payload.request.FamilyRequest;
import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.controller.payload.response.ListFamilyResponse;
import br.com.house.adapter.controller.payload.response.PointsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

  public static PointsResponse toPointsResponse(String jsonData) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, PointsResponse.class);
  }

  public static FamilyResponse toFamilyResponse(String jsonData) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, FamilyResponse.class);
  }

  public static FamilyRequest toFamilyRequest(String jsonData) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, FamilyRequest.class);
  }

  public static ListFamilyResponse toListFamilyResponse(String jsonData) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, ListFamilyResponse.class);
  }

}
