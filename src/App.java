import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 1-fazer requisição http e buscar top 250 tops;
         * 2- extrair só os dados que interessam(titulo,poster,classificação);
         * 3- exibit e manipular os dados;
         */

        //String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
         //String url ="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        String url = "http://localhost:8081/linguagens";

         var http = new ClientHttp();
         String json = http.buscaDados(url);

        // extraio os dados que interessam
        var extrator = new ExtratadorConteudoIMD();
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        GeradoraDeFigurinhas geradoraDeFigurinhas = new GeradoraDeFigurinhas();

        for (Conteudo conteudo :  conteudos) {

            // InputStream inputStream = new URL(filme.get("image")).openStream();
            InputStream inputStream = new URL(conteudo.getUrl()).openStream();

            String titulo = conteudo.getTitulo();
            geradoraDeFigurinhas.criarFigurinha(inputStream, titulo + ".png");

            System.out.println(conteudo.getTitulo());
            /*
             * System.out.println(filme.get("imDbRating"));
             * //String nota = filme.get("imDbRating");
             * /Double avaliacao = Double.parseDouble(nota);
             * if (avaliacao >= 9.0) {
             * // System.out.println("Filme Bão\n");
             * System.out.println(colorize("Filme Bão", RED_TEXT()));
             * System.out.println("\n");
             * 
             * 
             * 
             * } else {
             * System.out.println("Filme Meia Boca\n");
             * }
             */
        }

        //
        // System.out.println(listaFilmes.get(0));

    }

}
