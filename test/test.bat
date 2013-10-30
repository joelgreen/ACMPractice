@echo off
java -classpath ..\bin p%1 < %1.in > %1.out
kdiff3 %1.out %1.cmp