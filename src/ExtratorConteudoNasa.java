import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudo(String json){
        JsonParse jsonParse = new JsonParse();
        List<Map<String, String>> listaDeAtributos = jsonParse.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("hdurl");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
