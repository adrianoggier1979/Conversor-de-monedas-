import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Moneda convertidorMoneda(String MonedaBase, String MonedaFinal, double Importe){
        URI enlace = URI.create("https://v6.exchangerate-api.com/v6/ad10f8827eda05bbcc105bb4/pair/" + MonedaBase + "/" + MonedaFinal + "/" + Importe);

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(enlace).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new GsonBuilder().setPrettyPrinting().create().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
