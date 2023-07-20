package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {

    private final RequestLine requestLine;
    // 사실 헤더랑 바디도 있어야 진짜 완성이다.
    public Object getQueryString;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }



    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
