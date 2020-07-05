# Generics

Generics allow you to assign any data type (primitive or not) to an element. So a generic method may accept multiple data types as parameters. There are also generic classes:

This ```GenericsQueue``` class is a generic implementation of a ```StringQueue``` class which only accepts ```Strings```.

```java
    public class GenericsQueue <YourClass> {

	private List<YourClass> elements = new ArrayList<YourClass>();
	
	public GenericsQueue () {
	
	}
    ...

    }

```
- the ```<YourClass>``` part of this code is a generic expression
- you can use any object/data type on, for example ```Integer```, ```String```, a object called ```myDrinks```, etc.

- as you can see, the generic ```<YourClass>``` is also used for the ```elements``` ArrayList to ensure that the data types are compatible.

The advantage of generics is that you do not need to create the same exact class with the same exact methods for every data type under the sun. You will not have to create duplicate classes.

It is usually denoted with a ```<T>``` for "type", it can be named something different though.
