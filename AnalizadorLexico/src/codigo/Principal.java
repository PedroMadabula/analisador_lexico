package codigo;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        String lexer = "E:/GitHub Projects/analisador_lexico/AnalizadorLexico/src/codigo/Lexer.flex";
        gerarLexer(lexer);
    }
    public static void gerarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
