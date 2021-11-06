#ifndef VETOR_ALUNO_H
#define VETOR_ALUNO_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "aluno.h"

typedef struct vetor Vetor;

/**
 * @brief Cria um vetor de alunos.
 * @param fileName Nome do arquivo que contém os dados de todos os alunos.
 * @return Ponteiro para vetor de alunos.
 **/
Vetor* cria_vetor(char* fileName);

/**
 * @brief Libera um vetor de alunos da memória.
 * @param vetor Vetor de alunos que será liberado.
 **/
void libera_vetor(Vetor* vetor);

/**
 * @brief Imprime um vetor de alunos.
 * @param vetor Vetor de alunos que será impresso.
 **/
void imprime_vetor(Vetor* vetor);

/**
 * @brief Calcula a media das notas de um vetor de alunos.
 * @param vetor Vetor de alunos que terá sua média calculada.
 * @return Media da turma.
 **/
float media_turma(Vetor* vetor);

/**
 * @brief Imprime os nomes dos alunos que estão acima da média da turma.
 * @param vetor Vetor de alunos que terá seus alunos acima da média da turma impressos.
 **/
void imprime_vetor_acima_media_turma(Vetor* vetor);

/**
 * @brief Imprime a situação dos alunos (se estão reprovados ou não) num arquivo csv. 
 * @param vetor Vetor de alunos que terá seus alunos impressos no arquivo csv.
 **/
void imprime_csv_aprovados_reprovados(Vetor* vetor);

void ordena_vetor(Vetor* vetor);

#endif
