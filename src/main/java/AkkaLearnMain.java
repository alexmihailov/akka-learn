import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public class AkkaLearnMain {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("office");

        ActorRef alex = system.actorOf(Employee.props("Alex", SexType.MAN, 23, "developer"));
        ActorRef evgeniy = system.actorOf(Employee.props("Evgeniy", SexType.MAN, 25, "qa"));
        ActorRef masha = system.actorOf(Employee.props("Masha", SexType.WOMAN, 25, "qa"));

        alex.tell(new Employee.HelloMessage(1, "Hello!"), evgeniy);
        masha.tell(new Employee.HelloMessage(2, "Hello!!!"), alex);

        system.terminate();
    }
}
