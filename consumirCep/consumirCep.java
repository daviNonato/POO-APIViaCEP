//DAVI NONATO DO NASCIMENTO 
//0025601

package consumirCep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consumirCep {

    public static void main(String[] args) {

        String cep = "72546715";

        String url = "https://viacep.com.br/ws/" + cep + "/json";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println(response.body());

        } catch (Exception e) {

            System.out.print("Erro ao consultar o CEP " + e.getMessage());

        }
    }
}

