package system.insurance.backend.resource.service;

import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.dto.InstructionDTO;

import java.util.List;

public interface SalesService{
    boolean instructionRegister(String title, String instruction);
    List<InstructionDTO> getSalesInstructionList();
    List<Integer> getContractList(int eid) throws NoEmployeeException;
    boolean saveCounselingRecord(String content, int eid) throws NoEmployeeException;
}
