package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}") //yaml에 naver.client.id
    private String naverClientId;

    @Value("${naver.client.secret}") //yaml에 naver.client.secret
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    //네이버 요청할때 어떤 파라미터가 들어 가는지(요청변수)
    public  SearchLocalRes localSearch(SearchLocalReq searchLocalReq){
        //요청하는 주소
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();
        //header
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};


       var responseEntity= new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();



    }
    public void imageSearch(){

    }



}
