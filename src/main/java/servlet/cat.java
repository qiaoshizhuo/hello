package servlet;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cat")
public class cat {
    @Id
    @GenericGenerator(name = "generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    @Column(name = "c_id",nullable = false)
    private Integer c_id;
    @Column(name = "c_name")
    private String c_name;

    public cat(Integer c_id,String c_name) {
        this.c_id=c_id;
        this.c_name = c_name;
    }
    public cat() {

    }
    @Override
    public String toString() {
        return "cat{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                '}';
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

}
