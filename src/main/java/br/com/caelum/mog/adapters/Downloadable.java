package br.com.caelum.mog.adapters;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.function.Supplier;

public class Downloadable extends HttpEntity<byte[]> {

    private final HttpEntity<byte[]> httpEntity;

    public Downloadable(byte[] bytes, Supplier<String> lazinessFilename) {
        this(bytes, lazinessFilename.get());
    }

    private Downloadable(byte[] bytes, String filename) {

        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filename+"\"");

        httpEntity = new HttpEntity<>(bytes, headers);
    }

    public HttpHeaders getHeaders() {
        return httpEntity.getHeaders();
    }

    public byte[] getBody() {
        return httpEntity.getBody();
    }

    public boolean hasBody() {
        return httpEntity.hasBody();
    }

    public boolean equals(Object other) {
        return httpEntity.equals(other);
    }

    public int hashCode() {
        return httpEntity.hashCode();
    }

    public String toString() {
        return httpEntity.toString();
    }
}
