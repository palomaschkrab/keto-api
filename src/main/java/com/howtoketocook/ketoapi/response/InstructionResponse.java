package com.howtoketocook.ketoapi.response;

import com.howtoketocook.ketoapi.model.Instruction;

import lombok.Getter;

@Getter
public class InstructionResponse {
	private Long id;
	private Long index;
	private String step;
	
	public InstructionResponse(Instruction instruction) {
		id = instruction.getId();
		index = instruction.getIndex();
		step = instruction.getStep();
	}
}
