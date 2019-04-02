package Week3.FunctionsAndStates

object account{
  val acc = new BankAccount
  acc deposit 500
  acc withdraw 300
  acc withdraw 500    //throws error
}