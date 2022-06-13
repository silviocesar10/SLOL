package edu.ifes.ci.si.les.slol.utils;

import java.time.LocalDate;

public class LocalDateOperations {
	 public  String addNDay(String date, int days) {
	 	    return LocalDate
	 	      .parse(date)
	 	      .plusDays(days)
	 	      .toString();
	 	}
}
