
all:
	rm srcs/*.class
	javac srcs/*.java

run:
	java -cp ./srcs/ avaj ./scenario.txt
