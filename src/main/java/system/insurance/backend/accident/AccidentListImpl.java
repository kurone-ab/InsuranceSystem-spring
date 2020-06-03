package system.insurance.backend.accident;

import system.insurance.backend.accident.Accident.AccidentInquiryInfo;
import system.insurance.backend.exception.NoAccidentException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class AccidentListImpl extends ArrayList<Accident> implements AccidentList {
	private static final long serialVersionUID = 1L;

	public AccidentListImpl retrieveByClientId(int clientId) {
		return null;
	}

	public boolean createAccident(Accident accident) {
		if (accident != null) {
			return this.add(accident);
		}
		return false;
	}

	public boolean deleteAccident(int accidentId) throws NoAccidentException {
		for (Accident accident : this) {
			if (accident.getId() == accidentId) {
				return this.remove(accident);
			}
		}
		throw new NoAccidentException();
	}

	public boolean updateAccident(Accident accident) {
		if (accident == null) {
			return false;
		}
		this.set(this.indexOf(accident), accident);
		return true;
	}

	public boolean updateTime(int id, Date date) {
		for (Accident accident : this) {
			if (accident.getId() == id) {
				accident.setDate(date);
				return true;
			}
		}
		return false;
	}

	public boolean updateLocation(int id, Point point) {
		for (Accident accident : this) {
			if (accident.getId() == id) {
				accident.setPoint(point);
				return true;
			}
		}
		return false;
	}

	public Accident retrieveByAccidentId(int id) throws NoAccidentException {
		for (Accident accident : this) {
			if (accident.getId() == id) {
				return accident;
			}
		}
		throw new NoAccidentException();
	}

	public boolean updateAccidentType(int id, AccidentType type) {
		for (Accident accident : this) {
			if (accident.getId() == id) {
				accident.setAccidentType(type);
				return true;
			}
		}
		return false;
	}

	public boolean updateInquiryInfo(int id, AccidentInquiryInfo info) {
		for (Accident accident : this) {
			if (accident.getId() == id) {
				accident.setInquiryInfo(info);
				return true;
			}
		}
		return false;
	}

	public AccidentListImpl retrieveByInsuranceId(int insId) {
		return null;
	}
}
