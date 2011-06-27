# tips: fsc is a daemon (for scala compiler)
# instance vars default to public
# paramters are vals
# returns are implicitly last value computed in the method
# can't have static members


class ChecksumAccumulator {
  private var sum = 0
  //def add(b: Byte): Unit = sum + b
  def add(b: Byte) { sum += b }
  def checksum(): Unit = ~(sum & 0xFF) + 1
}


# singletons
# use object instead of class
# same name as class, it is called companion object
# must be in same source file as companion class
# can access each others priv vars
# 
# extends a superclass and can mix in traits
# cannot take parameters like classes
# initialized the first time it is accessed 
#  
import scala.collection.mutable.Map

object ChecksumAccumulator {
  private val cache = Map[String, Int]()

  def calculat(s: String): Int = 
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }

}
