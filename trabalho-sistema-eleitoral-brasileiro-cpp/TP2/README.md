# Dupla 
Elaine Dias Pires - 2020101903

Filipe Gomes Arante de Souza - 2020100625

# Observações sobre o trabalho:

## Script de testes
O script de testes (test.sh) não acusava nenhum erro, mas também não apontava que os outputs estavam corretos.

Provavelmente este erro se dá devido a implementarmos o código no windows, e ao dar uma quebra de linha,
está colocando "\r\n" ao invés de apenas "\n".

Rodamos diffs para todos os casos de testes disponíveis no AVA e em todos não houve nenhuma diferença.

## Créditos ao professor Vitor
Utilizamos as bibliotecas disponibilizadas pelo professor Vitor em seu github.
