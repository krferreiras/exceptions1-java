package com.example.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkiIn;
	private Date checkiOut;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkiIn, Date checkiOut) {
		this.roomNumber = roomNumber;
		this.checkiIn = checkiIn;
		this.checkiOut = checkiOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckiIn() {
		return checkiIn;
	} 

	public Date getCheckiOut() {
		return checkiOut;
	}
	
	public long duration() {
		long diff = checkiOut.getTime() - checkiIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for "
					+ "update must be future dates.";
		}if (!checkOut.after(checkIn)){
			return "Check-out date must be "
					+ "after check-in date.";
		}
		this.checkiIn = checkIn;
		this.checkiOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room "
			+  roomNumber
			+  "\ncheck-in: "
			+  sdf.format(checkiIn)
			+  "\ncheck-out: "
			+  sdf.format(checkiOut)
			+  "\n"
			+  duration()
			+  " nights.";
	}
}
