package servidor.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "users", 
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    })
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "username", unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @Length(min = 8, max = 120)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean passwordReset;

    private boolean signin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(){

    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isSignin() {
        return signin;
    }

    public void setSignin(boolean signin) {
        this.signin = signin;
    }
}
