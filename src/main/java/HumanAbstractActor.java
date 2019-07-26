import akka.actor.AbstractActor;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
public abstract class HumanAbstractActor extends AbstractActor {

    protected final String name;
    protected final SexType sex;
    protected final int age;

    public HumanAbstractActor(String name, SexType sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public SexType getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
