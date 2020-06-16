package system.insurance.backend.resource.service;

import system.insurance.backend.resource.dto.InstructionDTO;

import java.util.List;

public interface SalesService{
    boolean instructionRegister(String title, String instruction);
    List<InstructionDTO> getSalesInstructionList();
}
