/**
  * Created by ravi on 1/16/17.
  */
class notes {

  def main(args: Array[String]): Unit = {
    if(args.length != 0) {
      val key = args(0)
      val value = args(1)
      if(checkForKey(key))
        println("--")
    }
  }

  def checkForKey(key:String): Boolean ={

    true

  }

}
