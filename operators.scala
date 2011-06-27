// infix operator notation sits between the object and parameter(s)
val a = 5 + 3  // (5).+(3)

# 2 other operator notations
# prefix
val b = -7  // - 
# suffix
val c = 8 toLong // toLong is suffix

-2.0 // (2.0).unary_-

// bitwise
>> 	// shift left
>>>	// unsigned shift right
<<	// shift right

-1 >> 31	// -1
-1 >>> 31	// 1
1 << 2	// 4

// object equality
// automatic null check on the left side of the equality, if its not null, calls equals
// == checks contents/value
// eq checks reference equality like how java does with == for reference types

// execption in precedence rule is the assignment operator '='
// x *= y + 1 is x *= (y+1)

// rich wrappers
// scala.runtime.Rich{Byte, Short, Int, Char, Float, Double, Boolean}
