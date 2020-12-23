package com.sean.chapter8

object ClassDemo02 {

  trait MessageSender {
    def send(msg: String)
  }

  trait MessageReceiver {
    def receive()
  }

  class MessageWorker extends MessageSender with MessageReceiver {
    override def send(msg: String): Unit = println("发送消息:" + msg)

    override def receive(): Unit = println("消息已收到，我很好，谢谢!...")
  }

  def main(args: Array[String]): Unit = {
    val mw: MessageWorker = new MessageWorker
    mw.send("Hello,你好啊！")
    mw.receive()
  }
}
