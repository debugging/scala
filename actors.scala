// Actors
// solution to java's hard to deal with shared data and lock model
// share-nothing, message passing model
// a thread-like entity with a mailbox to receieve messages
// subclass scala.actors.actor and implement act method

// send message by using ! method
// sending/rec doesnt' block, sent msg waits in the receivers mailbox


import scala.actors._

object SomeActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("I'm acting")
      Thread.sleep(2000)
    }
  }
}
 
SomeActor.start()

// receiving messages

val echoActor = actor {   // utility method actor, starts right away
  while (true) {
    receive {
      case msg =>
      	println("recieved msg: " + msg)
    }
  }
}

// treating native threads as actors
// actors manage 1+ threads of their own
// use Actor.self to view current thread as an actor
// useful for debugging actors
// self.receiveWithin(milliseconds)

// thread reuse for performance
// threads are expensive to context switch
// call react instead of receive
// react takes partial f'n, react does not return after it finds
// and processes a msg
// react can reuse the current thread for the next actor b/c it doesn't
// need to preserve the call stack of the current thread


