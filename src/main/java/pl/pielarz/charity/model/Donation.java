package pl.pielarz.charity.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter number of bags")
    @Min(value = 1, message = "Number of bags must be higher than 1")
    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donation_category",
            joinColumns =
                    {@JoinColumn(name = "donation_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    private User user;

    @NotEmpty(message = "Proszę podaj ulicę.")
    private String street;

    @NotEmpty(message = "Proszę podaj miasto.")
    private String city;

    @NotEmpty(message = "Proszę podaj kod pocztowy.")
    @Column(name = "zip_code")
    private String zipCode;

    @NotEmpty(message = "Proszę podaj numer telefonu.")
    @Pattern(regexp = "^[0-9]{9}$", message = "Telefon ma tylko cyfry.")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Future(message = "Data musi być przyszła")
    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;


    @Column(name = "pick_up_comment")
    private String pickUpComment;
}
