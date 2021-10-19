package ru.job4j.solid.ocp.example3;

public class Client {
    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    /*
    Класс Client использует класс Server.

    Если мы захотим, чтобы объект класса
    Client мог работать с разными объектами Server,
    нам придётся поменять его код.
    Чтобы решить эту проблему,
    необходимо связывать объекты не напрямую, а через абстракции.
    Если все объекты Server реализуют интерфейс Abstract Server,
    то нам уже не придётся менять код объекта Client для замены одного объекта Server на другой.
     */
}
