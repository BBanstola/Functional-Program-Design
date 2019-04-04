package Week4.TimelyEffects.ObserverPattern

trait Subscriber {

  def handler(pub: Publisher)

}
