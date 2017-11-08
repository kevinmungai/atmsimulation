package com

import ATM._

trait Logic extends Transaction {

  def welcome() : Unit = println("Welcome to The First National Bank ATM\n")

  def getCardNumber: Int = {
    println(
      """
        |Please Enter Your ATM Card Number: \n
      """)
    scala.io.StdIn.readInt()

  }

  def getPin: Int = {
    println(
      """
        |Please Enter Your PIN: \n
      """)
    scala.io.StdIn.readInt()
  }

  def authenticate(cardNumber: Int, pin: Int, counter: Int = 3): Boolean =
    cardNumber match {
      case user.cardNumber => {
        pin match {
          case user.pin => true
        }
      }
      case _=> false
    }


  def menu(validated: Boolean): Char = {
    println(
      """
        |Welcome To First National Bank ATM\n
        |You can Perform the following Actions\n
        |w - Withdrawal
        |d - deposit
        |i - balance inquiry
        |c - cancelling transaction
      """)
    scala.io.StdIn.readChar()
  }






  def responseChecker(response: Char) = {
    response match {
      case 'w' => withdrawalHelper
      case 'd' => depositHelper
      case 'i' => balanceInquiryHelper
      case 'c' => false
    }
  }

}
