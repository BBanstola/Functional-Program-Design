package Week4.TimelyEffects.ObserverPattern

class Consolidator(observed: List[BankAcc]) extends Subscriber{

  observed.foreach(_.subscribe(this))

  private var total: Int = _
  compute()

  private def compute()=
    total = observed.map(_.currentBalance).sum

  def handler(pub: Publisher) = compute()

  def totalBalance = total

}
