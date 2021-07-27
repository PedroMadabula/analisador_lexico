package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
white=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int |
if |
else |
while {lexeme=yytext(); return Reservadas;}
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return Igual;}
"+" {return Soma;}
"-" {return Subtracao;}
"*" {return Multiplicacao;}
"/" {return Divisao;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERRO;}
