package org.nirz.reservationApp.service;


import java.util.Optional;

import org.nirz.reservationApp.Dao.AdminDao;
import org.nirz.reservationApp.Dao.BusDao;
import org.nirz.reservationApp.Dto.BusRequest;
import org.nirz.reservationApp.Dto.ResponseStructure;
import org.nirz.reservationApp.Exception.AdminNotFoundException;
import org.nirz.reservationApp.model.Admin;
import org.nirz.reservationApp.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private BusDao busDao;
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Bus>> saveBus(BusRequest busRequest, int admin_id) {
		Optional<Admin> recAdmin = adminDao.findById(admin_id);
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			Bus bus = mapToBus(busRequest);
			bus.setAdmin(recAdmin.get());
			recAdmin.get().getBuses().add(bus);
			adminDao.saveAdmin(recAdmin.get());
			busDao.saveBus(bus);
			return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		}
		throw new AdminNotFoundException("Cannot Add Bus as Admin Id is Invalid");
	}

	public Bus mapToBus(BusRequest busRequest) {
		return Bus.builder().name(busRequest.getName()).busNumber(busRequest.getBusNumber())
				.dateOfDeparture(busRequest.getDateOfDeparture()).from(busRequest.getFrom()).to(busRequest.getTo())
				.numberOfSeats(busRequest.getNumberOfSeats()).build();
	}
}