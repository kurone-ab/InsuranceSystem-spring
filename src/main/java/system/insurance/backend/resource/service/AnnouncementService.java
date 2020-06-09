package system.insurance.backend.resource.service;

import org.springframework.stereotype.Service;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.ResponseAnnouncementContent;
import system.insurance.backend.resource.response.ResponseAnnouncement;

import java.util.List;

@Service
public interface AnnouncementService {
    List<ResponseAnnouncement> findAll();
    List<ResponseAnnouncement> findAllByAuthor(int id) throws NoEmployeeException;
    List<ResponseAnnouncement> findAllByDate(String date);
    List<ResponseAnnouncement> findAllByTitle(String title);
    ResponseAnnouncementContent getContent(int id);
}
