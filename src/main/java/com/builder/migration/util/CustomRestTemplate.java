package com.builder.migration.util;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomRestTemplate {

    // @Bean
    // public RestTemplate restTemplate() throws Exception {
    //     // SSLContext를 생성하여 SSL 검증을 무시
    //     SSLContext sslContext = SSLContext.getInstance("TLS");
    //     sslContext.init(null, new TrustManager[] { new X509TrustManager() {
    //         public X509Certificate[] getAcceptedIssuers() {
    //             return null;
    //         }
    //         public void checkClientTrusted(X509Certificate[] certs, String authType) {
    //         }
    //         public void checkServerTrusted(X509Certificate[] certs, String authType) {
    //         }
    //     } }, new java.security.SecureRandom());

    //     HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    //     HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

    //     // SimpleClientHttpRequestFactory 설정
    //     // Invalid HTTP method: PATCH] with root cause
    //     // SimpleClientHttpRequestFactory -> HttpComponentsClientHttpRequestFactory 변경
    //     // rg/apache/hc/client5/http/classic/HttpClient not fuond -> httpclient5 5.1.2로 변경
    //     // java.lang.NoSuchMethodError: 'org.apache.hc.core5.http.ClassicHttpResponse org.apache.hc.client5.http.classic.HttpClient.executeOpen(org.apache.hc.core5.http.HttpHost, org.apache.hc.core5.http.ClassicHttpRequest, org.apache.hc.core5.http.protocol.HttpContext)
    //     HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    //     return new RestTemplate(factory);
    // }

    // @Bean
    // public RestTemplate restTemplate() throws Exception {
    //     // SSLContext 생성
    //     SSLContext sslContext = SSLContextBuilder.create()
    //             .loadTrustMaterial((chain, authType) -> true)
    //             .build();

    //     // HttpClient 설정
    //     CloseableHttpClient httpClient = HttpClients.custom()
    //             .setSSLContext(sslContext)
    //             .setSSLHostnameVerifier(new NoopHostnameVerifier())
    //             .build();

    //     // SimpleClientHttpRequestFactory 설정
    //     // Invalid HTTP method: PATCH] with root cause
    //     // SimpleClientHttpRequestFactory -> HttpComponentsClientHttpRequestFactory 변경
    //     // rg/apache/hc/client5/http/classic/HttpClient not fuond -> httpclient5 5.1.2로 변경
    //     // java.lang.NoSuchMethodError: 'org.apache.hc.core5.http.ClassicHttpResponse org.apache.hc.client5.http.classic.HttpClient.executeOpen(org.apache.hc.core5.http.HttpHost, org.apache.hc.core5.http.ClassicHttpRequest, org.apache.hc.core5.http.protocol.HttpContext)
    //     // 코드 변경시 The method setSSLContext(SSLContext) is undefined for the type HttpClientBuilder
           // httpClient 5.1.2 -> 5.3.1 버전으로 상향
    //     HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    //     return new RestTemplate(factory);
    // }
    @Bean
	HttpClient httpClient() throws Exception {
		
		// 모든 인증서를 신뢰하도록 설정한다
		TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
		
		// Https 인증 요청시 호스트네임 유효성 검사를 진행하지 않게 한다.
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
			.register("https", sslsf)
			.register("http", new PlainConnectionSocketFactory()).build();
		
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setConnectionManager(connectionManager);
		return httpClientBuilder.build();
		
	}
	
	@Bean
	HttpComponentsClientHttpRequestFactory factory(HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setHttpClient(httpClient);
		
		return factory;
	}

	@Bean
	RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory factory) {
		return new RestTemplate(factory);
	}
}