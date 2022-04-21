# CollectionsArrayList
 ![Alt text](https://github.com/loja8614/CollectionsArrayList/CollectionsArrayList/tree/images/ClassDiagram.jpg?raw=true)      

                                                         ,----------------------------------------.                                            
                                                         |List                                    |                                            
                                                         |----------------------------------------|  ,----------------------------------------.
        ,---------------------.                          |+ add(data: String): void;              |  |Node                                    |
        |Iterator             |                          |+ insert(index: int, data: String):void;|  |----------------------------------------|
        |---------------------|                          |+ getAt(index: int):String;             |  |item:String;                            |
        |+ hasNext(): boolean;|                          |+ setAt(index: int, data: String):void; |  |next: Node;                             |
        |+ next(): String;    |                          |+ remove(index: int):void;              |  |prev: Node;                             |
        `---------------------'                          |+ removeAll():void;                     |  |Node(Node:prev,String:element,Node:next)|
                                                         |+ iterator():Iterator;                  |  |                                        |
                                                         |+ size();                               |  `----------------------------------------'
                                                         `----------------------------------------'                                            
                                                                                                                                               
                                                                                                                                               
                        ,---------------------.   ,-------------------------.   ,---------------------.                                        
,--------------------.  |LinkedListIterator   |   |ArrayList                |   |LinkedList           |                                        
|ArrayListIterator   |  |---------------------|   |-------------------------|   |---------------------|                                        
|--------------------|  |- lastReturned: Node;|   |- elementData : String[];|   |- size:int ;         |                                        
|-cursor: int;       |  |- next: Node;        |   |- size: int;             |   |- first:Node;        |                                        
|+ hasNext():boolean;|  |- nextIndex: int;    |   |- grow():void;           |   |- last:Node;         |                                        
|+ next():String;    |  |+ hasNext():boolean; |   |+ iterator():Iterator;   |   |+ iterator():Iterator|                                        
`--------------------'  |+ next():String;     |   `-------------------------'   `---------------------'                                        
                        `---------------------'                                                                                                