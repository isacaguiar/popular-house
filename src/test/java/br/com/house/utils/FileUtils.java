package br.com.house.utils;

import java.io.File;
import java.nio.file.Files;
import org.springframework.util.ResourceUtils;

public class FileUtils {
  public static final String loadRequest(String filename) throws Exception {
    return loadFile("classpath:requests/" + filename + ".json");
  }

  public static String loadResponse(String filename) throws Exception {
    return loadFile("classpath:responses/" + filename + ".json");
  }

  private static String loadFile(String filePath) throws Exception {
    File file = ResourceUtils.getFile(filePath);
    return new String(Files.readAllBytes(file.toPath()));
  }
}
