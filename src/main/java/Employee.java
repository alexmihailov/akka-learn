import akka.actor.Props;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public class Employee extends HumanAbstractActor {

    private String role;

    public Employee(String name, SexType sex, int age, String role) {
        super(name, sex, age);
        this.role = role;
    }

    public static Props props(String name, SexType sex, int age, String role) {
        return Props.create(Employee.class, () -> new Employee(name, sex, age, role));
    }

    public static class HelloMessage {

        final long messageId;
        final String message;

        public HelloMessage(long messageId, String message) {
            this.messageId = messageId;
            this.message = message;
        }

        public long getMessageId() {
            return messageId;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "HelloMessage{" +
                    "messageId=" + messageId +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    private long previousMessageId = -1;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(HelloMessage.class, helloMessage -> {
                    if (previousMessageId != helloMessage.messageId) {
                        System.out.println("Employee " + name + " receive " + helloMessage.toString());
                        previousMessageId =  helloMessage.messageId;
                        getSender().tell(new HelloMessage(helloMessage.messageId, "Hello to you too"), getSelf());
                    }
                }).build();
    }
}
