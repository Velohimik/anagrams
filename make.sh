#! /bin/bash
echo Compiling...
if [ ! -d bin/ ]
then
	mkdir bin/
fi
cd ./src
javac -d ../bin/ ./ua/com/foxminded/anagrams/Main.java
echo ...successfull √
echo Building a jar...
cd ../bin/
jar -cf anagrams.jar ./
mv ./anagrams.jar ../dist/
echo ...successfull √
