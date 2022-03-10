TESTES := ../testes/vitória/

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
	./$(TARGET) $(TESTES)in/candidatos.csv $(TESTES)in/partidos.csv 15/11/2020 > teste.txt

# run: # Executa o programa com valgrind com uma entrada específica.
# 	./vereadores candidatos.csv partidos.csv 15/11/2020

diff:
	diff teste.txt $(TESTES)out/output.txt