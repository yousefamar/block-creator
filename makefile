JAVAC=javac
#sources = $(wildcard *.java)
#classes = $(sources:.java=.class)

all:
	javac -Xlint:unchecked -d bin -sourcepath src src/blockCreator/Main.java
#$(classes)

clean :
	find . -name "*.class" -type f -delete

#%.class : %.java
#	$(JAVAC) $<
