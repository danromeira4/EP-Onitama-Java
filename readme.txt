# Autores

Danilo Araújo de Oliveira Romeira - 13725823 
Otavio Silva Gonçalves - 13672384

# Biblioteca do Junit5 utilizada - versão 1.5.2
https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.5.2/

# Arquivos fonte

## Compilação
javac -d out/ -sourcepath src/ src/ep/jogo/onitama/game/*.java

# Testes

## Compilação (precisa compilar primeiro os arquivos fontes)
javac -cp out/:lib/junit-platform-console-standalone-1.5.2.jar -d out -sourcepath test/ test/ep/jogo/onitama/entities/*.java test/ep/jogo/onitama/game/*.java

## Execução
java -jar lib/junit-platform-console-standalone-1.5.2.jar --class-path out --scan-class-path

