package com.yaliprowess.spring.session.basic.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component(value = "restClient")
public class RestClient implements FactoryBean<RestTemplate>, InitializingBean {
    private RestTemplate restTemplate = null;

    public RestClient() {
        super();
    }

    private HttpComponentsClientHttpRequestFactory ignoreCertAndHostVerification() {
        final int timeout = 5;
        final RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();
        final HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);

        return requestFactory;
    }

    public void afterPropertiesSet() throws Exception {
        restTemplate = new RestTemplate(ignoreCertAndHostVerification());
    }

    public RestTemplate getObject() throws Exception {
        return restTemplate;
    }

    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
