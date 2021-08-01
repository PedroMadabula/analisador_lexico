package codigo;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        String lexer = "./src/codigo/Lexer.flex";
        gerarLexer(lexer);
    }
    public static void gerarLexer(String ruta){
        File arquivo = new File(ruta);
        JFlex.Main.generate(arquivo);
    }
}
