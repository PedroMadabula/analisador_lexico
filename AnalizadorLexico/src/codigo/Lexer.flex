package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
white=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
int | double | float | boolean | String | long |
short | char | byte |
if | instanceof | return | switch | default | 
else | continue | case | do | break |
while |
private | protected | public | 
abstract | class | extends | final | implements |
interface | native | new | static | strictfp |
synchronized | transient | volatile | assert |
catch | finally | throw | throws | try | import | 
package | super | this | void | args
{lexeme=yytext(); return Reservada;}
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {lexeme=yytext(); return Linha;}
"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Soma;}
"++" {lexeme=yytext(); return Incremento;}
"-" {lexeme=yytext(); return Subtracao;}
"--" {lexeme=yytext(); return Decremento;}
"*" {lexeme=yytext(); return Multiplicacao;}
"/" {lexeme=yytext(); return Divisao;}
"%" {lexeme=yytext(); return Resto;}
"(" | ")" | "{" | "}" | "[" | "]" | ";" | "," | "." {lexeme=yytext(); return Separador;}
"&&" | "||" | "!" {lexeme=yytext(); return Op_Logico;}
">" | "<" | ">=" | "<=" | "!=" | "==" {lexeme=yytext(); return Op_Comparacao;}
"=" | "+=" | "-=" | "*=" | "/=" | "%=" | "&=" {lexeme=yytext(); return Op_Atribuicao;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERRO;}
