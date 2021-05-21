package com.ms.provider.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Lazy
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String username;

	@Column
	private String name;

	@Column
	private short age;

	@Column
	private BigDecimal balance;


}
