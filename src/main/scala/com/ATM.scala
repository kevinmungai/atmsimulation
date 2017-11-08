package com




object ATM extends Logic {

  sealed trait Account {
    def withdraw(withdrawalAmount: Int): Account =
      this match {
        case CheckingAccount(amount) => CheckingAccount(amount - withdrawalAmount)
        case SavingsAccount(amount) => SavingsAccount(amount - withdrawalAmount)
      }

    def deposit(depositAmount: Int): Account =
      this match {
        case CheckingAccount(amount) => CheckingAccount(amount + depositAmount)
        case SavingsAccount(amount) => SavingsAccount(amount +  depositAmount)
      }

    def transferMoney(account: Account, amountToTransfer: Int): (Account, Account) =
      (this.withdraw(amountToTransfer), account.deposit(amountToTransfer))

    def balanceInquiry: Int =
      this match {
        case CheckingAccount(amount) => amount
        case SavingsAccount(amount) => amount
      }
  }
  final case class CheckingAccount(amount: Int) extends Account
  final case class SavingsAccount(amount: Int) extends Account


  final case class Card(cardNumber: Int, pin: Int, accounts: List[Account])


  val user = Card(
    cardNumber = 1,
    pin = 1,
    accounts = List(CheckingAccount(80000), SavingsAccount(600000))
  )

  def main(args: Array[String]): Unit = {
    welcome()
    responseChecker(menu(authenticate(getCardNumber, getPin)))


  }
}
