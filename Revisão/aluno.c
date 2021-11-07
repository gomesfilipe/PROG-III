#include "aluno.h"

struct aluno{
    char* nome;
    float nota;
};

Aluno* cria_aluno(char* nome, float nota){
    Aluno* aluno = (Aluno*) malloc(sizeof(Aluno));
    aluno->nome = strdup(nome);
    aluno->nota = nota;
    return aluno;
}

char* get_nome(Aluno* aluno){
    return aluno->nome;
}

float get_nota(Aluno* aluno){
    return aluno->nota;
}

void libera_aluno(Aluno* aluno){
    free(aluno->nome);
    free(aluno);
}

int compara_aluno(const void* a, const void* b){
    return strcmp((*(Aluno**)a)->nome, (*(Aluno**)b)->nome);
}
