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

clean: # Remove pasta com os arquivos objeto, o executável e os arquivos csv usados para input.
	-rm -f -r obj
	-rm -f *.o
	-rm -f $(TARGET)
	-rm -f *.csv

run:
	./vereadores candidatos.csv partidos.csv 15/11/2020
