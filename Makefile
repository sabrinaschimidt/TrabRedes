# Defina as fontes e os alvos
SOURCES = Game.java LogWriter.java SAIServer.java TicTacToeApp.java TicTacToeGame.java TicTacToeP2PGame.java TicTacToePlayer.java User.java
CLASSES = $(SOURCES:.java=.class)

# Defina o comando do compilador Java
JAVAC = javac
JAVA = java

# Alvo padrão para compilar todos os arquivos
all: $(CLASSES)

# Alvo para compilar um arquivo .java em um arquivo .class
%.class: %.java
	$(JAVAC) $<

# Alvo para limpar os arquivos .class gerados
clean:
	rm -f $(CLASSES)

# Alvo para compilar e executar o programa Java
run: all
	$(JAVA) TicTacToeApp
