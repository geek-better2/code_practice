package com.geekbetter.designpattern.relation.command;

/**
 * 命令模式(command):将一个请求封装为一个对象,从而使你可用不同的
 *  请求对客户进行参数化;对请求排队或者记录请求日志,以及支持可撤销操作
 */
public class CommandClient {
    public static void main(String[] args) {
        Receiver r = new Receiver();
        Command c = new ConcreteCommand(r);
        Invoker i = new Invoker();
        i.setCommand(c);
        i.executeCommand();

    }
}
