import Week4.TimelyEffects.ObserverPattern._

object Observers{
  val a =  new BankAcc
  val b = new BankAcc
  val c = new Consolidator(List(a,b))

  a deposit 500

  b deposit 800

  c.totalBalance

  b withdraw 500

  c.totalBalance
}

