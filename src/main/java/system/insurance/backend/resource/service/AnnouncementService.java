package system.insurance.backend.resource.service;

import org.springframework.stereotype.Service;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.reponse.ResponseAnnouncementContent;
import system.insurance.backend.resource.reponse.ResponseAnnouncementInfo;

import java.util.List;

@Service
public interface AnnouncementService {
    List<ResponseAnnouncementInfo> findAll();
    List<ResponseAnnouncementInfo> findAllByAuthor(int id) throws NoEmployeeException;
    List<ResponseAnnouncementInfo> findAllByDate(String date);
    List<ResponseAnnouncementInfo> findAllByTitle(String title);
    ResponseAnnouncementContent getContent(int id);
}
