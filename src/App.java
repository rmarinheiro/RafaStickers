import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 1-fazer requisição http e buscar top 250 tops;
         * 2- extrair só os dados que interessam(titulo,poster,classificação);
         * 3- exibit e manipular os dados;
         */

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extraio os dados que interessam
        JsonParse jsonParse = new JsonParse();
        List<Map<String, String>> listaFilmes = jsonParse.parse(body);
        GeradoraDeFigurinhas geradoraDeFigurinhas = new GeradoraDeFigurinhas();

        for (Map<String, String> filme : listaFilmes) {

            InputStream inputStream = new URL(filme.get("image")).openStream();

            String titulo = filme.get("title");
            geradoraDeFigurinhas.criarFigurinha(inputStream, titulo + ".png");

            System.out.println(filme.get("title"));
            System.out.println(filme.get("imDbRating"));
            String nota = filme.get("imDbRating");
            Double avaliacao = Double.parseDouble(nota);
            if (avaliacao >= 9.0) {
                System.out.println("Filme Bão\n");
                

            } else {
                System.out.println("Filme Meia Boca\n");
            }
        }

        //
        // System.out.println(listaFilmes.get(0));

    }

}
