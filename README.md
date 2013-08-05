sandbox
=======

tr : projet triangularisation
- projet maven2
- exécuter mvn clean install pour construire le jar 
- l'exécution maven inclue l'execution des tests unitaires (conformité)
- pour lancer le batch indépendemment de maven (séparateur de fichier windows/unix):
- sous windows :
- java -cp "target/technicaltest-0.0.1-SNAPSHOT.jar;target/dependency/commons-lang3-3.1.jar" com.cw.test.Triangularisation src/test/resources/inputfileok.txt
- sous unix/linux :
- java -cp "target/technicaltest-0.0.1-SNAPSHOT.jar:target/dependency/commons-lang3-3.1.jar" com.cw.test.Triangularisation src/test/resources/inputfileok.txt

