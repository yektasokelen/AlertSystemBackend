package yte.intern.alertSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private String url;

    private HttpMethod method;

    private Long period;

    private Long leftperiod;

    @JoinColumn(name = "Situation_id")
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @OrderBy("alertDate")
    private Set<Situation> situations;

}
