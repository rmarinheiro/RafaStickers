
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void criarFigurinha(InputStream inputStream,String nomeArquivo) throws Exception {

        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_8.jpg").openStream();
        //InputStream inputStream = new FileInputStream("entrada/Filme.jpg");
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);

        var fonte = new Font(Font.SANS_SERIF,Font.BOLD,100);
        graphics.setFont(fonte);

        graphics.setColor(Color.RED);

        graphics.drawString("RafaStick", 80, novaAltura - 100);

        ImageIO.write(novaImagem, "jpg", new File(nomeArquivo));

       

        /*
         * 1-Leitura da Imagem

          2 -criar uma nova imagem com transparencia  e com tamnaho novo
          
          3- copiar a imagem original pra nova imagem

          4- escrever uma frase na imagem nova

          5- escrever a nova imagem
    
         */  

    }
    
}
