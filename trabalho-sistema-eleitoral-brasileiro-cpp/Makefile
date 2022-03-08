# ############
# # Exemplo de makefile
# # Prof. João Paulo A. Almeida
# # Programação III
# # 
# # A princípio, você não precisa alterar nada, mas aqui assume-se que o diretório atual
# # é o diretório onde estão os códigos fonte (.cpp).
# #

# # nome do compilador
# CPP = g++

# # opções de compilação
# CFLAGS = -Wall -g
# CPPFLAGS = -std=c++11

# # define lista de arquivos-fonte, assumindo que estão no diretório atual
# FONTES = $(wildcard *.cpp) 

# # define lista dos arquivos-objeto usando nomes da lista de arquivos-fonte
# OBJETOS = $(FONTES:.cpp=.o)

# # nome do arquivo executável
# EXECUTAVEL = vereadores

# ############ alvos
# #
# # use @ antes de todos os comandos, pois é necessário no script de teste
# #

# # alvo principal é o executável  
# all: $(EXECUTAVEL)

# # para linkar o executável, precisamos dos arquivos-objetos
# $(EXECUTAVEL): $(OBJETOS)
# 	@$(CPP) -o $@ $^ 

# # alvo para cada arquivo-objeto depende do código fonte
# # (observação, aqui não estamos capturando as dependências de arquivos .h)
# %.o: %.cpp
# 	@$(CPP) $(CPPFLAGS) -c $(CFLAGS) $^

# # o comando para executar deve especificar sempre como parâmetro divulga.csv	
# run: $(EXECUTAVEL)
# 	@./$(EXECUTAVEL) candidatos.csv partidos.csv 15/11/2020

# # comando para limpeza
# clean: 
# 	@rm *.o vereadores *.csv *.txt

# all:
# 	g++ client/Client.cpp src/*.cpp -o main

# run:
# 	./main

TARGET := vereadores
LIBS := -lm
# CFLAGS := -g -O3 
CFLAGS := -g -O3 -Wno-unused-result
CPPFLAGS = -std=c++11
OBJDIR := obj/
SRCDIR := src/
INCLUDEDIR := include/
INCLUDE_PATHS := -Iinclude
CLI := client/Client.cpp
CC := g++

all: $(TARGET)

SRC = $(wildcard $(SRCDIR)*.cpp)
HEADERS = $(wildcard $(INCLUDEDIR)*.h)

CLIENT = $(OBJDIR)$(basename $(notdir $(CLI)))

OBJECTS := $(SRC:$(SRCDIR)%.cpp=$(OBJDIR)%.o)
OBJECTS += $(CLIENT).o

$(OBJDIR)%.o: $(SRCDIR)%.cpp $(HEADERS)
	@ mkdir -p $(OBJDIR)
	$(CC) $(INCLUDE_PATHS) $(CFLAGS) -c -o $@ $<

$(CLIENT).o: $(CLI)
	$(CC) $(INCLUDE_PATHS) $(CFLAGS) -c -o $@ $<

$(TARGET): $(OBJECTS)
	$(CC) $(INCLUDE_PATHS) $(OBJECTS) $(LIBS) $(CPPFLAGS) -o $@

clean: # Remove pasta com os arquivos objeto e o executável.
	-rm -f -r obj
	-rm -f *.o
	-rm -f $(TARGET)

run: # Executa o programa com valgrind com uma entrada específica.
	valgrind ./$(TARGET) candidatos.csv partidos.csv 15/11/2020
