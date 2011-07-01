# Control abstractions

# Reducing code duplication
# higher-order functions allow you to condense code
# let you create control abstractions 
# e.g. a f'n to find files matching some criteria
def filesMatching(query: String,
	matcher: (String, String) => Boolean) = {
    for(file <- filesHere; if matcher(file.getName, query))
	yield file
}
# so this function that is passed looks like (String, String) => Boolean
# so you can now different searching methods like:

def filesEnding(query: String) = filesMatching(query, _.endsWith(_))
def filesEnding(query: String) = filesMatching(query, _.contains(_))
# _.endsWith(_) is like (fileName: String, query: String) => fileName.endsWi# th(query)

# Currying
# is applied to multiple argument lists
def plainOldSum(x: Int, y: Int) = x + y
def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2) // 3
# in curriedSum, you get 2 function invocations back to back.
# first function takes 1 for x, and returns a f'n value for the second f'n.
# 
def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2) // 3
val onePlus = curriedSum(1)_
onePlus(2) // 3

# Writing new control structures
# you can make new control structures even though syntax is fixed
# by creating methods that take functions as arguements
def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5) // 7
# double => double, is a f'n that takes 1 double as an arg, and returns
# another double 
def withPrintWriter(file: File)(op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
val file = new File("date.txt")
withPrintWriter(file) {
  writer => writer.println(new java.util.Date)
}
# By-name parameters
var assertionsEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

myAssert(() => 5 > 3)
#converted to by-name looks like:
def byNameAssert(predicate: => Boolean) =
  if assertionsEnabled && !predicate)
    throw new AssertionError
byNameAssert(5 > 3)  # cleaner look to calling it

