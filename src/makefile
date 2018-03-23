
.PHONY: run compile clear

JUNIT_JAR=junit-4.12.jar
HAMCREST_JAR=hamcrest-core-1.3.jar

CLASSP=./$(JUNIT_JAR):./$(HAMCREST_JAR):.
MAINCLASS=main/Backend

all: run clear

run: compile
	@java -cp $(CLASSP) $(MAINCLASS) main/transactionFile.txt main/userlist.txt main/itemlist.txt

compile:
	@javac -cp $(CLASSP) main/*.java 

clear:
	@rm main/*.class
