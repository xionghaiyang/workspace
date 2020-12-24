package com.sean.chapter8

object ClassDemo08 {

  trait Handler {
    def handle(data: String) = {
      println("具体处理数据的代码（例如：转账逻辑）")
      println(data)
    }
  }

  trait DataValidHandler extends Handler {
    override def handle(data: String): Unit = {
      println("校验数据...")
      super.handle(data)
    }
  }

  trait SignatureValidHandler extends Handler {
    override def handle(data: String): Unit = {
      println("校验签名...")
      super.handle(data)
    }
  }

  class Payment extends DataValidHandler with SignatureValidHandler {
    def pay(data: String) = {
      println("用户发起支付请求")
      super.handle(data)
    }
  }

  def main(args: Array[String]): Unit = {
    val pm: Payment = new Payment
    pm.pay("苏明玉给苏大强转账10000元")
  }

}
