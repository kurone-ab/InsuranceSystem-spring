package system.insurance.backend.resource.service;

import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> findAll();
    List<AnnouncementDTO> findAllByAuthor(int id) throws NoEmployeeException;
    List<AnnouncementDTO> findAllByDate(String date);
    List<AnnouncementDTO> findAllByTitle(String title);
}
