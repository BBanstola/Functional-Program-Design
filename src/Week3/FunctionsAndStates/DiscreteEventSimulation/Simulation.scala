package Week3.FunctionsAndStates.DiscreteEventSimulation

abstract class Simulation {

  type Action = () => Unit

  case class Event(time: Int, action: Action)

  private var curTime= 0

  def currentTime:Int =curTime

  private var agenda:List[Event]=List()

  private def insert(ag:List[Event], item:Event):List[Event] = ag match {
    case first::rest if (first.time <= item.time) => first ::insert(rest,item)
    case _ =>item:: ag
  }

  def afterDelay(delay :Int)(block: => Unit):Unit ={
    val item = Event(currentTime + delay, () => block )
    agenda = insert(agenda, item)
  }

  def run(): Unit ={
    afterDelay(0){
      println("Simulation started time = "+ currentTime)
    }
    loop()
  }

  private def loop(): Unit = agenda match {
    case first :: rest =>
      agenda = rest
      curTime = first.time
      first.action()
      loop()
    case Nil =>
  }


}
