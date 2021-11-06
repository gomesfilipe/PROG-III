#ifndef ALUNO_H
#define ALUNO_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct aluno Aluno;

/**
 * @brief Cria um aluno.
 * @param nome Nome do aluno.
 * @param nota Nota do aluno.
 * @return Ponteiro para aluno.
 **/
Aluno* cria_aluno(char* nome, float nota);

/**
 * @brief Pega o nome do aluno.
 * @param aluno Aluno que terá seu nome pego.
 * @return Ponteiro para nome do aluno.
 **/
char* get_nome(Aluno* aluno);

/**
 * @brief Pega a nota do aluno.
 * @param aluno Aluno que terá sua nota pega.
 * @return Nota do aluno.
 **/
float get_nota(Aluno* aluno);

/**
 * @brief Libera um aluno da memória.
 * @param aluno Aluno que será liberado.
 **/
void libera_aluno(Aluno* aluno);

/**
 * @brief Função de callback para auxiliar na ordenação do vetor.
 * @param a Aluno que terá seu nome comparado com outro.
 * @param b Aluno que terá seu nome comparado com outro.
 * @return -1, 0 ou 1 dependendo de qual aluno tem nome maior ou menor alfabeticamente.
 **/
int compara_aluno(const void* a, const void* b);

#endif
