package com.kh.aop.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Weapon {
	protected String name;
	
	public abstract String attack();
}