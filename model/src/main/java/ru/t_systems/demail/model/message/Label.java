package ru.t_systems.demail.model.message;

import ru.t_systems.demail.model.user.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "label")
public class Label {

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Label other = (Label) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;
    private String name;
    @OneToMany//(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "label_id")
    private Set<MessageStatuss> status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MessageStatuss> getStatus() {
        return status;
    }

    public void setStatus(Set<MessageStatuss> status) {
        this.status = status;
    }


}