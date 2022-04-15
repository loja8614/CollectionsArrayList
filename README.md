# CollectionsArrayList
@startuml
title Collections - Class Diagram
interface Iterator {
+ hasNext(): boolean;
+ next(): String;
}
interface List {
+ add(data: String): void;
+ insert(index: int, data: String):void;
+ getAt(index: int):String;
+ setAt(index: int, data: String):void;
+ remove(index: int):void;
+ removeAll():void;
+ iterator():Iterator;
+ size();
}
class ArrayList implements List{
}
class LinkedList implements List{
}
class ArrayListIterator implements Iterator{
}
class LinkedListIterator implements Iterator{
}
@enduml