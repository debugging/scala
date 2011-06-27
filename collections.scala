val greetStrings = new Array[String](3)
// val greetStrings: Array[String] = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = "Bye"
greetStrings(2) = "abc"
// greetStrings.update(2, "abc")

for(i <- 0 to 2) println(greetStrings(i))

var numNames = Array("zero", "one", "two")
var numNames2 = Array.apply("zero", "one", "two")

// scala.List is immutable sequence of objects with same type
// scala.List != java.util.List

val list1 = List(1,2,3)
val list2 = List(4,5,6)
val list3 = list1 ::: list2 // list concatenation
println("list3 is " + list3)

// :: "cons" will prepend
val list4 = 0 :: list3
println("list4 is " + list4) 

val list5 = 1 :: 2 :: 3 :: Nil
println(list5)

someList.count(s => s.length == 4)  // counts items with length == 4
.drop(n) // drops first n elements in list
.dropRight(n)
.exists(s => s == "abc")
.filter(s => s.length == 4) 
.forall(s => s.endsWith("a"))
.foreach(s => print(s))
.head
.init // all but last element
.isEmpty  
.last
.length
.map(s => s + "y")
.mkString(",") // like ruby's join
.remove(s => s.length == 4)
.reverse
.sort( (s,t) => s.charAt(0).toLower < t.charAt(0).toLower)
.tail

# Tuples
# immutable like Lists, but can contain different types unlike Lists
val pair = (99, "Hello")
println(pair._1)  // one based like haskell and ML
println(pair._2)


# sets and maps
# has both mutable and immutable versions of sets and maps
# use same base trait
# scala.collection set
# scala.collection.immutable set/hashset and scala.collection.mutable set/hashset
# appending in an immutable set returns a new set

import scala.collection.mutable.Set

val cars = Set("honda", "ford", "toyota")
cars += "Nissan"  // cars.+=("Nissan")
println(cars)


# maps have 2 sets of trails also, both sharing a parent scala.collection.Map trait
import scala.collection.mutable.Map

val countries = Map[Int, String]()
countries += (1 -> "A")   // (1).->("A")   
countries += (2 -> "B")
countries += (3 -> "C")
println(countries(2))
# -> is a method named ->, returns a 2-element tuple with key and value

# immutable is default map, so if you don't import, it will by default be immutable
var someMap = Map(1 -> "One", 2 -> "Two")





