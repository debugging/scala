// local functions
// - functions defined inside other functions like local vars
// - can access parameters of their enclosing function
def processFile(filename: String, width: Int) {
  def processLine(filename: String, width: Int, line: String) {

  }

  processLine(...)
}

// first class functions
// - can write functions as unnamed literals and pass them around
//   as values
// - function literals are compiled and instantiated at run-time as a 
//   function value
(x: Int) => x + 1 // f'n mapping any integer x to x + 1

var increase = (x: Int) => x + 1
increase(10)  // 11

val nums = List(-11, 23, 34, 4324, 2344)
nums.foreach((x: Int) => println(x))


// short form function literals
nums.filter((x) => x > 0) // leaving off parameter types

// using target typing, scala knows you are referrring to an integer
// by the target usage

// remove parantheses if not required
nums.filter(x => x > 0)

// placeholder syntax
// use underscores as placeholds for 1+ parameters as long as each
// parameter appears only once in the f'n literal
nums.filter(_ > 0)

// partially applied functions
nums.foreach(println _)  // nums.foreach(x => println(x))
// _ is placeholder for entire parameter list not a single param
// passing any arguments, you apply that function to the arguments
def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1,2,3)
val a = sum _
a(1,2,3) // 6
// short form for a.apply(1,2,3)
val b = sum(1, _: Int, 3)
b(2) // 6

// Closures
(x: Int) => x + more // x is a bound var, more is a free var
// will only work if more is defined for 'more' that is in scope
// - the function value that's created at runtime from this function literal// is called a closure, the act of 'closing' the f'n literal by capturing
// the bindings of its free variables.
(x: Int) -> x + 1 // called a closed term, not really a closure 
// any f'n def with free variables is an open term.
// the f'n value is the end product of the act of closing the open term
// changes to the captured variables are visible outside the clojure

// what if closure accesses some variable with many different copies?
def makeIncrease(more: Int) = (x: Int) => x + more
val inc1 = makeIncrease(1)
val inc2 = makeIncrease(999)
// when the closure is created, the value is captured and stored on the heap// so it outlives the method call
inc1(10) // 11
inc2(10) // 1009

// function calling
def echo(args: String*) = for (arg <- args) println(arg)
// * allows for repeated parameters

// to pass in an array you need to:
echo(arr: _*)  // arr = Array("abc", "123",...)
// each element of the arr will be its own argument

// named arguements allow of different orders of params passed in
speed(time = 10, distance = 100)
speed(distance = 100, time = 10)

// default parameters

def printTime(out: java.io.PrintStream = Console.out,
  divistor: Int = 1) = ....


// Tail recursion

def approx(guess: Double): Double =
  if (isGoodEnogh(guess)) guess
  else approx(improve(guess))

// imperative method using loops may be faster than functional recursive
// style, but may be the same due to compiler effeciencies
// with Tail recursion

// if recursion call is the last thing that happens in the evaluation
// of the function
// detected tail recursion is replaced with a jump back to the beg. of the
// function with new param values
// tail recursion will not build a new stack frame for each call, all
// calls will be in a single frame

// tis is not tail recursion
def blah(x: Int): Int =
  if (x == 0) throw new Exception("blah!")
  else boom(x - 1) + 1

// tail-call optimizations are limited to where a method or nested f'n
// calls itself directly (not via a f'n value) as its last operation, 
// w/o going through a function value or other intermediary

