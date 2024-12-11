package com.pedroajs.mysongapi.application.infra.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        OkHttpClient client = createUnsafeClient(); // Cria o cliente inseguro apenas para desenvolvimento
        System.out.println("Custom OkHttpClient configurado com sucesso.");

        return new Retrofit.Builder()
                .baseUrl("https://api.discogs.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client) // Adiciona o cliente inseguro ao Retrofit
                .build();
    }

    // Método para criar um OkHttpClient que ignora validações de SSL - Somente para desenvolvimento
    private OkHttpClient createUnsafeClient() {
        try {
            // Confia em todos os certificados
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            // Cria o SSLContext que confia em todos os certificados
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true) // Ignora a verificação do hostname
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao configurar cliente HTTP inseguro", e);
        }
    }
}
