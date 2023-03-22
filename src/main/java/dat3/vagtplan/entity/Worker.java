package dat3.vagtplan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Worker {
    @Id
    private String userName;
    private String lastName;
    private double pay;

    @OneToMany(mappedBy = "worker")
    private ArrayList<Shift> shifts;

   /* public Worker(String userName, String lastName, double pay){
        this.userName = userName;
        this.lastName = lastName;
        this.pay = pay;
    }*/

    public Worker(String userName, String lastName, double pay, ArrayList<Shift> shifts){
        this.userName = userName;
        this.lastName = lastName;
        this.pay = pay;
        this.shifts = shifts;
    }

}
