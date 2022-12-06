
javac *.java
java *.class
echo 'Main-Class: App' > app-manifest.txt
java cfm App.jar app-manifest.txt App.class
java -jar App.jar