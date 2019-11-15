package com.example.nimvb.edge.fallbacks;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class ServiceFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.toString();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                return new ByteArrayInputStream("Service is not available at the moment.".getBytes(StandardCharsets.UTF_8));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccessControlAllowCredentials(true);
                headers.setAccessControlAllowOrigin("*");
                return headers;
            }
        };
    }
}
