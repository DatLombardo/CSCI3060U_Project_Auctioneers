.PHONY: run compile clear

JUNIT_JAR=junit-4.12.jar
HAMCREST_JAR=hamcrest-core-1.3.jar

CLASSP=./$(JUNIT_JAR):./$(HAMCREST_JAR):.
MAINCLASS=Backend

all: run clear

run: compile
	@java -cp $(CLASSP) $(MAINCLASS) dailyUpdate.txt userList.txt itemList.txt

compile:
	@javac -cp $(CLASSP) *.java

clear:
	@rm *.class
