package black.spring.boot.demo.model;


import javax.persistence.*;

/**
 * @author black
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String personName;

    private int personAge;

    private Person(Builder builder) {
        setPersonId(builder.personId);
        setPersonName(builder.personName);
        setPersonAge(builder.personAge);
    }


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }


    public Person() {
    }


    public static final class Builder {
        private int personId;
        private String personName;
        private int personAge;

        public Builder() {
        }

        public Builder personId(int val) {
            personId = val;
            return this;
        }

        public Builder personName(String val) {
            personName = val;
            return this;
        }

        public Builder personAge(int val) {
            personAge = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
