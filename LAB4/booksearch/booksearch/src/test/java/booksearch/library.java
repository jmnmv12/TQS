package booksearch;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class library {
	private final List<Book> store = new ArrayList<>();

	public void addBook(final Book book) {
		store.add(book);
	}

	public List<Book> findBooks(LocalDateTime  from, LocalDateTime to) {


		Date from_out = Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
		Date to_out = Date.from(to.atZone(ZoneId.systemDefault()).toInstant());


		Calendar end = Calendar.getInstance();
		end.setTime(to_out);
		end.roll(Calendar.YEAR, 1);

		return store.stream().filter(book -> {
			return from_out.before(book.getPublished()) && end.getTime().after(book.getPublished());
		}).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
	}
}