#include "vetor_aluno.h"

#define TAM 50
#define MEDIA 7

struct vetor{
    int tam;
    Aluno** alunos;
};

Vetor* cria_vetor(char* fileName){
    FILE *f = fopen(fileName, "r");
    if(f == NULL){
        printf("Erro na abertura do arquivo.\n");
        exit(1);
    }
    
    int tam;
    fscanf(f, "%d\n", &tam);

    Vetor* vetor = (Vetor*) malloc(sizeof(Vetor));
    vetor->tam = tam;

    vetor->alunos = (Aluno**) malloc(tam * sizeof(Aluno*));

    float nota;
    char nome[TAM];
    
    for(int i = 0; i < tam; i++){
        fscanf(f, "%f %[^\n]\n", &nota, nome);
        vetor->alunos[i] = cria_aluno(nome, nota);
    }

    fclose(f);
    return vetor;
}

void libera_vetor(Vetor* vetor){
    for(int i = 0; i < vetor->tam; i++){
        libera_aluno(vetor->alunos[i]);
    }

    free(vetor->alunos);
    free(vetor);
}

void imprime_vetor(Vetor* vetor){
    for(int i = 0; i < vetor->tam; i++){
        printf("O aluno %s tirou a nota %.2f\n", get_nome(vetor->alunos[i]), get_nota(vetor->alunos[i]));
    }
}

float media_turma(Vetor* vetor){
    float soma = 0.0;
    for(int i = 0; i < vetor->tam; i++){
        soma += get_nota(vetor->alunos[i]);
    }

    return soma / vetor->tam;
}

void imprime_vetor_acima_media_turma(Vetor* vetor){
    float med = media_turma(vetor);
    printf("Alunos acima da media da turma:\n");
    
    for(int i = 0; i < vetor->tam; i++){
        if(get_nota(vetor->alunos[i]) >= med){
            printf("%s\n", get_nome(vetor->alunos[i]));
        }
    }
}

void imprime_csv_aprovados_reprovados(Vetor* vetor){
    FILE *f = fopen("saida.csv", "w");
    if(f == NULL){
        printf("Erro na abertura do arquivo.\n");
        exit(1);
    }

    fprintf(f, "Nome,Nota,Situacao\n");

    for(int i = 0; i < vetor->tam; i++){
        fprintf(f, "%s,%.2f,", get_nome(vetor->alunos[i]), get_nota(vetor->alunos[i]));

        if(get_nota(vetor->alunos[i]) >= MEDIA){
            fprintf(f, "Aprovado\n");
        
        } else{
            fprintf(f, "Prova Final\n");
        }
    }

    fclose(f);
}

void ordena_vetor(Vetor* vetor){
    qsort(vetor->alunos, vetor->tam, sizeof(Aluno*), compara_aluno);
}