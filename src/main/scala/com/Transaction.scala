package com

import com.ATM.{Account, user}

trait Transaction {

  def withdrawalHelper: Account = {
    println(
      """
        |Choose Account To Withdraw From:\n
        |c - Checking Account
        |s - Savings Account
      """)

    scala.io.StdIn.readChar() match {
      case 'c' =>
        println(
          """
            |Put in amount to withdraw:\n
            |
          """)
        val amount = scala.io.StdIn.readInt()
        user.accounts.head.withdraw(amount)

      case 's' =>
        println(
          """
            |Put in amount to withdraw\n
          """)
        val amount = scala.io.StdIn.readInt()
        user.accounts(1).withdraw(amount)
    }
  }


  def depositHelper: Account = {
    println(
      """
        |Choose Account To Deposit to:\n
        |c - Checking Account
        |s - Savings Account
      """)

    scala.io.StdIn.readChar() match {
      case 'c' =>
        println(
          """
            |Put in amount to deposit:\n
            |
          """)
        val amount = scala.io.StdIn.readInt()
        user.accounts.head.deposit(amount)

      case 's' =>
        println(
          """
            |Put in amount to deposit\n
          """)
        val amount = scala.io.StdIn.readInt()
        user.accounts(1).deposit(amount)
    }
  }


  def balanceInquiryHelper: Int = {
    println(
      """
        |Choose Account: \n
        |c - Checking Account
        |s - Savings Account
      """)

    scala.io.StdIn.readChar() match {
      case 'c' =>
        user.accounts.head.balanceInquiry

      case 's' =>
        user.accounts(1).balanceInquiry
    }
  }
}
