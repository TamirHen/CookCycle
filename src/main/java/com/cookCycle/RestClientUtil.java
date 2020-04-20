//
//
//package com.cookCycle.webService;
//import java.net.URI;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import com.cookCycle.model.RecipeCategory;
//
//public class RestClientUtil {
//    public void getArticleByIdDemo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/spring-app/user/recipeCategory/{id}";
//        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//        ResponseEntity<RecipeCategory> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RecipeCategory.class, 1);
//        RecipeCategory recipeCategory = responseEntity.getBody();
//        System.out.println("Id:"+recipeCategory.getId()+", Name:"+recipeCategory.getName());
//    }
//    public void getAllRecipeCategoryDemo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/spring-app/user/recipeCategory";
//        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//        ResponseEntity<RecipeCategory[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RecipeCategory[].class);
//        RecipeCategory[] recipeCategories = responseEntity.getBody();
//        for(RecipeCategory recipeCategory : recipeCategories) {
//            System.out.println("Id:"+recipeCategory.getId()+", Name:"+recipeCategory.getName());
//        }
//    }
//    public void addRecipeCategoryDemo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/spring-app/user/recipeCategory";
//        RecipeCategory objRecipeCategory = new RecipeCategory("Test Spring REST");
//        HttpEntity<RecipeCategory> requestEntity = new HttpEntity<RecipeCategory>(objRecipeCategory, headers);
//        URI uri = restTemplate.postForLocation(url, requestEntity);
//        System.out.println(uri.getPath());
//    }
//    public void updateArticleDemo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/spring-app/user/recipeCategory";
//        RecipeCategory objRecipeCategory = new RecipeCategory("Updated Name");
//        HttpEntity<RecipeCategory> requestEntity = new HttpEntity<RecipeCategory>(objRecipeCategory, headers);
//        restTemplate.put(url, requestEntity);
//    }
//    public void deleteArticleDemo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/spring-app/user/recipeCategory/{id}";
//        HttpEntity<RecipeCategory> requestEntity = new HttpEntity<RecipeCategory>(headers);
//        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
//    }
//    public static void main(String args[]) {
//        RestClientUtil util = new RestClientUtil();
//        //util.getArticleByIdDemo();
//        util.addRecipeCategoryDemo();
//        //util.updateArticleDemo();
//        //util.deleteArticleDemo();
//        util.getAllRecipeCategoryDemo();
//    }
//}