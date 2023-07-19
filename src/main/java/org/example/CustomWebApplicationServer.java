package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] start {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                /**
                 * step - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */

                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while ((line = br.readLine()) != ""){
                        System.out.println(line);
                    }
                    /**
                     * GET /calculate?operand1=11&opeator=*&operrand2=55 HTTP/1.1 // org.example.Main.RequestLine
                     * Host: localhost:8080
                     * Connection: Keep-Alive
                     * User-Agent: Apache-HttpClient/4.5.14 (Java/17.0.7)
                     * Accept-Encoding: br,deflate,gzip,x-gzip
                     * 이러한 내용을 파싱해서 누군가가 스프링으로 적절한 요청을 보낼 것이다. 이게 톰캣이다.
                     * 지금 우리가 하고 있는 것은 커스텀한 톰캣이다. 톰갯 = WAS
                     */
                }
            }
        }
    }
}
