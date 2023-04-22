package br.com.house.utils;

import br.com.house.adapter.controller.payload.response.PointsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

  public static PointsResponse toPointsResponse(String jsonData) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, PointsResponse.class);
  }

}
