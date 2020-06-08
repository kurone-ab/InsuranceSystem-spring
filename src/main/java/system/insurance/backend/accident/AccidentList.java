package system.insurance.backend.accident;

import system.insurance.backend.accident.Accident.AccidentInquiryInfo;
import system.insurance.backend.exception.NoAccidentException;

import java.awt.*;
import java.util.Date;

public interface AccidentList {

    AccidentListImpl retrieveByClientId(int clientId);

    boolean createAccident(Accident accident);

    boolean deleteAccident(int accidentId) throws NoAccidentException;

    boolean updateAccident(Accident accident);

    boolean updateTime(int id, Date date);

    boolean updateLocation(int id, Point point);

    Accident retrieveByAccidentId(int id) throws NoAccidentException;

    boolean updateAccidentType(int id, AccidentType type);

    boolean updateInquiryInfo(int id, AccidentInquiryInfo info);

    AccidentListImpl retrieveByInsuranceId(int insId);
}
