sandbox
=======

sandbox
cw : projet triangularisation
- projet maven2
- exécuter mvn clean install pour construire le jar 
- l'excution maven inclue l'execution des tests unitaires (conformité)
- pour lancer le batch indépendemment de maven (séparateur de fichier windows/unix):
- sous windows :
- java -cp "target/technicaltest-0.0.1-SNAPSHOT.jar;target/dependency/guava-14.0.jar;target/dependency/commons-lang3-3.1.jar" com.cw.test.Compute src/test/resources/inputfileok.txt
- sous unix/linux :
- java -cp "target/technicaltest-0.0.1-SNAPSHOT.jar:target/dependency/guava-14.0.jar:target/dependency/commons-lang3-3.1.jar" com.cw.test.Compute src/test/resources/inputfileok.txt

