package de.stea1th.greetings.entity;


import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class AbstractBaseEntity {

    public static final int START_SEQ = 1000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq",
            allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "global_seq")
    protected Integer id;

    protected AbstractBaseEntity(Integer id){
        this.id = id;
    }
}
