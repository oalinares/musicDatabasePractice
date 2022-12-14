package musicDb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import musicDb.dao.DbConnection;
import musicDb.entity.Artist;
import musicDb.entity.MusicDb;
import musicDb.service.MusicDbService;
import musicDb.exception.DbException;

public class musicDb {
	private Scanner scanner = new Scanner(System.in);
	private MusicDbService musicDbService = new MusicDbService();
	private MusicDb curArtist;
	//@formatter:off
	private List<String> operations = List.of(
			"1) Create and populate tables",
			"2) Add a new Artist"
			);
	//@formatter:on
public static void main(String[] args) {
	new musicDb().processUserSelections();
}
	private void processUserSelections() {
		boolean done = false;
		
		while(!done) {
			try {
				int selection = getUserSelection();
				switch(selection) {
				case -1:
					done = exitMenu();
					break;
				case 1:
					createTables();
					break;
				case 2:
					createArtist();
				break;
					
				}
			} catch (Exception e) {
				System.out.println("\nError: " + e + " Try again.");
			}
		}
	}
	private void createArtist() {
		String name = getStringInput("Enter the artist(s') name");
		Integer initialFormation = getIntInput("Enter the artist(s') intial formation year");
		Double artistRating = getDoubleInput("Enter artist(s') rating from 0 to five, or even 3.5");
		String notes = getStringInput("Enter some details about the artist(s)");
		Boolean active = getBooleanInput("Enter 1 if artist is still active, and 0 if they are inactive.");
		
		Artist artist = new Artist();
		
		artist.setArtistName(name);
		artist.setInitialFormation(initialFormation);
		artist.setNotes(notes);
		artist.setArtistRating(artistRating);
		artist.setActive(active);
		
		Artist dbArtist = musicDbService.addArtist(artist);
		System.out.println("You added this artist:\n" + dbArtist);
		
		//curArtist = musicDbService.fetchArtistById(dbArtist.getArtistId());
		
		
	}
	
	
	private void createTables() {
		musicDbService.createAndPopulateTables();
		System.out.println("\nTables created and populated!");
	}
	/**
	 * Prints out the selection of operations available to the user, and show whether they are currently working with an artist
	 * whenever the menu is instantiated.
	 */
	private void printOperations() {
		System.out.println("These are the available selections. Press the Enter key to quit: ");
		operations.forEach(line -> System.out.println(" " + line));
		
		if(Objects.isNull(curArtist)) {
			System.out.println("\nYou are not working with an artist.");
		} else {
			System.out.println("\nYou are with " + curArtist);
		}
	
	}
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();
		return input.isBlank() ? null : input.trim();
	}
	
	private Double getDoubleInput(String prompt) {
		String input = getStringInput(prompt);
		
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return Double.parseDouble(input);
		}
		catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}
	
	private Boolean getBooleanInput(String prompt) {
		Integer input = getIntInput(prompt);
		try { if(!(input == 1)) {
			return false;
		} else {
				return true;
			}
		
		} catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}
	
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		} catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a menu selection");
		return Objects.isNull(input) ? -1 : input;
	}
	private boolean exitMenu() {
		System.out.println("\nExiting the menu. Goodbye!");
		return true;
	}
}