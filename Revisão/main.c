#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "aluno.h"
#include "vetor_aluno.h"

#define TAM 50

int main(int argc, char** argv){
    char fileName[TAM];
    
    if(argc == 1){ // Não foram passados argumentos na linha de comando.
        scanf("%s", fileName);
    
    } else if(argc == 2){ // Passou nome do arquivo na linha de comando.
        strcpy(fileName, argv[1]);

    } else{ // Passou argumentos demais na linha de comando.
        printf("Insira apenas 1 argumento na linha de comando.\n");
        exit(1);
    }
    
    Vetor* vetor = cria_vetor(fileName);

    ordena_vetor(vetor);

    imprime_vetor(vetor);
    printf("\n");
    imprime_vetor_acima_media_turma(vetor);
    imprime_csv_aprovados_reprovados(vetor);

    libera_vetor(vetor);
    return 0;
}
