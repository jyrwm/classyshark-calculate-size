# classyshark-calculate-size

The right way to calculate the size any library takes takes inside classes.dex entry is to build classes.dex entry 
having only that library inside. The resulted classes.dex should give us an upper bound

## Steps
As an example, we will calculate how much physical space a retrofit library will occupy inside classes.dex entry. 

1. [Download](https://github.com/borisf/classyshark-calculate-size) ClassyShark Size Calculator

2. Open ClassyShark Size Calculator

![alt text](https://github.com/borisf/classyshark-calculate-size/blob/master/img/SelectJar.png)

Double click on the ClassyShark Size Calculator jar and select your dependency
Once you click the Open button ClassyShark will build classes.dex file from the provided jar.

3. Inspect the result classes.dex with ClassyShark desktop client

![alt text](https://github.com/borisf/classyshark-calculate-size/blob/master/img/ClassyShark.png)

That is it. The size of retrofit inside classes.dex is 75.8 KB versus 88 KB as a separate jar file

## Appendix - Incorrect ways to calculate dependency size
* Jar size - counts the size of dependency encoded with class binary format. Class binary format is totally different from dex binary format (strings, constant pool etc'). More about differences.
* Decompile and count - text != binary, especially with Java's verbose syntax
* Dex count - is an estimator, the larger the method count the larger the dependency size
