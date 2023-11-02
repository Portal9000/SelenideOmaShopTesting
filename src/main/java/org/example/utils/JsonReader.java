package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.BreadCrumbs;
import org.example.models.TestData;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        String filePath = "src/test/resources/test-data/testData.json";
        List<TestData> userDataList = readUserDataFromJson(filePath);
        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }
        return data;
    }

    private List<TestData> readUserDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

    @DataProvider(name = "productData")
    public Object[][] getProductData() throws IOException {
        String filePath = "src/test/resources/test-data/testData.json";
        List<TestData> productDataList = readProductDataFromJson(filePath);
        Object[][] data = new Object[productDataList.size()][1];
        for (int i = 0; i < productDataList.size(); i++) {
            data[i][0] = productDataList.get(i);
        }
        return data;
    }

    private List<TestData> readProductDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

//    @DataProvider(name = "BreadCrumbs")
//    public Object[][] getBreadCrumbs() throws IOException {
//        String filePath = "src/test/resources/test-data/BreadCrumbs.json";
//        List<BreadCrumbs> breadCrumbsList = readTestDataFromJson(filePath);
//        Object[][] data = new Object[breadCrumbsList.size()][1];
//        for (int i = 0; i < breadCrumbsList.size(); i++) {
//            data[i][0] = breadCrumbsList.get(i);
//        }
//        return data;
//    }
//
//    private List<BreadCrumbs> readTestDataFromJson(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(filePath);
//        try (FileInputStream fis = new FileInputStream(file)) {
//            return objectMapper.readValue(fis, new TypeReference<>() {
//            });
//        }
//    }
}