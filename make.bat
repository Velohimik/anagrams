@ echo off
chcp 65001 > NUL
echo Compiling...
if NOT EXIST ".\bin\" mkdir .\bin\
cd .\src
javac -d ..\bin\ -cp ".;..\lib\guava-31.1-jre.jar;" .\ua\com\foxminded\anagrams\Main.java
echo ...successfull √
echo Building a jar...
cd ..\bin\
jar -cf anagrams.jar .\ > NUL
move .\anagrams.jar ..\dist\ > NUL
echo ...successfull √