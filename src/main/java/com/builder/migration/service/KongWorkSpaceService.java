package com.builder.migration.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class KongWorkSpaceService {
    
    public void putKongWorkSpace(String name) throws Exception {
        // URL 설정
        URL url = new URL("http://192.168.1.83:8001/workspaces");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 요청 메소드 설정
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);

        // 요청 본문 작성
        String data = "name=workspace_4";
        byte[] out = data.getBytes();
        
        // 데이터 전송
        try (OutputStream os = conn.getOutputStream()) {
            os.write(out);
        }

        // 응답 코드 확인
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // 응답 메시지 확인
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
            System.out.println("Workspace created successfully.");
        } else {
            System.out.println("Failed to create workspace. Response Code: " + responseCode);
        }

        // 연결 종료
        conn.disconnect();
    }
}
