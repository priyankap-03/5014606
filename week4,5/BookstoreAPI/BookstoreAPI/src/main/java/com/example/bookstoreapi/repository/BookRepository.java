package com.example.bookstoreapi.repository;
import com.example.bookstoreapi.entity.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>  {
	
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByTitleContainingAndAuthorContaining(String title, String author);
	
//	public List<Book> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Optional<Book> findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Book save(Book book) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public boolean existsById(Long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
