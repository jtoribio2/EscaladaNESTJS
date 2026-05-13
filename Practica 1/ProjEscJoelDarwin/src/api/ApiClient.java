package api;
import java.net.URI;
import java.net.http.*;

public class ApiClient {

    private final HttpClient client;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Pasandole la direccion de un endpoint esta funcion devuelve la respuesta que se guarda en el body en formato string para que luego la trate el jackson
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
}