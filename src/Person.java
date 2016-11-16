import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.ranges.RangeException;

/**
 * Created by Кот on 09.11.2016.
 */
public class Person implements Serializable,Cloneable {
    private final long id;
    private String name;
    private String phone;

    public Person(long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + ": " + phone;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.phone == null) ? (other.phone != null) : !this.phone.equals(other.phone)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        hash = 61 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public long getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }


}

