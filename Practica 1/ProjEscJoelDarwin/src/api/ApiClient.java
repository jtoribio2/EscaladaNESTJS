package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.dto.api.ApiVersionDTO;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.*;

public class ApiClient {

    private final HttpClient client;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Pasandole la direccion de un endpoint esta funcion devuelve la respuesta que se guarda en el body en formato string para que luego la trate el jackson
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String get(String url) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }

    /**
     * Entra en el endpoint de la api donde muestra la version y la devuelve en forma DTO
     * @return
     * @throws Exception
     */
    public ApiVersionDTO obtenirVersio() throws Exception {

        String response = get("http://localhost:3000/v1/version");

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                response,
                ApiVersionDTO.class
        );
    }
}
