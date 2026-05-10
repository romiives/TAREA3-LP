all:
    javac Main.java Mapa/*.java Entidades/*.java Componentes/*.java
run:
    java Main

clean:
    rm -f *.class
	rm -f Mapa/*.class
	rm -f Entidades/*.class
	rm -f Componentes/*.class