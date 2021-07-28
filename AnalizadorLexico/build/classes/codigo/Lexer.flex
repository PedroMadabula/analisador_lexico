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
package | super | this | void
{lexeme=yytext(); return Reservadas;}
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
